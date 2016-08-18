import static java.lang.Math.max;
/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/
 * Given a sequence, find the length of the longest palindromic subsequence in it. 
 * For example, if the given sequence is “BBABCBCAB”, then the output should be 7 as “BABCBAB” 
 * is the longest palindromic subseuqnce in it. “BBBBB” and “BBCBB” are also palindromic subsequences 
 * of the given sequence, but not the longest ones.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		String s = "helloworld";
		System.out.println("Length of longest palindromic subsequence is "+lenPalindromeSubs(s));

	}
	
	public static int lenPalindromeSubs(String s){
		int length = s.length();
		int[][] mat = new int[length][length];
		for(int i=0; i<length; i++){
			mat[i][i] = 1;
		}
		
		for(int subStrLen=2; subStrLen<=length; subStrLen++){
			for(int i=0; i<length-subStrLen+1;i++){
				int j = i+subStrLen-1;
				if(subStrLen==2 && s.charAt(i) == s.charAt(j)){
					mat[i][j] = 2;
				}else if(s.charAt(i) == s.charAt(j)){
					mat[i][j] = mat[i+1][j-1]+2;
				}else{
					mat[i][j] = max(mat[i][j-1], mat[i+1][j]);
				}
			}
		}
		return mat[0][s.length()-1];
	}
}
