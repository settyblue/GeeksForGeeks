/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-17-palindrome-partitioning/
 * 
 * Given a string, a partitioning of the string is a palindrome partitioning if 
 * every substring of the partition is a palindrome. 
 * For example, “aba|b|bbabb|a|b|aba” is a palindrome partitioning of “ababbbabbababa”. 
 * 
 * Determine the fewest cuts needed for palindrome partitioning of a given string. 
 * For example, minimum 3 cuts are needed for “ababbbabbababa”. 
 * The three cuts are “a|babbbab|b|ababa”. 
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		String s = "ababbbabbababa"; //3
		System.out.println(minPalindromePartitions(s));
	}

	private static int minPalindromePartitions(String s) {
		int n = s.length();
		int[] cost = new int[n];
		boolean[][] p = new boolean[n][n];
		
		for(int i=0;i<n;i++){
			p[i][i] = true;
		}
		
		for(int L=1;L<=n;L++){
			for(int i=0; i<n-L+1; i++){
				int j = i+L-1;
				if(L==1){
					p[i][j] = true;
				}else if(L==2){
					if(s.charAt(i) == s.charAt(j)){
						p[i][j] = true;
					}
				}else{
					if(s.charAt(i) == s.charAt(j) && p[i+1][j-1]){
						p[i][j] = true;
					}
				}
			}
		}
		
		for(int i=1;i<n;i++){
			if(p[0][i]){
				cost[i] = 0;
			}else{
				cost[i] = Integer.MAX_VALUE;
				for(int j=0;j<i;j++){
					if(p[j+1][i] && cost[j]+1 < cost[i]){
						cost[i] = cost[j]+1;
					}
				}
			}
		}
		return cost[n-1];
	}

}
