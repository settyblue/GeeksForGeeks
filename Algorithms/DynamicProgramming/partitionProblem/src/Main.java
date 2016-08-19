/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-18-partition-problem/
 * https://www.careercup.com/question?id=5095048703115264
 * Partition problem is to determine whether a given set can be partitioned 
 * into two subsets such that the sum of elements in both subsets is same.
 * arr[] = {1, 5, 11, 5}
 * Output: true 
 * The array can be partitioned as {1, 5, 5} and {11}
 * 
 * arr[] = {1, 5, 3}
 * Output: false 
 * The array cannot be partitioned into equal sum sets.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] array = {1, 5, 11, 5, 2};
		if(canBePartitioned(array)){
			System.out.println("the given array can be partitioned.");
		}else{
			System.out.println("the given array cannot be partitioned.");
		}
		
	}
	
	public static boolean canBePartitioned(int[] array){
		int sum = 0;
		for(int i=0; i<array.length; i++){
			sum += array[i];
		}
		
		if(sum%1 == 1){
			return false;
		}
		
		boolean[][] partition = new boolean[sum/2+1][array.length+1];
		for(int i=0;i<array.length+1;i++){
			partition[0][i] = true;
		}
		for(int i=1;i<sum/2+1; i++){
			partition[i][0] = false;
		}
		for(int i=1; i<sum/2+1; i++){
			for(int j=1; j<array.length+1; j++){
				partition[i][j] = partition[i][j-1];
				if(i >= array[j-1])partition[i][j] = partition[i-array[j-1]][j-1] || partition[i][j];
			}
		}
		//printMatrix(partition);
		printSets(partition,array);
		return partition[sum/2][array.length];
	}
	
	public static void printMatrix(boolean[][] partition){
		for(int i=0; i<partition.length; i++){
			for(int j=0; j<partition[0].length; j++){
				System.out.print(partition[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	//TODO: Implement logic to print the elements of the two separate sets.
	public static void printSets(boolean[][] partition, int[] array){
		int i = partition.length-array[array.length-1]-1;
		int j = partition[0].length-1;
		System.out.println(array[partition[0].length-2]);
		while(i>0 && j>0){
			if(partition[i][j]){
				
			}
		}
	}
}	
