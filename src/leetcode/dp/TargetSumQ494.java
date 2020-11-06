package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class TargetSumQ494 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1, 1, 1, 1, 1};
		int S = 3;
		int count = new TargetSumQ494().findTargetSumWays(nums, S);
		System.out.println(count);

	}
	
    public int findTargetSumWays(int[] nums, int S) {
    	List<Integer> targetSumsPre = new ArrayList<>();
    	List<Integer> targetSumsAfter = new ArrayList<>();
    	if(nums.length>0) {
    		targetSumsAfter.add(nums[0]);
    		targetSumsAfter.add(-1* nums[0]);
    	}
    	if(nums.length>1) {
    		for(int i=1; i<nums.length;i++) {
    			targetSumsPre = targetSumsAfter;
    			targetSumsAfter = new ArrayList<>();
    			int targetSumslength = targetSumsPre.size();
    			for (int j=0; j<targetSumslength ; j++ ) {
    				int add1 = targetSumsPre.get(j);
    				targetSumsAfter.add(add1 + nums[i]);
    				targetSumsAfter.add(add1 - nums[i]);
    			}
    		}
    	}
    	
    	int count = 0 ;
    	for(Integer tmp : targetSumsAfter ) {
    		if(new Integer(S).equals(tmp)) {
    			count++;
    		}
    	}
    	return count;
        
    }

}
