package leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorldBreak139 {
	public boolean globalResult = false;
    public boolean wordBreak(String s, List<String> wordDict) {
    	if(singleElementExist(s, wordDict))
    		return true;
    	recursiveCall(s, wordDict);
        return this.globalResult;
    }
    
    public void recursiveCall(String s, List<String> wordDict) {
    	for(int i = 0; i< wordDict.size();i++) {
    		if((""+s).equals(wordDict.get(i))){
    			this.globalResult = true;
    			return;
    		} else if((""+s).startsWith(wordDict.get(i))) {
    			recursiveCall((""+s).substring((""+wordDict.get(i)).length()),wordDict);
    		}
    	}
    }
    
    public boolean singleElementExist(String s, List<String> wordDict){
    	List<String> singleElement = new ArrayList<>();
    	boolean result = true;
    	for (int i=0; i<s.length();i++) {
    		String str = String.valueOf(s.charAt(i));
    		if(!wordDict.contains(str)) {
    			result =false;
    			break;
    		}
    	}
    	return result;
    }
    
    
    public static void main(String[] args) {
    	String str = "HelloWord";
    	String substr = "Hello";
    	String chop = str.substring(substr.length());
    	//System.out.println(chop);
    	String s = "acaaaaabbbdbcccdcdaadcdccacbcccabbbbcdaaaaaadb";
    			//[]
    	String[] wordDict = {"abbcbda","cbdaaa","b","dadaaad","dccbbbc","dccadd","ccbdbc","bbca","bacbcdd","a","bacb","cbc","adc","c","cbdbcad","cdbab","db","abbcdbd","bcb","bbdab","aa","bcadb","bacbcb","ca","dbdabdb","ccd","acbb","bdc","acbccd","d","cccdcda","dcbd","cbccacd","ac","cca","aaddc","dccac","ccdc","bbbbcda","ba","adbcadb","dca","abd","bdbb","ddadbad","badb","ab","aaaaa","acba","abbb"};
    	List<String> strList = Arrays.asList(wordDict); 
    	//boolean result = new WorldBreak139().wordBreak(s, strList) ;
    	boolean result = new WorldBreak139().singleElementExist(s, strList) ;
    	System.out.println(result);
    }
}
