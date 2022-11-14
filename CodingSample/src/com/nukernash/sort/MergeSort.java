package com.nukernash.sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] intArr = {8, 3, 5, 2, 7, 1, 9, 4};
		System.out.println("Before sorting : " + Arrays.toString(intArr));
		int[] result = MergeSort.sort(intArr);
		System.out.println("After sorting : " + Arrays.toString(result));
	}
	
	public static int[] sort(int[] intArr){
		return sort(intArr, 0, intArr.length -1);
	}

	private static int[] sort(int[] intArr, int start, int end){
		if(start == end) {
			return new int[]{intArr[start]};
		}
		int mid = start + (end-start)/2;
		int[] arr1 = sort(intArr, start, mid);
		int[] arr2 = sort(intArr, mid+1, end);

		return merge(arr1, arr2);

	}

	private static int[] merge(int[] arr1, int[] arr2){

		int[] result = new int[arr1.length + arr2.length];

		int i=0,j=0,k=0;
		while(i < arr1.length && j < arr2.length) {
			if(arr1[i] > arr2[j]){
				result[k] = arr2[j];
				k++;
				j++;
			} else {
				result[k] = arr1[i];
				i++;
				k++;
			}
		}
		
		while(j < arr2.length){
			result[k] = arr2[j];
			k++;
			j++;
		}

		while(i < arr1.length){
			result[k] = arr1[i];
			k++;
			i++;
		}

		return result;
	}

}
