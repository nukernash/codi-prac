package com.nukernash.google.easy;

import java.util.Arrays;

public class PlusOne {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(plusOne(new int[]{1, 9})));
		System.out.println(Arrays.toString(plusOne(new int[]{1, 1})));
		System.out.println(Arrays.toString(plusOne(new int[]{9, 9})));

	}
	
	public static int[] plusOne(int[] digits){
		boolean added = false;
        int[] result = new int[digits.length];
        for(int i=digits.length-1;i>=0;i--){
            if(added){
                result[i] = digits[i];
                continue;
            }
            if(digits[i] == 9){
                result[i] = 0;
            } else {
                result[i] = digits[i] + 1;
                added = true;
            }
        }
        if(!added){
        	int[] newResult = new int[digits.length + 1];
        	newResult[0] = 1;
        	for(int i = 1;i<newResult.length ; i++){
        		newResult[i] = result[i-1];
        	}
        	return newResult;
        }
        
        return result;
	}

}
