package com.nukernash.google.medium;

import java.util.Stack;

/*
 * 	"dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"
 * 		dir
 *    		subdir1
 *    		subdir2
 *       		file.ext
 *       
 *   "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
 *   
 *  	dir
 *   		subdir1
 *      		file1.ext
 *      		subsubdir1
 *   		subdir2
 *       		subsubdir2
 *           		file2.ext
 *           
 *     Ans : "dir/subdir2/subsubdir2/file2.ext", 32      
 */

public class LongestAbsolutePath {

	public static void main(String args[]){
		String path = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
		System.out.println(lengthLongestPath(path));
		
		String path2 = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		System.out.println(lengthLongestPath(path2));
	}
	
	public static int lengthLongestPath(String input) {
		String prefix;
		int maxFilePath;
		int currlevel = 0;
		int tabCount = 0;
		StringBuffer currName = new StringBuffer();
		Stack<String> stack = new Stack<String>();
    
		for(int i=0;i<input.length();i++){
			if(input.charAt(i) == '\\'){
				i++;
				if(input.charAt(i) == 'n'){
					stack.push(currName.toString());
					prefix = currName.toString() + "/";
					currName = new StringBuffer();
				}
				if(input.charAt(i) == 't'){
					tabCount++;
				}
			}else{
				if(tabCount != 0){
					if(tabCount < currlevel){
						prefix = prefix.substring(beginIndex, endIndex)
					}
					currlevel = tabCount;
					tabCount = 0;
				}
				
			}
					
		}
		return maxFilePath;
    }
	
	public static String getPrefix(Stack stack, int level){
		String prefix = "";
		while(!stack.isEmpty())
	}
}
