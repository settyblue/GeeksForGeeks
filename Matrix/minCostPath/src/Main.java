/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
 * 
 * Given a cost matrix cost[][] and a position (m, n) in cost[][], 
 * write a function that returns cost of minimum cost path to reach (m, n) from (0, 0).
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[][] costMatrix = { {1, 2, 3},
                			   {4, 8, 2},
                			   {1, 5, 3} };
		
		System.out.println("Minimum cost to traverse = "+minCost(costMatrix));

	}
	
	public static int minCost(int[][] costMatrix){
		int[][] totalCostMatrix = new int[costMatrix.length][costMatrix[0].length];
		totalCostMatrix[totalCostMatrix.length-1][totalCostMatrix[0].length-1] = 
				costMatrix[totalCostMatrix.length-1][totalCostMatrix[0].length-1];
		for(int j=totalCostMatrix[0].length-2; j>=0; j--){
			int lastRow = totalCostMatrix.length-1;
			totalCostMatrix[lastRow][j] = totalCostMatrix[lastRow][j+1] + costMatrix[lastRow][j];
		}
		for(int i=totalCostMatrix.length-2; i>=0; i--){
			int lastCol = totalCostMatrix[0].length-1;
			totalCostMatrix[i][lastCol] = totalCostMatrix[i+1][lastCol] + costMatrix[i][lastCol];
			for(int j=totalCostMatrix[0].length-2; j>=0; j--){
				totalCostMatrix[i][j] = costMatrix[i][j] + Math.min(totalCostMatrix[i+1][j+1],
						Math.min(totalCostMatrix[i+1][j], totalCostMatrix[i][j+1]));
			}
		}
		return totalCostMatrix[0][0];
	}
}
