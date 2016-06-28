package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class T9Dict {

	public static Map<Integer, char[]> charset = new HashMap<Integer, char[]>();
	
	public static void main(String[] args) {
		
		charset.put(0, new char[]{'#'});
		charset.put(1, new char[]{'1'});
		charset.put(2, new char[]{'a', 'b', 'c'});
		charset.put(3, new char[]{'d', 'e', 'f'});
		charset.put(4, new char[]{'g', 'h', 'i'});
		charset.put(5, new char[]{'j', 'k', 'l'});
		charset.put(6, new char[]{'m', 'n', 'o'});
		charset.put(7, new char[]{'p', 'q', 'r', 's'});
		charset.put(8, new char[]{'t', 'u', 'v'});
		charset.put(9, new char[]{'w', 'x', 'y', 'z'});
		
		T9Dict.printSuggestions("234", null);

	}
	
	public static void printSuggestions(String seq, ArrayList<String> strList){
		ArrayList<String> newList = new ArrayList<String>();
		char[] charArr = charset.get(Integer.parseInt(seq.substring(0, 1)));
		if(strList == null){
			strList = new ArrayList<String>();
			strList.add("");
		}
		for(int i=0; i < charArr.length; i++){
			newList.addAll(getAllCombinations(strList, charArr[i]));
		}
		if(seq.length() ==1){
			System.out.println(newList);
			return;
		}
		printSuggestions(seq.substring(1), newList);
		
	}
	
	public static ArrayList<String> getAllCombinations(ArrayList<String> strList, char c){
		ArrayList<String> newList = new ArrayList<String>();
		for(int i=0;i<strList.size();i++) {
			newList.add(strList.get(i) + c);
		}
		return newList;
	}

}
