package com.nukernash.google.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * 
 */
public class Strobogramatic {

	public static void main(String[] args) {
		
//		System.out.println(isStrobogrammatic("818"));
//		System.out.println(isStrobogrammatic("69"));
//		System.out.println(isStrobogrammatic("96"));
//		System.out.println(isStrobogrammatic("88"));
//		System.out.println(isStrobogrammatic("123"));
//		System.out.println(isStrobogrammatic("121"));
//		System.out.println(isStrobogrammatic("1"));
		
		System.out.println(findStrobogrammatic(0));
		System.out.println(findStrobogrammatic(1));
		System.out.println(findStrobogrammatic(2));
		System.out.println(findStrobogrammatic(3));
		
	}
	
	/*
	 * Given a number return if the number is strobogramtic.
	 * 
	 * 
	 */
	public static boolean isStrobogrammatic(String num) {
		if(num.length()>1){
	        for(int i=0;i<num.length()/2;i++){
	            if((num.charAt(i) == '8' && num.charAt(num.length()-1-i) == '8')
	            		|| (num.charAt(i) == '6' && num.charAt(num.length()-1-i) == '9')
	            		|| (num.charAt(i) == '9' && num.charAt(num.length()-1-i) == '6')
	            		|| (num.charAt(i) == '1' && num.charAt(num.length()-1-i) == '1')
	            		|| (num.charAt(i) == '0' && num.charAt(num.length()-1-i) == '0')){
	            	continue;
	            } else {
	            	return false;
	            }
	        }
        }
        return true && (num.length()%2 == 0 
        		|| num.charAt(num.length()/2) == '1' 
        		|| num.charAt(num.length()/2) == '8'
        		|| num.charAt(num.length()/2) == '0');
    }
	
	/*
	 * Find all strobogrammatic numbers that are of length = n.
	 * For example,
	 *  
	 * Given n = 2, return ["11","69","88","96"]. 
	 * 
	 */
	public static List<String> findStrobogrammatic(int n) {
		return findStrobogrammatic(n, true);
	}
	
	public static List<String> findStrobogrammatic(int n, boolean isOuter) {
        List<String> result = new ArrayList<String>();
        if(n == 0){
        	result.add("");
        	return result;
        }
        if(n == 1){
        	List<String> reversibleInts = new ArrayList<String>();
        	reversibleInts.add("1");
        	reversibleInts.add("0");
        	reversibleInts.add("8");
        	return reversibleInts;
        }
        Map<String, String> pairs = new HashMap<String, String>();
        pairs.put("6", "9");
        pairs.put("9", "6");
        pairs.put("8", "8");
        if(!isOuter){
        	pairs.put("0", "0");
        }
        pairs.put("1", "1");
        
    	for(Entry<String, String> e : pairs.entrySet()){
    		List<String> subset = findStrobogrammatic(n-2, false);
    		for(String sub : subset){
    			result.add(new StringBuffer().append(e.getKey()).append(sub).append(e.getValue()).toString());
    		}
    	}
        return result;
    }

}
