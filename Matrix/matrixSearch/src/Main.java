/**
 * http://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/
 * Given an n x n matrix, where every row and column is sorted 
 * in increasing order. Given a number x, how to decide whether 
 * this x is in the matrix. The designed algorithm should have 
 * linear time complexity.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[][] matrix = { {10, 20, 30, 40},
                		  {15, 25, 35, 45},
                		  {27, 29, 37, 48},
                		  {32, 33, 39, 50},};
		int n = 29;
		if(isFound(matrix,n)){
			System.out.println("Given number is found.");
		}else{
			System.out.println("Given number is not found.");
		}

	}

	public static boolean isFound(int[][] matrix, int n){
		int i=0,j=matrix[0].length-1;
		while(i>=0 && i<matrix.length && j>=0 && j<matrix[0].length){
			if(matrix[i][j] == n){
				System.out.println("("+i+", "+j+")");
				return true;
			}else if(matrix[i][j] > n){
				j--;
			}else{
				i++;
			}
		}
		
		return false;
	}
}
