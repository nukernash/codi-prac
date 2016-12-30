package com.nukernash.google.easy;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 
 * MovingAverage m = new MovingAverage(3);
//	m.next(1) = 1
//	m.next(10) = (1 + 10) / 2
//	m.next(3) = (1 + 10 + 3) / 3
//	m.next(5) = (10 + 3 + 5) / 3
 * 
 * 
 */
public class MovingAverage {

	public static void main(String[] args) {
		MovingAverage m = new MovingAverage(3);
		System.out.println(m.next(1));
		System.out.println(m.next(10));
		System.out.println(m.next(3));
		System.out.println(m.next(5));
		
	}
	
	private final int size;
	private Queue<Integer> q = new LinkedList<Integer>();
	private int sum = 0;
	
	public MovingAverage(int size) {
        this.size = size;
    }
	
	public double next(int val) {
		q.add(Integer.valueOf(val));
		if(q.size() > size){
			Integer i = q.poll();
			sum = sum - i + val;
			return (double)sum/(double)size;
		}else{
			sum += val;
			return (double)sum/(double)q.size();
		}
		
    }


}
