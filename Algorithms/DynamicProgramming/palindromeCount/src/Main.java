/**
 * http://www.geeksforgeeks.org/count-palindromic-subsequence-given-string/
 * 
 * Find how many palindromic subsequence (need not necessarily be distinct) 
 * can be formed in a given string. Note that the empty string is not considered as a palindrome.
 */

/**
 * @author Rakshith Kunchum
 *
 */
public class Main {

	public static void main(String[] args) {
		//String str = "abcd";
		//String str = "abb";
		//String str = "aaaa";
		String str = "abba";
		
		System.out.println(maxPalindromes(str));
	}

	private static int maxPalindromes(String str) {
		int N = str.length();
		int[][] max = new int[N][N];
		
		for(int i=0; i<N; i++){
			max[i][i] = 1;
		}
		
		//check palindromes of length L;
		for(int L=2; L<N+1; L++){
			for(int i=0; i<N-L+1; i++){
				int j = i + L - 1;
				if(str.charAt(i) == str.charAt(j)){ 
					//Here we are not reducing by term max[i+1][j-1] because,
					//we have to count all the valid palindromes from i+1 to j-1
					//with and without attaching the chars at ith and jth place.
					max[i][j] = max[i+1][j]+ max[i][j-1] + 1;
				}else{
					max[i][j] = max[i+1][j]+ max[i][j-1] - max[i+1][j-1];
				}
			}
		}
		print(max);
		return max[0][N-1];
	}
	
	public static void print(int[][] max){
		for(int i=0; i<max.length; i++){
			for(int j=0; j<max[0].length; j++){
				System.out.print(max[i][j]+" ");
			}
			System.out.println();
		}
	}
}
