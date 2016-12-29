package com.nukernash.array;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {
		
		int[] intArr = {2,4,6,1,5,3,6,7,8};
		int[] result = printTwoSum(intArr, 6);
		System.out.println("Result : " + Arrays.toString(result));

	}
	
	public static int[] printTwoSum(int[] intArr, int sum){
		
		int[] indeces = new int[2];
		HashMap<Integer, Integer> complements = new HashMap<Integer, Integer>();
		for(int i=0;i<intArr.length;i++){
			Integer n = Integer.valueOf(intArr[i]);
			if(complements.containsKey(n)){
				indeces[0]=complements.get(n);
				indeces[1]=i;
			}else{
				complements.put(sum-n, i);
			}
		}
		return indeces;
	}

}
