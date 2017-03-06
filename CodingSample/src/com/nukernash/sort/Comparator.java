package com.nukernash.sort;

import java.util.ArrayList;
import java.util.List;

public class Comparator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> list = new ArrayList<>();
		
		list.add(10);
		list.add(15);
		Integer a = new Integer(10);
		Integer b = new Integer(15);
		System.out.println(a.compareTo(b));
		
		list.sort((c,d)->d.compareTo(c));
		System.out.println(list);
	}

}
