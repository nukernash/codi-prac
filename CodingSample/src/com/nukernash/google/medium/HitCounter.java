package com.nukernash.google.medium;

import java.util.HashMap;
import java.util.Map;

public class HitCounter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HitCounter counter = new HitCounter();
		
		counter.hit(1);
		counter.hit(2);
		counter.hit(3);
		System.out.println(counter.getHits(4));
		counter.hit(300);
		System.out.println(counter.getHits(300));
		System.out.println(counter.getHits(301));
	}
	
	Map<Integer, Integer> map;
	
	/** Initialize your data structure here. */
	public HitCounter() {
		map = new HashMap<Integer, Integer>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if(map.containsKey(timestamp)){
        	map.put(timestamp, map.get(timestamp)+1);
        }else{
        	map.put(timestamp, 1);
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        
    	int count = 0;
    	for(int i=Math.max(0, timestamp-299); i<=timestamp;i++ ){
    		count = count + (map.containsKey(i) ? map.get(i) : 0); 
    	}
    	return count;
    }
}
