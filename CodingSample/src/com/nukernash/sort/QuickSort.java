package com.nukernash.sort;

import java.util.Arrays;

/*
 * 			8 3 5 2 7 1 9 4
 */

public class QuickSort {

	public static void main(String[] args) {
		int[] intArr = {8, 3, 5, 2, 7, 1, 9, 4};
		System.out.println("Before sorting : " + Arrays.toString(intArr));
		QuickSort.sort(intArr, 0, intArr.length-1);
		System.out.println("After sorting : " + Arrays.toString(intArr));
	}
	
	public static void sort(int[] intArr, int start, int end){
		if(start >= end){
			return;
		}
		int pivot = end;
		int wall = start;
		for(int i=start; i<end; i++){
			if(intArr[i] < intArr[pivot]){
				swap(intArr, i, wall);
				wall = wall+1;
			}
		}
		swap(intArr, pivot, wall);
		System.out.println("Step : " + Arrays.toString(intArr));
		sort(intArr, start, wall-1);
		sort(intArr, wall+1, end);
		
	}
	
	private static void swap(int[] intArr, int index1, int index2){
		if(index1 == index2){
			return;
		}
		int temp = intArr[index1];
		intArr[index1] = intArr[index2];
		intArr[index2] = temp;
	}

}
