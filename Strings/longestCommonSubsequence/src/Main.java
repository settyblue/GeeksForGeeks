/**
 * http://www.geeksforgeeks.org/printing-longest-common-subsequence/
 * 
 * Given two sequences, print the longest subsequence present in both of them.
 * 
 * Examples:
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 * LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		String s1="ABCDGH", s2="AEDFHR";
		//String s1="AGGTAB", s2="GXTXAYB";
		System.out.println(lcsubseqRecursive(s1,s2));
		System.out.println(lcsubseqDP(s1,s2));
	}

	private static String lcsubseqRecursive(String s1, String s2) {
		if(s1.length()==0 || s2.length()==0){
			return "";
		}
		
		if(s1.charAt(0) == s2.charAt(0)){
			return s1.charAt(0)+lcsubseqRecursive(s1.substring(1),s2.substring(1));
		}else{
			String answer1 = lcsubseqRecursive(s1.substring(1),s2);
			String answer2 = lcsubseqRecursive(s1,s2.substring(1));
			return answer1.length()>answer2.length()?answer1:answer2;
		}
	}
	
	private static String lcsubseqDP(String s1, String s2){
		int m = s1.length(),n = s2.length();
		int[][] maxLen = new int[m+1][n+1];
		for(int i=1;i<m+1;i++){
			for(int j=1;j<n+1;j++){
				if(s1.charAt(i-1)==s2.charAt(j-1)){
					maxLen[i][j] = maxLen[i-1][j-1]+1;
				}else{
					maxLen[i][j] = Math.max(maxLen[i][j-1],maxLen[i-1][j]);
				}
			}
		}
		//print(maxLen);
		
		
		String answer = "";
		while(m>0 && n>0){
			if(maxLen[m][n] > maxLen[m][n-1] && maxLen[m][n] > maxLen[m-1][n]){
				answer = s1.charAt(m-1)+answer;
				m--;n--;
			}else{
				if(maxLen[m][n] == maxLen[m][n-1]){
					n--;
				}else{
					m--;
				}
			}
		}
		
		return answer;
	}

	private static void print(int[][] maxLen) {
		for(int i=0;i<maxLen.length;i++){
			for(int j=0;j<maxLen[0].length; j++){
				System.out.print(maxLen[i][j]+" ");
			}
			System.out.println();
		}
	}
}
