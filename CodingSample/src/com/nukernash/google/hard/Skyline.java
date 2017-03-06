package com.nukernash.google.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Skyline {

	public static void main(String args[]) throws Exception{
		int[][] buildings = new int[][]{{2,9,10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
		getSkyline(buildings).stream().forEach(a -> {
			System.out.println(Arrays.toString(a));
		});
	}
	
	public static List<int[]> getSkyline(int[][] buildings) throws Exception{
	    List<int[]> result = new ArrayList<>();
	    List<int[]> height = new ArrayList<>();
	    for(int[] b:buildings) {
	        height.add(new int[]{b[0], -b[2]});
	        height.add(new int[]{b[1], b[2]});
	    }
	    System.out.println("Height befoe sorting: ");
	    height.stream().forEach(a -> {
			System.out.println(Arrays.toString(a));
		});
	    Collections.sort(height, (a, b) -> {
	            if(a[0] != b[0]) 
	                return a[0] - b[0];
	            return a[1] - b[1];
	    });
	    System.out.println("Height after sorting: ");
	    height.stream().forEach(a -> {
			System.out.println(Arrays.toString(a));
		});
	    Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
	    pq.offer(0);
	    int prev = 0;
	    for(int[] h:height) {
	    	System.out.println("height" + Arrays.toString(h) +  " : queue: " + pq);
	        if(h[1] < 0) {
	            pq.offer(-h[1]);
	        } else {
	            pq.remove(h[1]);
	        }
	        Thread.sleep(1000);
	        System.out.println(" : queue: " + pq);
	        int cur = pq.peek();
	        if(prev != cur) {
	            result.add(new int[]{h[0], cur});
	            result.stream().forEach(a -> {
	    			System.out.print(Arrays.toString(a));
	    		});
	            System.out.println();
	            prev = cur;
	        }
	    }
	    return result;
	} 
}
