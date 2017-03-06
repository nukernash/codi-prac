package com.nukernash.google.medium;

/*
 * 
 * Now you are given a string S, which represents a software license key which we would like to format. 
 * The string S is composed of alphanumerical characters and dashes. The dashes split the alphanumerical 
 * characters within the string into groups. (i.e. if there are M dashes, the string is split into M+1 groups). 
 * The dashes in the given string are possibly misplaced.
 * 
 * We want each group of characters to be of length K (except for possibly the first group, which could be shorter, but still must contain at least one character). 
 * To satisfy this requirement, we will reinsert dashes. Additionally, all the lower case letters in the string must be converted to upper case.
 * 
 * So, you are given a non-empty string S, representing a license key to format, and an integer K. And you need to return the license key 
 * formatted according to the description above.
 */

public class LicenseKeyFormatting {

	public static void main(String[] args) {
		
		String s1 = "2-4A0r7-4k";
		
		System.out.println(s1 + " " + licenseKeyFormatting(s1, 4));	//24A0-R74K
		System.out.println(s1 + " " + licenseKeyFormatting(s1, 3));	//24-A0R-74K

	}
	
	public static String licenseKeyFormatting(String S, int K) {
		if(S.isEmpty()){
			return S;
		}
		
		int l = S.length()-1;
		StringBuffer result = new StringBuffer();
		int count = 0;
		while(l >= 0){
			if(S.charAt(l) == '-'){
				l--;
				continue;
			}
			if(count==K){
				result.append("-");
				count=0;
			}
			result.append(S.charAt(l));
			count++;
			l--;
		}
		
		return result.reverse().toString().toUpperCase();
    }

}
