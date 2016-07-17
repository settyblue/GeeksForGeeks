/**
 * http://www.geeksforgeeks.org/magic-square/
 * 
 * A magic square of order n is an arrangement 
 * of n^2 numbers, usually distinct integers, in a square, 
 * such that the n numbers in all rows, all columns, and both 
 * diagonals sum to the same constant. A magic square contains 
 * the integers from 1 to n^2.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int n = 5;
		printMagicSquare(n);
	}
	//TODO: works for odd n not for even n.
	public static void printMagicSquare(int n){
		int i = n/2;
		int j = n-1;
		int[][] magicSquare = new int[n][n];
		for(int count=1; count<=n*n; count++){
			magicSquare[i][j] = count;
			if(count%n==0){
				j = (j-1)%n>=0?(j-1)%n:(j-1)%n+n;
			}else{
				i = (i-1)%n>=0?(i-1)%n:(i-1)%n+n;
				j = (j+1)%n>=0?(j+1)%n:(j+1)%n+n;
			}
		}
		printMatrix(magicSquare);
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
