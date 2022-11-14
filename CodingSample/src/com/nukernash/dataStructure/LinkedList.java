package com.nukernash.dataStructure;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		System.out.println(String.format("Reverse Linkedlist of %d, is %s", n, LinkedList.toIntArr(LinkedList.reverseLinkedList(LinkedList.createLinkedList(n)))));

	}

	public static Node createLinkedList(int n){
		Node node = new Node(1, null);
		int i=2;
		Node curr = node;
		while(i<=n){
			curr.next = new Node(i, null);
			curr = curr.next;
			i++;
		}
		return node;
	}

	public static List<Integer> toIntArr(Node head){
		List<Integer> list = new ArrayList<>();
		while(head != null){
			list.add(head.value);
			head = head.next;
		}
		return list;
	}

	
	public static Node reverseLinkedList(Node head){
		if(head.next == null) {
			return head;
		}
		Node currHead = head;
		Node reversed = reverseLinkedList(currHead.next);
		currHead.next = null;
		Node curr = reversed;
		while(curr.next != null) {
			curr = curr.next;
		}
		curr.next = currHead;
		return reversed;
	}

}

class Node {
	int value;
	Node next;

	public Node(int value, Node next) {
		this.value = value;
		this.next = next;
	}
}
