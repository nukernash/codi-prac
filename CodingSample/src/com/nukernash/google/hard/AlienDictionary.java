package com.nukernash.google.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * 
 *  	269  There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. 
 * You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language. 
 * Derive the order of letters in this language.
 * 
 *  [
 *  "wrt",
 *  "wrf",
 *  "er",
 *  "ett",
 *  "rftt"
 *  ]
 *  
 *  output : The correct order is: "wertf".
 */

public class AlienDictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"wrt",
				  "wrf",
				  "er",
				  "ett",
				  "rftt"}; 
		System.out.println(alienOrder(words));

	}
	
	public static String alienOrder(String[] words) {
		Map<Character, Set<Character>> map=new HashMap<Character, Set<Character>>();
	    Map<Character, Integer> degree=new HashMap<Character, Integer>();
	    String result="";
	    if(words==null || words.length==0) return result;
	    for(String s: words){
	        for(char c: s.toCharArray()){
	            degree.put(c,0);
	        }
	    }
	    System.out.println(degree);
	    for(int i=0; i<words.length-1; i++){
	        String cur=words[i];
	        String next=words[i+1];
	        int length=Math.min(cur.length(), next.length());
	        for(int j=0; j<length; j++){
	            char c1=cur.charAt(j);
	            char c2=next.charAt(j);
	            if(c1!=c2){
	                Set<Character> set=new HashSet<Character>();
	                if(map.containsKey(c1)) set=map.get(c1);
	                if(!set.contains(c2)){
	                    set.add(c2);
	                    map.put(c1, set);
	                    degree.put(c2, degree.get(c2)+1);
	                }
	                break;
	            }
	        }
	    }
	    System.out.println(map);
	    System.out.println(degree);
	    Queue<Character> q=new LinkedList<Character>();
	    for(char c: degree.keySet()){
	        if(degree.get(c)==0) q.add(c);
	    }
	    System.out.println(q);
	    while(!q.isEmpty()){
	        char c=q.remove();
	        result+=c;
	        if(map.containsKey(c)){
	            for(char c2: map.get(c)){
	                degree.put(c2,degree.get(c2)-1);
	                if(degree.get(c2)==0) q.add(c2);
	            }
	        }
	    }
	    System.out.println(degree);
	    if(result.length()!=degree.size()) return "";
	    return result;
    }

}
