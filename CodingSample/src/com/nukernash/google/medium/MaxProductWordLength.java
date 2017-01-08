package com.nukernash.google.medium;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. 
 * You may assume that each word will contain only lower case letters. If no such two words exist, return 0. 
 * 
 * Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 * Return 16
 * 
 * The two words can be "abcw", "xtfn". 
 */

public class MaxProductWordLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"abc", "dec"};
		maxProduct(words);
		System.out.println(7 & 28);
		System.out.println(1 << 0);
		System.out.println(1 << 1);
		System.out.println(1 << 2);
	}
	
    public static int maxProduct(String[] words) {
    	int max = 0;

        Arrays.sort(words, new Comparator<String>(){
            public int compare(String a, String b){
                return b.length() - a.length();
            }
        });

        int[] masks = new int[words.length]; // alphabet masks

        for(int i = 0; i < masks.length; i++){
            for(char c: words[i].toCharArray()){
                masks[i] |= 1 << (c - 'a');
            }
        }
        System.out.println(Arrays.toString(masks));
    
        for(int i = 0; i < masks.length; i++){
            if(words[i].length() * words[i].length() <= max) break; //prunning
            for(int j = i + 1; j < masks.length; j++){
                if((masks[i] & masks[j]) == 0){
                    max = Math.max(max, words[i].length() * words[j].length());
                    break; //prunning
                }
            }
        }

        return max;
    }

}
