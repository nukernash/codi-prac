package com.nukernash.google.medium;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * 
 */

public class DecodeString {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		System.out.println(decodeSimple("3[a]2[bc]"));
		System.out.println(decodeSimple("3[a2[c]]"));
		System.out.println(decodeSimple("2[abc]3[cd]ef"));
		System.out.println(decodeSimple("sd2[f2[e]g]i"));
		
	}

	public static String decodeSimple(String s){
		Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder cur = new StringBuilder();
        int k = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if ( ch == '[') {
                intStack.push(k);
                strStack.push(cur);
                cur = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder tmp = cur;
                cur = strStack.pop();
                for (k = intStack.pop(); k > 0; --k) cur.append(tmp);
            } else cur.append(ch);
        }
        return cur.toString();
	}
	
	public static String decodeString(String s) {
        if(!s.contains("[")){
        	return s;
        }
        Pattern p = Pattern.compile("^[a-z]+");
        Matcher m = p.matcher(s);
        String prefix = "";
        if(m.find()){
         prefix = m.group();
        }
        System.out.println(prefix);
        if(!prefix.isEmpty()){
        	s = s.substring(s.indexOf(prefix)+prefix.length());
        }
        int number = Integer.parseInt(s.substring(0, s.indexOf("[")));
        int index = getindexOfFirst(s);
        String decodedString = decodeString(s.substring(s.indexOf("[")+1, index));
        StringBuffer str = new StringBuffer(prefix);
        for(int i=0;i<number;i++){
        	str.append(decodedString);
        }
		return str.append(decodeString(s.substring(index+1))).toString();
    }
	
	public static int getindexOfFirst(String s){
		int count = 0;
		for(int i=0; i< s.length();i++){
			if(s.charAt(i) == '['){
				count++;
			}else if(s.charAt(i) == ']'){
				count --;
				if(count == 0){
					return i;
				}
			}
		}
		return 0;
	}

}
