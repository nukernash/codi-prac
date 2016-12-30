package com.nukernash.google.medium;

import java.util.ArrayList;
import java.util.List;

/*Given a rows x cols screen and a sentence represented by a list of words, find how many times the given sentence can be fitted on the screen.
//
//Note:
//
//    A word cannot be split into two lines.
//    The order of words in the sentence must remain unchanged.
//    Two consecutive words in a line must be separated by a single space.
//    Total words in the sentence won't exceed 100.
//    Length of each word won't exceed 10.
//    1 ≤ rows, cols ≤ 20,000.
 * 
 */


public class SentenceScreenFitting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> words = new ArrayList<String>();
		words.add("I");
		words.add("am");
		words.add("happy");
		System.out.println("Times : " +  getSentenceCount(words, 4, 12));

	}
	
	public static int getSentenceCount(List<String> words, int rows, int coloumns){
		
		return 0;
	}

}
