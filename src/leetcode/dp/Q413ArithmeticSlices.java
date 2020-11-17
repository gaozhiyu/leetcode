package leetcode.dp;

import java.util.HashMap;

public class Q413ArithmeticSlices {
	
    public int numberOfArithmeticSlices(int[] A) {
    	java.util.HashMap<Integer, Integer > hm = new java.util.HashMap();
    	int count = 0;
    	for (int i = 0; i < A.length ;i++){
    		hm.put(A[i], A[i]);
    	}
    	
    	for (int i = 0; i < A.length-1; i++) {
    		for (int j = i+1; j < A.length; j++) {
    			int max = Math.max(A[i],A[j]);
    			int min = Math.min(A[i],A[j]);
    			int diff = max - min;
    			while(diff>0) {
    				max = max + diff;
    				if(hm.get(max)!=null) {
    					count++;	
    				}else {
    					break;
    				}
    			}
    		}
    	}
    	
    	return count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 4,5,6};
		int count = new Q413ArithmeticSlices().numberOfArithmeticSlices(arr);
		System.out.println(count);

	}

}
