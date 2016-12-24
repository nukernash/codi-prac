package com.nukernash.problems;

import java.util.ArrayList;

public class SortKlists {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> mergedSortedList = (ArrayList<Integer>)lists.get(0);
		
		for(int i=1; i<lists.size()-1; i++){
			mergedSortedList = merge2Lists(mergedSortedList, lists.get(i));
		}

	}
	
	public static ArrayList<Integer> merge2Lists(ArrayList<Integer> intArr1, ArrayList<Integer> intArr2){
		
		//TODO : Implement merge 2 sortd lists
		return new ArrayList<Integer>();
	}

}
