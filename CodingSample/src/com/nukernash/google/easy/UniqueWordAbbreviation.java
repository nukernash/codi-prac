package com.nukernash.google.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/*
 * Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. 
 * A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
 * 
 */
public class UniqueWordAbbreviation {

	public static void main(String[] args) {
		String[] dictionary = {"deer", "door", "cake", "card"};
		UniqueWordAbbreviation u = new UniqueWordAbbreviation(dictionary);
		
		System.out.println("is Unique : " + u.isUnique("dear"));
		System.out.println("is Unique : " + u.isUnique("door"));
		System.out.println("is Unique : " + u.isUnique("cart"));
		System.out.println("is Unique : " + u.isUnique("cake"));
	}
	
	HashMap<String, List<String>> abbs = new HashMap<String, List<String>>();
	
	public UniqueWordAbbreviation(String[] dictionary) {
        for(String s : dictionary){
        	String abb = getAbbreviation(s);
        	if(!abbs.containsKey(abb)){
        		abbs.put(abb, new ArrayList<String>());
        	}
        	if(!abbs.get(abb).contains(s)){
        		abbs.get(abb).add(s);
        	}
        }
    }
	
	public boolean isUnique(String word) {
		String abb = getAbbreviation(word);
		return !abbs.containsKey(abb) || (abbs.get(abb).contains(word) && abbs.get(abb).size() == 1);
    }
	
	private String getAbbreviation(String word){
		if(word.length()<3){
			return word;
		}
		return word.substring(0, 1) + (word.length() - 2) + word.substring(word.length()-1);  
	}

}
