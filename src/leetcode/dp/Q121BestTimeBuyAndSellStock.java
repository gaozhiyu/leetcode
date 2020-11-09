package leetcode.dp;

public class Q121BestTimeBuyAndSellStock {
	
	private int maxBef = 0;

	
	
    public int maxProfit(int[] prices) {
        
        for(int i =0; i< prices.length-1; i++) {
        	for(int j =i+1; j< prices.length; j++) {
        		if(prices[j]-prices[i]> maxBef) {
        			maxBef = prices[j]-prices[i];
        		}
        	}		
        }
        return maxBef;
    }
    
	public static void main(String[] args) {
		int[] prices = {1,2};
		System.out.println(new Q121BestTimeBuyAndSellStock().maxProfit(prices));
		
	}
}
