/**
 * http://www.geeksforgeeks.org/given-two-strings-find-first-string-subsequence-second/
 * 
 * Given two strings str1 and str2, find if str1 is a subsequence of str2. A subsequence 
 * is a sequence that can be derived from another sequence by deleting some elements 
 * without changing the order of the remaining elements. Expected time 
 * complexity is linear.
 * 
 * Input: str1 = "AXY", str2 = "ADXCPY"
 * Output: True (str1 is a subsequence of str2)
 * 
 * Input: str1 = "AXY", str2 = "YADXCP"
 * Output: False (str1 is not a subsequence of str2)
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		String s1 = "AXY";
		//String s2 = "ADXCPY";
		String s2 = "YADXCP";

		if(checkSubsequence(s1, s2)){
			System.out.println("str1 is a subsequence of str2.");
		}else{
			System.out.println("str1 is not a subsequence of str2.");
		}
	}
	
	public static boolean checkSubsequence(String s1, String s2){
		return checkSubsequence(s1,s2,s1.length()-1,s2.length()-1);
	}
	
	//Recursive solution.
	private static boolean checkSubsequence(String s1, String s2, int m, int n){
		if(m==-1)return true;
		if(n==-1)return false;
		if(s1.charAt(m)==s2.charAt(n)){
			return checkSubsequence(s1,s2,m-1,n-1);
		}
		return checkSubsequence(s1,s2,m,n-1);
	}
	
	//TODO: Iterative Solution.
}
