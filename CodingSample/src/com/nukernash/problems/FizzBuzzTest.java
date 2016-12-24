package com.nukernash.problems;

import java.util.LinkedHashMap;
import java.util.Map;

public class FizzBuzzTest {


	public static void main(String []args){

		LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
		map.put(3, "Fizz");
		map.put(5, "Buzz");
		map.put(7, "Ping");
		FizzBuzzTest.printfizzbuzz(map);
	}

	public static void printfizzbuzz(LinkedHashMap<Integer, String> map){


		for(int i=1; i<200; i++){
			boolean match = false;
			for(Map.Entry<Integer, String> entry : map.entrySet()){
				int number = entry.getKey();
				String val = entry.getValue();
				if(i%number == 0){
					match = true;
					System.out.print(val);
				}
			}
			if(!match){
				System.out.println(i);
			}else{
				System.out.println();
			}
		}
	}
}
