package leetcode.dp;

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
			
			if(root == null)
				return 0;
			else{
				return Math.max(root.val+ ((root.left==null) ? 0 : rob(root.left.left) + rob(root.left.right)) + ((root.right==null) ? 0 : rob(root.right.left) + rob(root.right.right)), rob(root.left)+ rob(root.right));  
			}
				
				
		}

		
				

		}
	
}

