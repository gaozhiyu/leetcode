package leetcode.dp;

import org.junit.Test;

import junit.framework.Assert;

public class HouseRob1 {

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
		int sums[] = new int[nums.length];
		for (int i = 0; i< nums.length; i++) {
			sums[i]=0;
		}
		return robTotal(nums,sums);
	}
	public int robTotal(int[] nums, int sums[]) {
		//int sum = 0;
		for (int i = 0; i< nums.length; i++) {
			robRecAtIndex(i, nums, sums);
		}
		if(nums.length>0) 
		    return sums[nums.length-1];
        else
            return 0;
	}
	
	public void robRecAtIndex(int index,  int[] nums, int[] sums) {
		if(index == 0) {
			sums[index] = nums[index];
			//return nums[index];
		} else if(index == 1){
			int sum = Math.max(nums[index],sums[index-1]);
			sums[index] = sum;
		}  else {
			sums[index] = Math.max(sums[index-1], sums[index-2]+nums[index]);
		}
	}
/*
	public int robRec(boolean robflag, int index, int length, int[] nums, int sum) {
		// index-1 robbed
		if (robflag) {
			if (index == length - 2) {
				// sum += Math.max(nums[index], nums[index + 1]);
				sum += nums[index + 1];
			} else if (index == length - 1) {
				return sum;
			} else if (index >= length) {
				return sum;
			} else {
				sum += robRec(false, index + 2, length, nums, sum);
				return sum;
			}
		} else {
			// rob index
			if (index == length - 2) {
				// sum += Math.max(nums[index], nums[index + 1]);
				sum += Math.max(nums[index], nums[index + 1]);
				return sum;
			} else if (index == length - 1) {
				return sum += nums[index];
			} else if (index > length - 1) {
				return sum;
			} else {
				int robCurr = robRec(true, index + 1, length, nums, sum);
				int robNext = robRec(true, index + 2, length, nums, sum);
				if (robCurr + nums[index] > robNext+ nums[index+1]) {
					sum += nums[index] + robCurr;// robRec(true,index+1,length,
													// nums, sum);
				} else {
					sum += nums[index + 1] + robNext;// robRec(true,index+2,length,
														// nums, sum);
				}
				return sum;
			}
		}
		return sum;
	}
*/
}
