import java.util.ArrayList;
import java.util.HashMap;

/**
 * http://www.geeksforgeeks.org/find-strings-formed-characters-mapped-digits-number/
 * 
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		char[][] table =
		    {
		            { 'A', 'B', 'C' },
		            { 'D', 'E', 'F' },
		            { 'G', 'H', 'I' },
		            { 'J', 'K', 'L' },
		            { 'M', 'N', 'O' },
		            { 'P', 'Q', 'R' },
		            { 'S', 'T', 'U' },
		            { 'V', 'W', 'X' },
		            { 'Y', 'Z' }
		        };
		
		int[] array = {1,2,3};
		printAllPossibleWords(table, array);
	}

	private static void printAllPossibleWords(char[][] table, int[] array) {
		ArrayList<String> answerList = new ArrayList<>();
		HashMap<Integer, Character> map = new HashMap<>();
		StringBuffer answer = new StringBuffer("");
		
		printAllWords(table,array,map,answer,answerList);
		
		for(String s:answerList){
			System.out.println(s);
		}
	}

	private static void printAllWords(char[][] table, int[] array, HashMap<Integer, Character> map,
			StringBuffer answer, ArrayList<String> answerList) {
		if(answer.length()== array.length){
			answerList.add(answer.toString());
			return;
		}
		int digit = array[answer.length()];
		if(map.containsKey(digit)){
			answer.append(map.get(digit));
			printAllWords(table,array,map,answer,answerList);
			answer.delete(answer.length()-1, answer.length());
		}else{
			for(int j=0;j<table[digit-1].length;j++){
				char c = table[digit-1][j];
				map.put(digit, c);
				answer.append(c);
				printAllWords(table,array,map,answer,answerList);
				answer.delete(answer.length()-1, answer.length());
				map.remove(digit);
			}
		}
	}

}
