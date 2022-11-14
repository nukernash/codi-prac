package com.nukernash.dataStructure;

import java.util.ArrayList;
import java.util.List;

public class Stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private List<Integer> list;

	public Stack(){
		list = new ArrayList<>();
	}

	public void push(int add) {
		list.add(add);
	}

	public int pop() {
		int result = list.get(list.size()-1);
		list.remove(list.size() - 1);
		return result;
	}


}
