/**
 * http://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		String s = "HelloworlddlrowHello";
		printLongestPalindromicSubstring(s);
	}
	
	public static void printLongestPalindromicSubstring(String s){
		int slen = s.length();
		boolean[][] mat = new boolean[slen][slen];
		int maxLen = 1, start = 0;
		for(int i=0; i<slen; i++){
			mat[i][i] = true;
		}
		
		for(int subStrLen=2; subStrLen<=slen; subStrLen++){
			for(int i=0; i<slen-subStrLen+1;i++){
				int j = i+subStrLen-1;
				if(s.charAt(i) == s.charAt(j) && subStrLen==2){
					mat[i][j] = true;
					maxLen = 2;
					start = i;
				}else if(s.charAt(i) == s.charAt(j) && mat[i+1][j-1]){
					mat[i][j] = true;
					maxLen = subStrLen;
					start = i;
				}else{
					mat[i][j] = false;
				}
			}
		}
		System.out.println(s.substring(start, start+maxLen));
	}
}
