package com.nukernash.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringManipulation {

	public static void main(String args[]){
		
		System.out.println("Get index of anagrams : " + StringManipulation.getIndexOfAnagram("aabaaaaaa",  "ab"));
	}
	
	public static String reverse(String str){
		
		return null;
	}
	
	public static boolean isPalindrome(String str){
			
		return false;
	}
	
	public static List<Integer> getIndexOfAnagram(String s, String p){
		
		List<Integer> index = new ArrayList<Integer>();
		for(int i=0;i<s.length()-p.length()+1;i++){
			if(isAnagram(s.substring(i, i+p.length()), p)){
				index.add(i);
			}
		}
		return index;
	}
	
	public static boolean isAnagram(String a, String b){
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(char c : a.toCharArray()){
			Character ch = Character.valueOf(c);
			if(map.containsKey(ch)){
				map.put(ch, map.get(ch)+1);
			}else{
				map.put(ch, 1);
			}
		}
		for(char c : b.toCharArray()){
			Character ch = Character.valueOf(c);
			if(map.containsKey(ch)){
				map.put(ch, map.get(ch)-1);
			}else{
				return false;
			}
		}
		return map.entrySet().stream().filter(e -> {
			return e.getValue()!=0;
		}).collect(Collectors.toSet()).isEmpty();
	}
	
}
