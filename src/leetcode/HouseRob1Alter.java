package leetcode;

import org.junit.Test;

import junit.framework.Assert;

public class HouseRob1Alter {

	@Test
	public void test() {
		int[] num = { 1, 2, 3, 1 };
		Assert.assertEquals(rob(num), 4);
	}

	@Test
	public void test2() {
		int[] num = { 2, 7, 9, 3, 1 };
		Assert.assertEquals(rob(num), 12);
	}

	public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
		int sums[] = new int[nums.length];
		for (int i = 0; i< nums.length; i++) {
			sums[i]=-1;
		}
		int sum1 = robTotal(nums,nums.length-1,sums);
		
		return sum1;
	}
	public int robTotal(int[] nums,int index, int[] sums) {
		//int sum = 0;
		if(index == 0){
			sums[0]= nums[0];
			return sums[0];
		} else if(index== 1){
			sums[1]= Math.max(nums[0], nums[1]);
			return sums[1];
		}
		else {
			if(sums[index-1]==-1)
				sums[index-1] = robTotal(nums,index-1,sums);
			if(sums[index-2]==-1)
				sums[index-2] = robTotal(nums,index-2,sums);
			return Math.max(sums[index-1],sums[index-2]+nums[index]);
		}
	}
}
