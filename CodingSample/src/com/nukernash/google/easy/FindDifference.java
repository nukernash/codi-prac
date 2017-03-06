package com.nukernash.google.easy;

/*
 *  Given two strings s and t which consist of only lowercase letters.
 *  String t is generated by random shuffling string s and then add one more letter at a random position.
 *  Find the letter that was added in t.
 *  
 *  Input:
 *  s = "abcd"
 *  t = "abcde"
 *  
 *  Output: e
 *  Explanation:
 *  'e' is the letter that was added.
 * 
 */

public class FindDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findTheDifference("abcd", "abcde"));

	}
	
	public static char findTheDifference(String s, String t) {
        int[] flag = new int[26];
        for(char c : t.toCharArray()){
        	int index = (int)(c)%96;
        	flag[index]++;
        }
        for(char c : s.toCharArray()){
        	int index = (int)(c)%96;
        	flag[index]--;
        }
        char result = '-';
        for(int i=0;i<flag.length;i++){
        	if(flag[i] == 1){
        		result = (char)(i+96);
        	}
        }
		return result;
    }

}