package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class Q376WiggleSubsequence {

	public int wiggleMaxLength(int[] nums2) {

		List<Integer> intList = new ArrayList<>();
		for (int i = 0; i < nums2.length; i++) {
			if (intList.size() == 0) {
				intList.add(nums2[i]);
			} else {
				int temp = intList.size();
				if (intList.get(temp - 1) != nums2[i]) {
					intList.add(nums2[i]);
				}
			}
		}
		Integer[] nums = intList.toArray(new Integer[0]);

		int length = nums.length;
		if (length < 2) {
			return length;
		}
		int[] bcnt = new int[length];
		int[] scnt = new int[length];
		bcnt[0] = 1;
		scnt[0] = 1;
		for (int i = 1; i < length; i++) {
			int bcount = bcnt[0];
			int scount = scnt[0];
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					// previous is bigger
					if (scnt[j] + 1 > bcount) {
						bcount = scnt[j] + 1;
					}
				} else {
					if (bcnt[j] + 1 > scount) {
						scount = bcnt[j] + 1;
					}
				}
			}
			bcnt[i] = bcount;
			scnt[i] = scount;
		}
		int max = -1;
		for (int i = 0; i < length; i++) {
			max = Math.max(max, scnt[i]);
			max = Math.max(max, bcnt[i]);
		}
		return max;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] nums = {1,7,4,9,2,5};
		int[] nums = { 3, 3, 3, 2, 5,1 ,3};
		// int[] nums = {1,17,5,10,13,15,10,5,16,8};
		// int[] nums = {1,1};
		System.out.print(new Q376WiggleSubsequence().wiggleMaxLength(nums));

	}

}
