import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/counting-sort/
 * http://pages.cs.wisc.edu/~paton/readings/Old/fall08/LINEAR-SORTS.html
 * 
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] array = { 1, 4, 1, 2, 7, 5, 2};
		int k = 9;
		//countingSortAndPrint(array, k);
		countingSortAndPrint2(array, k);
	}
	
	//orthodox implementation - used for maintaining stability.
	public static void countingSortAndPrint(int[] array, int k){
		int[] countArray = new int[k+1];
		
		System.out.println(Arrays.toString(array));
		
		for(int i=0; i<array.length; i++){
			++countArray[array[i]];
		}
		
		for(int i=1;i<countArray.length;i++){
			countArray[i] += countArray[i-1];
		}
		
		int[] output = new int[array.length];
		for(int i=array.length-1; i>=0; i--){
			output[countArray[array[i]]-1] = array[i];
			countArray[array[i]]--;
		}
		
		for(int i=0; i<array.length; i++){
			array[i] = output[i]; 
		}
		
		System.out.println(Arrays.toString(array));
	}
	
	//my implementation. - no stability
	public static void countingSortAndPrint2(int[] array, int k){
		int[] countArray = new int[k+1];
		
		System.out.println(Arrays.toString(array));
		
		for(int i=0; i<array.length; i++){
			++countArray[array[i]];
		}
		
		int index = 0;
		for(int i=0; i<countArray.length; i++){
			int j=0;
			while(j<countArray[i]){
				array[index++] = i;
				j++;
			}
		}
		System.out.println(Arrays.toString(array));
	}
	
	//TODO: function to sort negative numbers.
	public static void countingSortNegativeAndPrint(int[] array, int k){
		
	}
	
}
