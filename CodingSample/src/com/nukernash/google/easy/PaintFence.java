package com.nukernash.google.easy;

public class PaintFence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numWays(1, 3));
		System.out.println(numWays(2, 3));
		System.out.println(numWays(3, 3));
		System.out.println(numWays(3, 1));
		System.out.println(numWays(0, 0));

	}
	
	public static int numWays(int n, int k) {
		if(n == 0 || k == 0 || (n > 2 && k<2)){
			return 0;
		}
        int count = 0;
        count = count + (n/3)*(k*k*(k-1));
        count = count + (int)(Math.pow((double)(k), (double)(n%3)));
        return count;
    }

}
