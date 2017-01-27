import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/lexicographic-rank-of-a-string/
 * 
 * Given a string, find its rank among all its permutations sorted lexicographically. 
 * For example, rank of “abc” is 1, rank of “acb” is 2, and rank of “cba” is 6. 
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		String s = "string";
		System.out.println(s+" "+rankOfString(s));
		System.out.println("abc "+rankOfString("abc"));
		System.out.println("acb "+rankOfString("acb"));
	}

	private static int rankOfString(String s) {
		char[] sarr = s.toCharArray();
		Arrays.sort(sarr);
		String s_sorted = String.copyValueOf(sarr);
		
		return getRank(s,s_sorted,0)+1;
	}

	private static int getRank(String s, String s_sorted,int rank) {
		//System.out.println(s+", "+s_sorted);
		if(s.length()==1)return rank;
		if(s.charAt(0) == s_sorted.charAt(0))return getRank(s.substring(1),s_sorted.substring(1),rank);
		
		int c = s.charAt(0);
		int position = s_sorted.indexOf(c);
		int temp = position*(factorial(s.length()-1));
		return getRank(s.substring(1),s_sorted.substring(0,position)+s_sorted.substring(position+1,s_sorted.length()),rank+temp);
	}

	private static int factorial(int i) {
		if(i==1)return 1;
		return i*factorial(i-1);
	}

}
