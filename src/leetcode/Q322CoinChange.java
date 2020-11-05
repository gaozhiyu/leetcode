package leetcode;

public class Q322CoinChange {
	
	private Integer minNotes = Integer.MAX_VALUE;
	private boolean  hasSolution = false; 
    public int coinChange(int[] coins, int amount) {
        
    	java.util.Arrays.sort(coins); 
        coinChange(coins, amount, coins.length-1, 0);
        if(!hasSolution) {
        	return -1;
        }else {
        	return minNotes;
        }
    }
    
    
    public void coinChange(int[] coins, int amount, int index, int numPrev) {
		if(amount==0) {
			hasSolution = true;
			if(numPrev<minNotes) {
				minNotes = numPrev;
			}
		}else {
	    	if(index == 0) {
	    		int cururancy = coins[index];
	
	    		if(amount % cururancy == 0) {
	    			hasSolution = true;
	    			int currnum = numPrev + amount / cururancy;
	    			if(currnum<minNotes) {
	    				minNotes = currnum;
	    			}
	    		}
	    		
	    	} else {
	    	
	
		    	int currancy = coins[index];
		    	for(int j = 0; j<= amount/currancy; j++ ) {
		    		int currnum =  j + numPrev;
		    		coinChange(coins, amount-j*currancy, index-1, currnum);
		    	}
	          
	    	}
		}
          
         
    }
    
    
    
    
    public static void main(String[] args) {
	    int[] coins = {1,2,5}; 
	    int amount = 20;
	    Q322CoinChange object= new Q322CoinChange();
	    int cnt = object.coinChange(coins, amount);
	    System.out.println(cnt);
   
    }
    
    

}
