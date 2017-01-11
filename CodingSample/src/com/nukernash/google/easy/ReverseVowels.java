package com.nukernash.google.easy;

import java.util.HashSet;
import java.util.Set;

/*
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * 
 * Example 1:
 * Given s = "hello", return "holle".
 * 
 * Example 2:Given s = "leetcode", return "leotcede".
 * 
 * Note: The vowels does not include the letter "y".
 *  
 */
public class ReverseVowels {

	public static void main(String[] args) {
		System.out.println(reverseVowels("hello"));
		System.out.println(reverseVowels("leetcode"));
		

	}
	
	public static String reverseVowels(String s) {
		Set<Character> vowels = new HashSet<Character>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		vowels.add('A');
		vowels.add('E');
		vowels.add('I');
		vowels.add('O');
		vowels.add('U');
		if(s == null || s.isEmpty()){
			return s;
		}
		char[] str = s.toCharArray();
		int i=0;
		int j=s.length()-1;
		while(j>i){
			if(!vowels.contains(str[i])){
				i++;
				continue;
			}
			if(!vowels.contains(str[j])){
				j--;
				continue;
			}
			char temp = str[i];
			str[i] = str[j];
			str[j] = temp;
			i++;
			j--;
			
		}
		return new String(str);
	}

}
