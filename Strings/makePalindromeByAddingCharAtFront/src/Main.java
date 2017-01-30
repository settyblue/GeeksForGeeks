import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/minimum-characters-added-front-make-string-palindrome/
 * 
 * Given a string str we need to tell minimum characters to be added at front of string to make string palindrome.
 * 
 * Input  : str = "ABC"
 * Output : 2
 * We can make above string palindrome as "CBABC"
 * by adding 'B' and 'C' at front.
 * 
 * Input  : str = "AACECAAAA";
 * Output : 2
 * We can make above string palindrome as AAAACECAAAA
 * by adding two A's at front of string.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		String s = "AACECAAAA";
		System.out.println(minCharsToPalindrome(s));
	}

	private static int minCharsToPalindrome(String s) {
		StringBuffer sb = new StringBuffer(s);
		StringBuffer sbnew = new StringBuffer("");
		sbnew.append(s+"$"+sb.reverse().toString());
		System.out.println(sbnew.toString());
		int n = s.length();
		int[] lps = new int[2*n+1];
		computeLPS(sbnew.toString(),lps);
		return n - lps[2*n];
	}

	private static void computeLPS(String string, int[] lps) {
		lps[0] = 0;
		int n = string.length();
		int len=0;
		int curIndex = 1;
		while(curIndex<n){
			if(string.charAt(len) == string.charAt(curIndex)){
				len++;
				lps[curIndex] = len;
				curIndex++;
			}else{
				if(len == 0){
					lps[curIndex] = 0;
					curIndex++;
				}else{
					len = lps[len-1];
				}
			}
		}
		System.out.println(Arrays.toString(lps));
	}

}
