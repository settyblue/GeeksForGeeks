import static java.lang.Math.max;
/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
 * 
 * Given two sequences, find the length of longest subsequence present in 
 * both of them. A subsequence is a sequence that appears in the same 
 * relative order, but not necessarily contiguous. For example, “abc”, 
 * “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”. 
 * So a string of length n has 2^n different possible subsequences.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		String a = "AGGTAB";
		String b = "GXTXAYB";
		
		printLongestCommonSubsequence(a,b);

	}
	
	public static void printLongestCommonSubsequence(String a, String b){
		//System.out.println("\nlength of longest common subsequence is "+getLengthLongestCommonSubsequence(a,b,a.length()-1,b.length()-1));
		System.out.println("\nlength of longest common subsequence is "+getLengthLongestCommonSubsequenceDP(a,b));
	}
	
	//This is recursive implementation.
	public static int getLengthLongestCommonSubsequence(String a, String b,int i, int j){
		if(i<0 || j<0){
			return 0;
		}
		if(Character.toLowerCase(a.charAt(i)) == Character.toLowerCase(b.charAt(j))){
			System.out.print(a.charAt(i));
			return getLengthLongestCommonSubsequence(a,b,i-1,j-1)+1;
		}else{
			return max(getLengthLongestCommonSubsequence(a,b,i-1,j), getLengthLongestCommonSubsequence(a,b,i,j-1));
		}
	}
	
	//Time efficient DP implementation.
	public static int getLengthLongestCommonSubsequenceDP(String a, String b){
		int al = a.length();
		int bl = b.length();
		int[][] lcs = new int[al+1][bl+1];
		
		for(int i=0;i<=al;i++){
			for(int j=0;j<=bl;j++){
				if(i==0||j==0){
					lcs[i][j] = 0;
				}
				else if(a.charAt(i-1) == b.charAt(j-1)){
					lcs[i][j] = lcs[i-1][j-1]+1;
				}else{
					lcs[i][j] = Math.max(lcs[i-1][j],lcs[i][j-1]);
				}
			}
		}
		printMatrix(lcs);
		return lcs[al][bl];
	}
	
	public static void printMatrix(int[][] matrix){
		for(int i=0; i<matrix.length;i++){
			for(int j=0; j<matrix[0].length; j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}
