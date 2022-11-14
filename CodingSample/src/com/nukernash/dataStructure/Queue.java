package com.nukernash.dataStructure;

import java.util.Stack;

public class Queue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static Stack<Integer> stack1;
	private static Stack<Integer> stack2;

	public Queue(){
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}

	public void enqueue(int add){
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		stack1.push(add);
		while(!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
	}

	public int dequeue() {
		return stack1.pop();
	} 

}
