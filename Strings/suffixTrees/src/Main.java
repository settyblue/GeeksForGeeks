import java.util.Arrays;

/**
 * Print the longest repeated substring using suffix tree.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		String s = "abcdabcfghijabcfg";
		
		int n = s.length();
		String[] suffixes = new String[n];
		for(int i=0;i<n;i++){
			suffixes[i] = s.substring(i,n);
		}
		Arrays.sort(suffixes);
		print(suffixes);
		
		int maxLen = 0;
		for(int i=0;i<n-1;i++){
			int temp = lcp(suffixes[i],suffixes[i+1]);
			maxLen = Math.max(maxLen, temp);
		}
		System.out.println("max length of repeated substring = "+maxLen);
	}

	private static int lcp(String str, String str2) {
		int val = 0;
		for(int i=0;i<Math.min(str.length(), str2.length());i++){
			if(str.charAt(i) == str2.charAt(i)){
				val++;
			}else{
				break;
			}
		}
		return val;
	}

	private static void print(String[] suffixes) {
		for(int i=0;i<suffixes.length;i++){
			System.out.println(suffixes[i]);
		}
	}

}
