/**
 * http://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
 * Given a binary matrix, find out the maximum size square sub-matrix with all 1s.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[][] matrix = {{0,  1,  1,  0,  1,}, 
				   		  {1,  1,  0,  1,  0}, 
				          {0,  1,  1,  1,  0},
				          {1,  1,  1,  1,  0},
				          {1,  1,  1,  1,  1}};
		
		System.out.println("max sub matrix size = "+getMaxSubmatrixSize(matrix));
	}
	
	public static int getMaxSubmatrixSize(int[][] matrix){
		int maxSize = 0;
		int[][] maxMatrix = new int[matrix.length][matrix[0].length];
		
		for(int i=0; i<maxMatrix.length; i++){
			for(int j=0; j<maxMatrix[0].length; j++){
				if(i==0 || j==0){
					maxMatrix[i][j] = matrix[i][j];
				}else{
					if(matrix[i][j] == 1){
						maxMatrix[i][j] = Math.min(maxMatrix[i-1][j], Math.min(maxMatrix[i][j-1], maxMatrix[i-1][j-1]))+1;
					}
					maxSize = Math.max(maxMatrix[i][j], maxSize);
				}
			}
		}
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				System.out.print(maxMatrix[i][j]+" ");
			}
			System.out.println();
		}
		
		return maxSize;
	}
}
