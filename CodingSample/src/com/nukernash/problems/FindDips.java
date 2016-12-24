package com.nukernash.problems;

public class FindDips {

	public static void main(String[] args) {
		
		int[] intArr = new int[]{10,5,3,18,-1,2};	//3, -1
		int[] intArr2 = new int[]{};	//
		int[] intArr3 = new int[]{10,5};	//
		int[] intArr4 = new int[]{10,5,8};	//5
		int[] intArr5 = new int[]{10,5,3};	//None
		System.out.println("=====================");
		FindDips.findDips(intArr);
		System.out.println("=====================");
		FindDips.findDips(intArr2);
		System.out.println("=====================");
		FindDips.findDips(intArr3);
		System.out.println("=====================");
		FindDips.findDips(intArr4);
		System.out.println("=====================");
		FindDips.findDips(intArr5);

	}
	
	public static void findDips(int[] intArr){
		if(intArr.length < 3){
			System.out.println("The arrays has less than 3 elements. So no Dips were found.");
			return;
		}

		int prevPrev = intArr[0];
		int prev = intArr[1];
		boolean dipsFound = false;
		for(int i=2; i<intArr.length; i++){
			if(prevPrev > prev && prev < intArr[i]){
				dipsFound = true;
				System.out.println(prev);
			}
			prevPrev = prev;
			prev = intArr[i];
		}
		if(!dipsFound){
			System.out.println("No dips were found.");
		}
		
	}

}
