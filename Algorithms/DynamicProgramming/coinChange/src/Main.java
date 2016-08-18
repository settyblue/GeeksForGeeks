/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
 * 
 * Given a value N, if we want to make change for N cents, 
 * and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, 
 * how many ways can we make the change? The order of coins doesn’t matter.
 * 
 * For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. 
 * So output should be 4. 
 * For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. 
 * So the output should be 5.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		//int n = 10;int[] s = {2, 5, 3, 6};//5
		//int n = 1;int[] s = {1, 2, 3}; //4
		int n = 2; int[] s = {3, 4, 5};
		System.out.println("Number of solutions : "+noOfSolutions(n,s));

	}
	
	public static int noOfSolutions(int n, int[] s){
		int sl = s.length;
		int[][] solutions = new int[n+1][sl];
		for(int j=0; j<sl; j++){
			solutions[0][j] = 1;
		}
		for(int i=1; i<n+1; i++){
			for(int j=0; j<sl; j++){
				int x,y;
				if(i-s[j] >= 0){
					solutions[i][j] = solutions[i-s[j]][j];
				}
				if(j>=1){
					solutions[i][j] += solutions[i][j-1];
				}
			}
		}
		return solutions[n][sl-1];
	}

}
