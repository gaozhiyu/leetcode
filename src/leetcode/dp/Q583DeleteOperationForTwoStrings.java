package leetcode.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Q583DeleteOperationForTwoStrings {
	
	

public int minDistance(String word1, String word2) {
		
		HashMap<String, List<Integer>> hashMap= new HashMap<String, List<Integer>>();

    	int comonlength = 0;
    	StringBuffer sb = new StringBuffer();
    	for(int i = 0; i< word1.length();i++ ) {
    		String substr = String.valueOf(word1.charAt(i));
    		if(word2.contains(substr)) {
    			sb.append(substr);
    		}
    	}
    	String word1AfterFiter="";
        String word2AfterFiter="";
    	StringBuffer sb1 = new StringBuffer();
    	for(int i = 0; i< word2.length();i++ ) {
    		String substr = String.valueOf(word2.charAt(i));
    		if(word1.contains(substr)) {
    			sb1.append(substr);
    		}
    	}
        if(sb.length() < sb1.length()){
            word1AfterFiter = sb.toString();
            word2AfterFiter = sb1.toString();
        }else{
            word2AfterFiter = sb.toString();
            word1AfterFiter = sb1.toString();
        }
        System.out.println(word1AfterFiter.length() + " " + word1AfterFiter);
        System.out.println(word2AfterFiter.length() + " " + word2AfterFiter);
    	List<Integer> lastIndex = new ArrayList();
    	List<Integer> maxCommonLength = new ArrayList();
    	List<String> subStringSet = new ArrayList(); 
        List<Integer> lastIndexPro = new ArrayList();
    	List<Integer> maxCommonLengthPro = new ArrayList();
    	List<String> subStringSetPro = new ArrayList();
    	if(word1AfterFiter.length()==0) {
    		return word1.length()+ word2.length();
    	}else {
    		String firstChar = String.valueOf(word1AfterFiter.charAt(0));
    		lastIndex.add(-1);
    		maxCommonLength.add(0);
    		subStringSet.add("");
    		
    		lastIndex.add(word2AfterFiter.indexOf(firstChar));
    		maxCommonLength.add(1);
    		subStringSet.add(firstChar);
    		for(int i =1; i < word1AfterFiter.length();i++ ) {
    			String nextChar = String.valueOf(word1AfterFiter.charAt(i));
    	    	lastIndexPro.clear();
    	    	maxCommonLengthPro.clear();
    	    	subStringSetPro.clear();

    	    	List<Integer> indiceList = getIndices(word2AfterFiter,nextChar,hashMap);
    	    	for(int j = 0; j< subStringSet.size();j++) {
    	    		int lastestIndex =  lastIndex.get(j);
    	    		int latestCommonLength = maxCommonLength.get(j);
    	    		String curSubStr = subStringSet.get(j);
    	    		boolean newelement = false;
    	    		for (Integer index : indiceList) {
    	    			if(index> lastestIndex) {
    	    				latestCommonLength++;
    	    				maxCommonLengthPro.add(latestCommonLength);
    	    				lastIndexPro.add(index);
    	    				subStringSetPro.add(curSubStr + nextChar);
    	    				break;
    	    			}
    	    		}
    	    		
    	    		
    	    	}
    	    	lastIndex.addAll(lastIndexPro);
        		maxCommonLength.addAll(maxCommonLengthPro);
        		subStringSet.addAll(subStringSetPro);
    		}
    		comonlength = maxCommonLength.get(0);
    		for(Integer i : maxCommonLength) {
    			if(i > comonlength) {
    				comonlength = i;
    			}
    		}
    		System.out.println("comonlength : " + comonlength);
    		return word1.length()+ word2.length() - 2 * comonlength;
    		
    		
    	}
    	
    }
	
    
    public List<Integer> getIndices(String word, String charecter,HashMap<String, List<Integer>> hashMap){
    	if(hashMap.get(charecter)!=null)
    		return hashMap.get(charecter);
    	List<Integer> indices = new ArrayList();
    	int fromIndex = -1;
    	while(true) {
    		fromIndex = word.indexOf(charecter, fromIndex+1);
    		if(fromIndex < 0) {
    			break;
    		}
    		indices.add(fromIndex);
    		//System.out.println(fromIndex);
    	}
    	if(indices.size()>0)
    		hashMap.put(charecter, indices);
    	return indices;
    }
    
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Q583DeleteOperationForTwoStrings obj = new
		 * Q583DeleteOperationForTwoStrings(); List<Integer> intList =
		 * obj.getIndices("hello","l"); for(Integer i : intList) {
		 * System.out.println(i); } List<Integer> intList2 =
		 * obj.getIndices("hello","l"); for(Integer i : intList2) {
		 * System.out.println(i); }
		 */
    	String str1= "szwokpjlgqgogbgpjaczcmtjhzgldwinqfxbcxgghitcinmtdwnnpsmnmhfrhrgwncvcizaze";
    	String str2= "spjlqggpzcgdxxtdwnrvca";
    	
		//int minDistance = new Q583DeleteOperationForTwoStrings().minDistance("pneumonoultramicroscopicsilicovolcanoconiosis","ultramicroscopical");
    	int minDistance = new Q583DeleteOperationForTwoStrings().minDistance(str1,str2);
		System.out.println("minDistance : " + minDistance);
	}
    
    /*
    public int minDistance(String word1, String word2) {
    	
    	int currPos = -1 ;
    	int comonlength = 0;
    	int maxLength = 0;
    	
        
    	for (int i =0; i < word1.length()-1; i++) {
    		String currChar = word1.substring(i, i+1);
    		currPos = word2.indexOf(currChar);
    		comonlength = 0; 
    		if(currPos < 0) {
    			continue;
    		}else {
    			comonlength++;
	    		for (int j = i+1 ; j < word1.length(); j++) {
	    			String nextChar =   word1.substring(j, j+1);
	    			getIndices(word2,nextChar);
	    			List<Integer> indiceList = hashMap.get(nextChar);
	    			if(indiceList!=null) {
	    				boolean notfound = true;
	    				for(Integer integer : indiceList) {
	    					if(integer > currPos) {
	    						currPos = integer;
	    						comonlength++;
	    						break;
	    					}
	    				}
	    			}
	    			
	    		}
	    	}
    		if(comonlength > maxLength) {
    			maxLength = comonlength;
    		}
    	}
    	if(word1.length()>0) {
	    	String lastChar = word1.substring(word1.length()-1);
	    	if(word2.contains(lastChar)) {
	    		if(maxLength < 1) {
	    			maxLength = 1;
	    		}
	    	}
    	}
    	System.out.println("maxLength : " + maxLength);
    	return word1.length()+ word2.length()- 2* maxLength;
    }
    */

}
