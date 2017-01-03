package com.nukernash.google.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
 *  Given a sorted integer array without duplicates, return the summary of its ranges.
 *  For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"]. 
 * 
 * 
 */
public class SummaryRanges {

	public static void main(String[] args) {
		int[] nums = {0,1,2,4,5,7};
		
		System.out.println(summaryRanges(nums));
	}
	
	public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<String>();
        if(nums.length == 0){
        	return list;
        }
        StringBuffer prefix = new StringBuffer();
        prefix.append(nums[0]);
        boolean isEncounter = false;
        for(int i=1; i<nums.length;i++){
        	 if(nums[i] != nums[i-1] + 1){
        		 complete(list, i, nums, prefix, isEncounter);
        		 prefix = new StringBuffer().append(nums[i]);
        		 isEncounter = false;
        	 }else{
        		 isEncounter = true;
        	 }
        }
        complete(list, nums.length, nums, prefix, isEncounter);
        return list;
    }
	
	public static void complete(List<String> list, int i, int[] nums, StringBuffer prefix, boolean isEncounter){
		if(isEncounter){
			 list.add(prefix.append("->").append(nums[i-1]).toString());
		 }else{
			 list.add(prefix.toString());
		 }
	}

}
