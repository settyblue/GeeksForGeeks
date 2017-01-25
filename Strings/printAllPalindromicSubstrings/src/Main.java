import java.util.HashSet;

/**
 * http://www.geeksforgeeks.org/find-number-distinct-palindromic-sub-strings-given-string/
 * 
 * Given a string of lowercase ASCII characters, find all distinct continuous palindromic sub-strings of it.
 * 
 * Input: str = "geek"
 * Output:  Below are 4 palindrome sub-strings
 * 		e
 * 		ee
 * 		g
 * 		k
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		//String s = "geek";
		String s = "abcabbaba";
		printAllPalindromicSubstrings(s);

	}

	private static void printAllPalindromicSubstrings(String s) {
		int n = s.length();
		//int[][] len = new int[n][n];
		boolean[][] check = new boolean[n][n];
		
		for(int j=0;j<n;j++){
			for(int i=0;i<n-j;i++){
				if(j==0){
					//len[i][i+j] = 1;
					check[i][i+j] = true;
				}else if(j==1){
					if(s.charAt(i)==s.charAt(i+1)){
						//len[i][i+1] = 2;
						check[i][i+1] = true;
					}else{
						//len[i][i+1] = 0;
						check[i][i+1] = false;
					}
				}else{
					if(s.charAt(i) == s.charAt(i+j) && check[i+1][i+1+j-2]){
						check[i][i+j] = true;
						//len[i][i+j] = 
					}else{
						check[i][i+j] = false;
					}
				}
			}
		}
		
		HashSet<String> set = new HashSet<String>();
		for(int i=0;i<n;i++){
			for(int j=i;j<n;j++){
				if(check[i][j]){
					set.add(s.substring(i,j+1));
				}
			}
		}
		
		for(String str:set){
			System.out.println(str);
		}
	}

}
