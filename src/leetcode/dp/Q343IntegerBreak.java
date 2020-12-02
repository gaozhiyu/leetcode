package leetcode.dp;

public class Q343IntegerBreak {
	
	int maxproduct = 1;
    public int integerBreak(int n) {
    	if(n<3)
    		return 1;
    	if(n==3)
    		return 2;
    	recursiveIntegerCall(n,1);
        return maxproduct;
    }
    
    public void recursiveIntegerCall(int n, int product){
    	//System.out.println("Product is "+ product);
    	if(n<4) {
    		if(product*n>maxproduct) {
    			maxproduct = product*n;
    		}
    	}else {
    		//for(int i=2;i<n;i++) { if not math
	    	for(int i=2;i<5;i++) {
	    		recursiveIntegerCall(n-i,product*i);
	    	}
    	}
    }
    
    public static void main(String[] args) {
    	System.out.print(new Q343IntegerBreak().integerBreak(8));
    }
	
}
