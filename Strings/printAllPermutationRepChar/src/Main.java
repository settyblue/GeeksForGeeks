import java.util.TreeSet;
/**
 * http://www.geeksforgeeks.org/print-all-permutations-with-repetition-of-characters/
 * 
 * Given a string of length n, print all permutation of the given string. 
 * Repetition of characters is allowed. Print these permutations in lexicographically 
 * sorted order.
 * 
 * Input: ABC
 * Output: All permutations of ABC with repetition are:
 *        AAA
 *        AAB
 *        AAC
 *        ABA
 *        ...
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		String s = "ABC";
		printAllPermuations(s);
	}

	private static void printAllPermuations(String s) {
		int n = s.length();
		TreeSet<Character> set = new TreeSet<>();
		for(char c:s.toCharArray()){
			set.add(c);
		}
		StringBuffer sortedString = new StringBuffer();
		for(char c:set){
			sortedString.append(c);
		}
		StringBuffer answer = new StringBuffer();
		for(int i=0;i<sortedString.length();i++){
			answer.append(sortedString.charAt(i));
			printAllPermutations(sortedString, answer,1,n);
			answer.deleteCharAt(answer.length()-1);
		}
	}

	private static void printAllPermutations(StringBuffer sortedStr,StringBuffer answer, int m, int n) {
		if(m==n){
			System.out.println(answer.toString());
			return;
		}
		
		for(int i=0;i<sortedStr.length();i++){
			answer.append(sortedStr.charAt(i));
			printAllPermutations(sortedStr,answer,m+1,n);
			answer.deleteCharAt(answer.length()-1);
		}
	}

}
