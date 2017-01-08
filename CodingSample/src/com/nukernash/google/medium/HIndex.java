package com.nukernash.google.medium;

import java.util.Arrays;

public class HIndex {

	public static void main(String[] args) {
		int[] paperCitations = {3, 0, 6, 1, 5};
		System.out.println(hIndex(paperCitations));
	}

	
    public static int hIndex(int[] citations) {
    	
    	
        int[] num = new int[citations.length + 1];
        for(int i=0;i<citations.length;i++){
        	for(int j=0;j<=Math.min(citations[i], citations.length);j++){
        		num[j] += 1;
        	}
        }
        for(int i=num.length-1;i>=0;i--){
        	if(i == num[i]){
        		return i;
        	}
        }
        return 0;
    }
}
