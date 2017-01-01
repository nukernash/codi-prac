package com.nukernash.google.medium;

import java.util.ArrayList;
import java.util.List;

/*
 * Given word = "word", return the following list (order does not matter):
 * 
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 * 
 */


public class GeneralizedAbbreviation {

	public static void main(String[] args) {
		
		System.out.println(generateAbbreviations("word"));
		//System.out.println(generateAbbreviations("words"));

	}
	
	public static List<String> generateAbbreviations(String word) {
		List<String> result = new ArrayList<String>();
		result.add(word);
		if(word.length() == 0){
			return result;
		}
		result.add(Integer.toString(word.length()));
		for(int i=1; i<word.length();i++){
			for(int j=0;j<=word.length()-i;j++){
				String prefix = new StringBuffer()
												.append(word.substring(0, j))
												.append(i)
												.append(word.substring(j+i, Math.min(j+i+1, word.length()))).toString();
				List<String> subset = generateAbbreviations(word.substring(Math.min(j+i+1, word.length())));
				for(String s : subset){
					result.add(new StringBuffer(prefix).append(s).toString());
				}
			}
		}
		return result;
    }

}
