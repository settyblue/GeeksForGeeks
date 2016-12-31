import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * http://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together-set-2/
 * 
 * Given an array of words, print all anagrams together. 
 * For example, if the given array is {“cat”, “dog”, “tac”, “god”, “act”}, 
 * then output may be “cat tac act dog god”.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		String[] array = {"cat", "dog", "tac", "god", "act"};
		printAnagramWordGroups(array);
	}

	private static void printAnagramWordGroups(String[] array) {
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		for(String s:array){
			char[] sarr = s.toCharArray();
			Arrays.sort(sarr);
			String s_sorted = Arrays.toString(sarr);
			if(map.containsKey(s_sorted)){
				map.get(s_sorted).add(s);
			}else{
				map.put(s_sorted, new ArrayList<String>());
				map.get(s_sorted).add(s);
			}
		}
		for(String key:map.keySet()){
			for(String word:map.get(key)){
				System.out.print(word+" ");
			}
		}
	}
}
