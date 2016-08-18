import static java.lang.Math.max;
/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/
 * 
 * Given weights and values of n items, put these items in a knapsack 
 * of capacity W to get the maximum total value in the knapsack. 
 * 
 * In other words, given two integer arrays val[0..n-1] and wt[0..n-1] 
 * which represent values and weights associated with n items respectively. 
 * Also given an integer W which represents knapsack capacity, find out the 
 * maximum value subset of val[] such that sum of the weights of this subset 
 * is smaller than or equal to W. You cannot break an item, either pick the 
 * complete item, or don’t pick it (0-1 property).
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] value = {60, 100, 120};
		int[] weights = {10, 20, 30};
		int weightLimit = 50;
		
		printMaxValue(value, weights, weightLimit);

	}
	
	public static void printMaxValue(int[] value, int[] weights, int weightLimit){
		int[][] maxValue = new int[value.length+1][weightLimit+1];
		
		for(int i=1; i<=value.length; i++){
			for(int w=1; w<=weightLimit; w++){
				if(w-weights[i-1] >= 0){
					maxValue[i][w] = max(maxValue[i-1][w], maxValue[i-1][w-weights[i-1]]+value[i-1]);
				}else{
					maxValue[i][w] = maxValue[i-1][w];
				}
			}
		}
		//printMatrix(maxValue);
		System.out.print("max value possible = "+maxValue[value.length][weightLimit]);
	}
	
	public static void printMatrix(int[][] matrix){
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[0].length; j++){
				System.out.print(matrix[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
