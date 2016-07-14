/**
 * http://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
 * Given a 2D array, print it in spiral form. See the following examples.
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
				matrix[i][j] = i*matrix[0].length+j;
			}
		}
		printMatrix(matrix);
		printSpiralMatrix(matrix);

	}
	
	public static void printSpiralMatrix(int[][] matrix){
		int firstRow=0,lastCol=matrix[0].length-1,lastRow=matrix.length-1,firstCol=0;
		while(firstRow<=lastRow && firstCol<=lastCol){
			for(int i=firstCol; i<=lastCol; i++){
				System.out.print(matrix[firstRow][i]+" ");
			}
			firstRow++;
			for(int i=firstRow; i<=lastRow; i++){
				System.out.print(matrix[i][lastCol]+" ");
			}
			lastCol--;
			if(firstRow<=lastRow){
				for(int i=lastCol; i>=firstCol; i--){
					System.out.print(matrix[lastRow][i]+" ");
				}
				lastRow--;
			}
			if(firstCol<=lastCol){
				for(int i=lastRow; i>=firstRow; i--){
					System.out.print(matrix[i][firstCol]+" ");
				}
				firstCol++;
			}
		}
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
}
