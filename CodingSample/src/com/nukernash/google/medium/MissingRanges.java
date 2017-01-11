package com.nukernash.google.medium;

import java.util.ArrayList;
import java.util.List;

/*
 *  Given a sorted integer array where the range of elements are in the inclusive range [lower, upper], return its missing ranges.
 *  For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"]. 
 * 
 */
public class MissingRanges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0, 1, 3, 50, 75};
		System.out.println(findMissingRanges(nums, 0, 99));
	}
	
	public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<String>();
        if(nums.length == 0){
        	result.add(lower + "->" + upper);
        }
        if(nums[0] != lower){
        	if(nums[0] != lower+1){
        		result.add(lower+"->"+(nums[0]-1));
        	}else{
        		result.add(Integer.toString(lower));
        	}
        }
        for(int i=1;i<nums.length;i++){
        	if((i == 0 && nums[i] == lower) ||
        			(i == nums.length-1 && nums[i] == upper) ||
        			(nums[i] - nums[i-1] == 1)){
        		continue;
        	}
        	if(nums[i] - nums[i-1] == 2){
        		result.add(Integer.toString(nums[i]-1));
        	}else{
        		result.add((nums[i-1]+1)+"->"+(nums[i]-1));
        	}
        }
        if(nums[nums.length-1] != upper){
        	if(nums[nums.length-1] != upper-1){
        		result.add((nums[nums.length-1] +1)+"->"+upper);
        	}else{
        		result.add(Integer.toString(upper));
        	}
        }
        
        return result;
	}

}
