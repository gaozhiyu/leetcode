package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class Q279PerfectSquares {
	List<Integer> squareList = new ArrayList<>();
	int mincount =1 ;
	
    public int numSquares(int n) {
    	mincount = n;
    	for(int i=1;i<n/2+1;i++) {
    		if(n >= i*i) {
    			squareList.add(i*i);
    		}
    	}
        if(squareList.contains(n)) {
    		return 1;
    	}
    	recursiveCount(n,0);
    	return mincount;
    }
    
    public void recursiveCount(int remainValue, int count) {
    	if(remainValue==0) {
    		if(count < mincount)
    			mincount = count;
    	}else {
	    	for(int i= 0;i< squareList.size();i++) {
	    		int num = squareList.get(i);
	    		if(num <=remainValue) {
	    			recursiveCount(remainValue-num,count+1);
	    		}
	    	}
    	}
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(new Q279PerfectSquares().numSquares(49));
	}

}
