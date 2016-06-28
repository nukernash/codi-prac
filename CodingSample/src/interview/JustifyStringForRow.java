package interview;

/*
 * Given a string write a program to justify with right number of spaces in between 
 * so that the paragraph is always within the specified row limit.
 */
public class JustifyStringForRow {

	public static void main(String[] args) {
		String input = "";
		System.out.println("Input : " + input);
		System.out.println("Output : " + justify(input));
	}
	
	public static String justify(String input){
		
		return justify(input, 30);
	}
	
	public static String justify(String input, int limit){
		
		StringBuilder output = new StringBuilder();
		String remaining = input;
		while(!remaining.isEmpty()){
			String nextRow = getNextrow(remaining, limit);
			output.append(nextRow).append("\n");
			remaining = findRemainingString(remaining, nextRow);
		}
		return output.toString();
	}
	
	public static String findRemainingString(String input, String currentLine){
		
		return "";
	}
	
	public static String getNextrow(String remainingStr, int limit){
		int length;
		String[] inputArr = remainingStr.split(" ");
		while
		return "";
	}
	
	public static String getrow(String[] strArr, int limit){
		StringBuilder row = new StringBuilder();
		int currLen;
		for(String str : strArr){
			if(currLen <= limit){
				row.append(str).append(" ");
				currLen += str.length();
			}
		}
		int numberOfExtraSpaces = 
	}

}
