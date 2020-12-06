package leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Q543DiameterBinaryTree {
	
	HashMap<TreeNode, Integer> heights = new HashMap();
	
	public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
		calculateHeight(root);
		int max = 0;
		for(TreeNode key : heights.keySet()) {
			int left = key.left==null? 0 : heights.get(key.left);
			int right = key.right == null ? 0 : heights.get(key.right);
			if(left+right+1 > max) {
				max = left + right + 1;
			}
		}
		return max;
	
	}
	
	public int calculateHeight(TreeNode tr) {
		int left = 0;
		if(tr.left==null) {
			left = 0 ;
		}else {
			if(heights.containsKey(tr.left.val))
				left = heights.get(tr.left.val);
			left = calculateHeight(tr.left);
		}
		int right = 0;
		if(tr.right==null) {
			right = 0;
		}else {
			if(heights.containsKey(tr.right.val))
				right = heights.get(tr.right.val);
			right = calculateHeight(tr.right);
		}
		int height = Math.max(left, right)+ 1;
		heights.put(tr,height);
		return height;
	}
	
	public List<TreeNode> DFS (TreeNode node, int value) {
		Stack<TreeNode> stack = new Stack();
		HashMap<Integer, Integer> visited = new HashMap();
		List<TreeNode> resultList = new ArrayList<TreeNode>();
		while(true) {
			
			visited.put(node.val, 1);
			if(node.val!=value) {
				TreeNode parentNode = node;
				node= getFirstUnvisitedNode(node,visited);
				if(node==null) {
					if(stack.isEmpty())
						return resultList;
					else 
						node = stack.pop();
				}else {
					stack.push(parentNode);
				}
			}else {
				
				resultList.add(node);
				while(!stack.isEmpty()) {
					resultList.add(stack.pop());
				}
				return resultList;
			}
			
		}
	}

	private TreeNode getFirstUnvisitedNode(TreeNode node, HashMap<Integer, Integer> visited) {
		// TODO Auto-generated method stub
		if(node.left!=null) {
			if(!visited.containsKey(node.left.val)) {
				return node.left;
			}
				
		}
		if(node.right!=null) {
			if(!visited.containsKey(node.right.val)) {
				return node.right;
			}
				
		}
		
		return null;
	}

	//Definition for a binary tree node

	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {
			
		}
		TreeNode(int val) { 
			this.val = val; 
		}
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	public static void main (String[] args) {
		Q543DiameterBinaryTree thisO = new Q543DiameterBinaryTree();
		int[] intArray = {1,2,3,4,5,6,7};
		List<TreeNode> treeList = new ArrayList<>();
		for(int i = 0; i< intArray.length;i++) {
			TreeNode tr = thisO.new TreeNode(intArray[i]);
			treeList.add(tr);
		}
		treeList.get(0).left = treeList.get(1);
		treeList.get(0).right = treeList.get(2);
		treeList.get(1).left = treeList.get(3);
		treeList.get(1).right = treeList.get(4);
		treeList.get(2).left = treeList.get(5);
		treeList.get(2).right = treeList.get(6);
		treeList.get(5).right = thisO.new TreeNode(8); 
		treeList.get(5).right.right = thisO.new TreeNode(9); 
		
//		List<TreeNode> list = thisO.DFS(treeList.get(0), 9);
//		
//		for(TreeNode tn : list) {
//			System.out.println(tn.val);
//		}
		
		int diameter = thisO.diameterOfBinaryTree(treeList.get(0));
		System.out.println(diameter);

		
		
		
	}


}


