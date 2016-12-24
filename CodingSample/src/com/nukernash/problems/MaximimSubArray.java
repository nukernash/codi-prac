package com.nukernash.problems;

public class MaximimSubArray {

	public static void main(String[] args) {
		
		//int[] intArr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
		//int[] intArr2 = new int[]{-2,-1,-3,-4,-8,-1};
		int[] intArr = new int[]{2,-1,-3,4,2,-3,5,-4};
		
		int sum = MaximimSubArray.getMax(intArr);
		System.out.println("The maximum sum : " + sum);

	}

	public static int getMax(int[] intArr){
		int sum = intArr[0];//2
		int max_sum = intArr[0];//2

		for(int i = 1; i < intArr.length ; i++) {
		    max_sum = Math.max(intArr[i], max_sum+intArr[i]);
		    sum = Math.max(sum, max_sum); 
		}
		return max_sum;
	}
	
	public static int getMaximumSubArray(int[] intArr){
		
		if(intArr.length == 0){
			return 0;
		}
		int maxSum=0;
		int sum=0;
		int maxNum= Integer.MIN_VALUE; //to tackle all negative numbers.
		for(int i : intArr){
			if(i>maxNum){
				maxNum = i;
			}
			sum += i;
			if(sum > maxSum) {
				maxSum = sum;
			}
			if(sum < 0) {
				sum = 0;
			}
		}
		return (maxSum == 0) ? maxNum : maxSum;
	}
	
	
}
