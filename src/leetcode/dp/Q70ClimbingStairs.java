package leetcode.dp;

public class Q70ClimbingStairs {

	public int count= 0;
    public int climbStairs(int n) {
    	recusiveClimb(n);
    	return count;
    }
    
    public void recusiveClimb(int n){
    	if(n==0) {
    		count++;
    	}else 
        for (int i =1;i <3 ; i++) {
        	if(i<=n) {
        		climbStairs(n-i);
        	}
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(new Q70ClimbingStairs().climbStairs(3));
	}

}
