package leetcode;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class HouseRob2 {

	@Test
	public void test() {
		int[] num = { 2,3,2 };
		Assert.assertEquals(rob(num), 3);
	}

	@Test
	public void test2() {
		int[] num = { 1,2,3,1 };
		Assert.assertEquals(rob(num), 4);
	}

	public int rob(int[] nums) {
		int length = nums.length;
		if(length==0) {
			return 0;
		}else if(length == 1){
			return nums[length-1];
		}else {
			int sums[] = new int[nums.length];
			for (int i = 0; i< nums.length; i++) {
				sums[i]=0;
			}
			int firstRob = robTotal( nums, sums,2, nums.length-2);
			int sum2[] = new int[nums.length];
			for (int i = 0; i< nums.length; i++) {
				sum2[i]=0;
			}
			int firstNot = robTotal( nums, sum2,1, nums.length-1); 
			int finalResult = Math.max(nums[0]+firstRob,firstNot);
			return finalResult;
		}
		
	}
	public int robTotal(int[] nums, int sums[],int start, int end) {
		//int sum = 0;
		for (int i = start; i< end+1; i++) {
			robRecAtIndex(i, nums, sums);
		}
		return sums[end];
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
