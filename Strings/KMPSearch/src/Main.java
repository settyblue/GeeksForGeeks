import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/searching-for-patterns-set-2-kmp-algorithm/
 * 
 * Given a text txt[0..n-1] and a pattern pat[0..m-1], 
 * write a function search(char pat[], char txt[]) 
 * that prints all occurrences of pat[] in txt[]. You may assume that n > m.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		String s = "THIS TESTEST IS A TEST TEXT";
		String pattern = "ABAXABAB";
		
		KMPSearch(s,pattern);
	}

	private static void KMPSearch(String s, String pattern) {
		int m = pattern.length();
		int n = s.length();
		
		int[] lps = new int[m];
		
		computeLPSArray(pattern,lps);
		
		int i=0,j=0;
		while(i<n){
			if(s.charAt(i) == pattern.charAt(j)){
				i++;j++;
			}
			if(j==m){
				System.out.println("pattern found at "+(i-j));
				j = lps[j-1];
			}else if(i<n && s.charAt(i) != pattern.charAt(j)){
				if(j != 0){
					j = lps[j-1];
				}else{
					i++;
				}
			}
		}
	}

	private static void computeLPSArray(String pattern, int[] lps) {
		int lenSoFar = 0;
		lps[0] = 0;
		int curIndex = 1;
		int m  = pattern.length();
		
		while(curIndex < m){
			if(pattern.charAt(curIndex) == pattern.charAt(lenSoFar)){
				lenSoFar++;
				lps[curIndex] = lenSoFar;
				curIndex++;
			}else{
				if(lenSoFar != 0){
					lenSoFar = lps[lenSoFar-1];
				}else{
					lps[curIndex] = 0;
					curIndex++;
				}
			}
			//System.out.println(Arrays.toString(lps));
		}
		System.out.println(Arrays.toString(lps));
	}

}
