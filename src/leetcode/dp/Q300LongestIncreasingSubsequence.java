package leetcode.dp;

public class Q300LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
    	
    	//int tempcount = 1;
    	int[] cnt= new int[nums.length];
    	cnt[0]=1;
    	int supermax = 1;
        for(int i = 1; i < nums.length ; i++) {
        	int maxcount =1 ;
        	for(int j = 0 ; j< i ; j++) {
        		
        		if(nums[i] > nums[j]) {
        			if(cnt[j]+1 > maxcount) {
        				maxcount = cnt[j]+1;
        			}
        		}
        		 
        	}
        	cnt[i] = maxcount;
        	if(cnt[i]> supermax)
        		supermax= cnt[i];
        	
        }
        
        return supermax;
    }
    
    public static void main(String[] args) {
    	int[] nums = {10,9,2,5,3,7,101,18};
    	System.out.println(new Q300LongestIncreasingSubsequence().lengthOfLIS(nums));
    }
    
    
}
