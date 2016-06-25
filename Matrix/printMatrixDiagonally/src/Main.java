/**
 * http://www.geeksforgeeks.org/print-matrix-diagonally/
 * Given a 2D matrix, print all elements of the given matrix 
 * in diagonal order. For example, consider the following 5 X 4 input matrix.
 * 
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[][] matrix = new int[5][4];
		for(int i=0;i<5;i++){
			for(int j=0;j<4;j++){
				matrix[i][j] = i*4+j;
			}
		}
		for(int i=0;i<5;i++){
			for(int j=0;j<4;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		printDiagonally(matrix);
	}
	
	public static void printDiagonally(int[][] matrix){
		for(int sum=0; sum<matrix.length+matrix[0].length-1; sum++){
			for(int i=matrix.length-1;i>=0;i--){
				int j = sum-i;
				if(j>=0 && j<matrix[0].length){
					System.out.print(matrix[i][j]+" ");
				}
			}
			System.out.println();
		}
	}
}
