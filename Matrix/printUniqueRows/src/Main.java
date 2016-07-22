import java.util.HashSet;
/**
 * http://www.geeksforgeeks.org/print-unique-rows/
 * 
 * Given a binary matrix, print all unique rows of the given matrix.
 * Input:
 * 		   {0, 1, 0, 0, 1}
 *         {1, 0, 1, 1, 0}
 *         {0, 1, 0, 0, 1}
 *         {1, 1, 1, 0, 0}
 * Output:
 * 		0 1 0 0 1 
 * 		1 0 1 1 0 
 * 		1 1 1 0 0 
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[][] matrix = {{0, 1, 0, 0, 1},
		        		  {1, 0, 1, 1, 0},
		        		  {0, 1, 0, 0, 1},
		        		  {1, 0, 1, 0, 0},
		        		  {0, 0, 0, 0, 0}};
		printUniqueRows(matrix);

	}
	
	public static void printUniqueRows(int[][] matrix){
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0; i<matrix.length; i++){
			int rowNum = 0;
			int placeValue = 1;
			for(int j=matrix[0].length-1; j>=0; j--){
				if(matrix[i][j] == 1){
					rowNum = rowNum + placeValue;
				}
				placeValue = placeValue*2;
			}
			if(set.add(rowNum)){
				if(Integer.toBinaryString(rowNum).length() < matrix[0].length){
					for(int k=0;k<matrix[0].length-Integer.toBinaryString(rowNum).length();k++){
						System.out.print("0");
					}
				}
				System.out.println(Integer.toBinaryString(rowNum));
			}
		}
	}

}
