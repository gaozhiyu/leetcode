package leetcode;

import java.util.HashMap;

public class HouseRob3 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Solution {
	    
		public int rob(TreeNode root) {
			HashMap<TreeNode, Integer> sumHash = new HashMap<TreeNode, Integer>();
			if(root == null)
				return 0;
			else 
				return robAtParent(root,root.left, root.right, sumHash);
		}

		public int robAtParent(TreeNode parent, TreeNode leftChild, TreeNode rightChild,
				HashMap<TreeNode, Integer> sumHash) {
			{
				
				int grandsonSum = 0;
				int sonSum = 0;
				if (leftChild != null) {
					
					if (leftChild.left != null) {
						TreeNode leftGrandson1 = leftChild.left;
						if (sumHash.get(leftGrandson1) != null) {
							grandsonSum += sumHash.get(leftGrandson1);
						} else {
							// recursivecall
							grandsonSum +=robAtParent(leftGrandson1,leftGrandson1.left,leftGrandson1.right,sumHash);
						}
					}
					
					if (leftChild.right != null) {
						TreeNode leftGrandson2 = leftChild.right;
						if (sumHash.get(leftGrandson2) != null) {
							grandsonSum += sumHash.get(leftGrandson2);
						} else {
							// recursivecall
							grandsonSum +=robAtParent(leftGrandson2, leftGrandson2.left, leftGrandson2.right, sumHash);
						}
					}
					
					if(sumHash.get(leftChild)!=null){
						sonSum += sumHash.get(leftChild);
					}else{
						sonSum += robAtParent(leftChild, leftChild.left, leftChild.right, sumHash);
					}
				}
				if (rightChild != null) {
					
					if (rightChild.left != null) {
						TreeNode rightGrandson1 = rightChild.left;
						if (sumHash.get(rightGrandson1) != null) {
							grandsonSum += sumHash.get(rightGrandson1);
						} else {
							grandsonSum += robAtParent(rightGrandson1, rightGrandson1.left, rightGrandson1.right, sumHash);
						}
					}
					
					if (rightChild.right != null) {
						TreeNode rightGrandson2 = rightChild.right;
						if (sumHash.get(rightGrandson2) != null) {
							grandsonSum += sumHash.get(rightGrandson2);
						} else {
							grandsonSum +=robAtParent(rightGrandson2, rightGrandson2.left, rightGrandson2.right, sumHash);
						}
					}
					
					if(sumHash.get(rightChild)!=null){
						sonSum += sumHash.get(rightChild);
					}else{
						sonSum += robAtParent(rightChild, rightChild.left, rightChild.right, sumHash);
					}

				}
				
				

				int max = Math.max(parent.val + grandsonSum, sonSum);
				if (sumHash.get(parent) == null) {
					sumHash.put(parent, max);
				}
				return max;
			}

		}
	
}

}
