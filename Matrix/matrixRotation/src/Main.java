/**
 * Left and Right Rotate Square Matrix.
 * http://www.geeksforgeeks.org/turn-an-image-by-90-degree/
 * http://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[][] matrix = new int[5][5];
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				matrix[i][j] = i*matrix.length+j;
			}
		}
		
		printMatrix(matrix);
		rightRotateMatrix(matrix); //does a anti-clockwise rotation.
		printMatrix(matrix);
	}
	
	public static void printMatrix(int[][] matrix){
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				System.out.print(matrix[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void leftRotateMatrix(int[][] matrix){
		int temp,n=matrix.length;
		for(int i=0; i<(matrix.length+1)/2; i++){
			for(int j=0; j<(matrix[0].length)/2;j++){
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][n-i-1];
				matrix[j][n-i-1] = matrix[n-i-1][n-j-1];
				matrix[n-i-1][n-j-1] = matrix[n-j-1][i];
				matrix[n-j-1][i] = temp;
			}
		}
	}
	
	public static void rightRotateMatrix(int[][] matrix){
		int temp,n=matrix.length;
		for(int i=0; i<(matrix.length+1)/2; i++){
			for(int j=0; j<(matrix[0].length)/2;j++){
				temp = matrix[i][j];
				matrix[i][j] = matrix[n-j-1][i];
				matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
				matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
				matrix[j][n-i-1] = temp;
			}
		}
	}
}
