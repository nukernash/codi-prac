package com.nukernash.google.medium;

public class FlipGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canWin("++++"));
	}
	
	public static boolean canWin(String s) {
		  if (s == null || s.length() < 2) {
		    return false;
		  }
		    
		  for (int i = 0; i < s.length() - 1; i++) {
		    if (s.startsWith("++", i)) {
		      String t = s.substring(0, i) + "--" + s.substring(i + 2);
		      
		      if (!canWin(t)) {
		        return true;
		      }
		    }
		  }
		    
		  return false;
		}

}
