import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/find-given-string-can-represented-substring-iterating-substring-n-times/
 * 
 * Given a string ‘str’, check if it can be constructed by taking a substring of it 
 * and appending multiple copies of the substring together.
 * 
 * Input: str = "abcabcabc"
 * Output: true
 * The given string is 3 times repetition of "abc"
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		String[] array = {"ABCABC", "ABABAB", "ABCDABCD", "GEEKSFORGEEKS",
                "GEEKGEEK", "AAAACAAAAC", "ABCDABC"};
		for(int i=0;i<array.length;i++){
			int n = checkRepeated(array[i]);
			if(n!=0){
				System.out.println(array[i]+" is repeated with pattern length "+n);
			}else{
				System.out.println(array[i]+" is not repeated.");
			}
		}

	}

	private static int checkRepeated(String pattern) {
		int m = pattern.length();
		int[] lps = new int[m];
		computeLPSArray(pattern,lps);
		System.out.println(pattern+" "+Arrays.toString(lps));
		int n = lps[m-1];
		
		if(n==0)return 0;
		if(m%(m-n)==0)return (m-n);
		else return 0;
	}

	private static void computeLPSArray(String pattern, int[] lps) {
		int m = pattern.length();
		lps[0] = 0;
		int curIndex = 1;
		int len = 0;
		
		while(curIndex < m){
			if(pattern.charAt(curIndex) == pattern.charAt(len)){
				len++;
				lps[curIndex] = len;
				curIndex++;
			}else{
				if(len != 0){
					len = lps[len-1];
				}else{
					curIndex++;
				}
			}
		}
	}

}
