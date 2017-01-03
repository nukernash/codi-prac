package com.nukernash.google.hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUCache {

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(1);
		
		cache.set(2, 1);
		System.out.println(cache.get(2));
		cache.set(3, 2);
		System.out.println(cache.get(2));

	}
	
	private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    private List<Integer> list = new LinkedList<Integer>();
    private final int size;
    
    public LRUCache(int capacity) {
        size = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
        	return -1;
        }
        int curr_index = map.get(key);
        int value = list.get(curr_index);
        if(curr_index != 0){
	        list.remove(curr_index);
	        list.add(0, value);
	        map.put(key, 0);
        }
        return value;
    }
    
    public void set(int key, int value) {
    	if(map.containsKey(key)){
    		list.remove(map.get(key));
    	}
    	if(list.size() == size){
    		map.remove(key);
    		list.remove(list.size()-1);
    	}
    	list.add(0, value);
        map.put(key, 0);
    }

}
