package com.nukernash.google.medium;

import java.util.Arrays;

public class WiggleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3, 5, 2, 1, 6, 4};
		wiggleSort(nums);
		System.out.println(Arrays.toString(nums));
		
		int[] nums1 = {3, 5, 2, 1, 6, 4, 7};
		wiggleSort(nums1);
		System.out.println(Arrays.toString(nums1));
		
		int[] nums2 = {3, 5};
		wiggleSort(nums2);
		System.out.println(Arrays.toString(nums2));
		
		int[] nums3 = {1};
		wiggleSort(nums3);
		System.out.println(Arrays.toString(nums3));

	}
	
	public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for(int i=1;i<nums.length-(nums.length%2 == 0 ? 2 : 1);i=i+2){
        	int tmp = nums[i];
        	nums[i] = nums[i+1];
        	nums[i+1] = tmp;
        }
    }

}
