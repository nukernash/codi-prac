package com.nukernash.google.medium;

import java.util.Arrays;

public class HIndex {

	public static void main(String[] args) {
		int[] paperCitations = {3, 0, 6, 1, 5};
		System.out.println(hIndex2(paperCitations));
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
    
    public static int hIndex2(int[] citations){
    	 
        int length = citations.length;
        if (length == 0) {
        	return 0;
        }
        
        int[] array2 = new int[length + 1];
        for (int i = 0; i < length; i++) {
        	if (citations[i] > length) {
        		array2[length] += 1;
        	} else {
        		array2[citations[i]] += 1;
        	}
        }
        int t = 0;
        for (int i = length; i >= 0; i--) {
        	t = t + array2[i];
        	if (t >= i) {
        		return i;
        	}
        }
        return 0;
    }
}
