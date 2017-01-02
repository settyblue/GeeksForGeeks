/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-8-matrix-chain-multiplication/
 * 
 * Given a sequence of matrices, find the most efficient way to multiply these matrices together. 
 * The problem is not actually to perform the multiplications, but merely to decide in which order to perform the multiplications.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] array = {10, 20, 30, 40, 30};
		
		System.out.println(minCostRecursive(array));
		System.out.println(minCostDP(array));
	}

	private static int minCostRecursive(int[] array) {
		
		int n = array.length;
		return minCostRecursive(array,1,n-1);
	}

	private static int minCostRecursive(int[] array, int start, int end) {
		if(start == end)return 0;
		int minCost = Integer.MAX_VALUE;
		for(int i=start;i<end;i++){
			int curMinCost = minCostRecursive(array,start,i) +
							 array[start-1]*array[i]*array[end] + 
							 minCostRecursive(array,i+1,end);
			minCost = Math.min(minCost, curMinCost);
		}
		return minCost;
	}
	
	private static int minCostDP(int[] array){
		//int minCost = Integer.MAX_VALUE;
		int n = array.length;
		int[][] val = new int[n][n];
		
		for(int L=2; L < n;L++){
			for(int i=1; i<n-L+1; i++){
				int j = i+L-1;
				int curMinCost = Integer.MAX_VALUE;
				for(int k=i;k<j;k++){
					int curCost = val[i][k]+val[k+1][j]+array[i-1]*array[k]*array[j];
					curMinCost = Math.min(curMinCost, curCost);
				}
				val[i][j] = curMinCost;
			}
		}
		
		return val[1][n-1];
	}
}
