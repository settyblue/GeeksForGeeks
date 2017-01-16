/**
 * http://www.geeksforgeeks.org/check-given-string-rotation-palindrome/
 * 
 * Given a string, check if it is a rotation of a palindrome. 
 * For example your function should return true for “aab” as it is a rotation of “aba”.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		//String s = "aad";
		//String s = "aada";
		String s = "aabb";
		if(checkRotatedPalindrome(s)){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
	}

	private static boolean checkRotatedPalindrome(String s) {
		return checkPalindromeOfGivenSize(s+s, s.length());
	}

	private static boolean checkPalindromeOfGivenSize(String str, int p) {
		int n = str.length();
		int[][] maxLen = new int[n][n];
		boolean[][] check = new boolean[n][n];
		for(int j=0; j<n;j++){
			for(int i=0;i<n-j;i++){
				if(j==0){
					maxLen[i][i+j] = 1;
					check[i][i+j] = true;
				}else if(j==1){
					if(str.charAt(i)==str.charAt(i+1)){
						maxLen[i][i+j] = 2;
						check[i][i+j] = true;
					}
				}else{
					if(str.charAt(i)==str.charAt(i+j) && check[i+1][i+j-1]){
						maxLen[i][i+j] = maxLen[i+1][i+j-1]+2;
						check[i][i+j] = true;
					}else{
						check[i][i+j] = false;
					}
				}
			}
		}
		print(maxLen);
		print(check);
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(maxLen[i][j] == p){
					return true;
				}
			}
		}
		return false;
	}
	
	private static void print(int[][] maxLen) {
		for(int i=0;i<maxLen.length;i++){
			for(int j=0;j<maxLen[0].length; j++){
				System.out.print(maxLen[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	private static void print(boolean[][] maxLen) {
		for(int i=0;i<maxLen.length;i++){
			for(int j=0;j<maxLen[0].length; j++){
				System.out.print(maxLen[i][j]+" ");
			}
			System.out.println();
		}
	}
}
