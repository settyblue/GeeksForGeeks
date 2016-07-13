import java.util.Arrays;

/**
 * http://quiz.geeksforgeeks.org/bubble-sort/
 * 
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] array = {64, 25, 12, 22, 11, 66};
		//int[] array = {6, 5, 4, 3, 2, 2};
		//int[] array = {1, 2, 3, 4, 5, 6};
		bubbleSortAndPrint(array);

	}
	
	public static void bubbleSortAndPrint(int[] array){
		boolean swapped;
		for(int i=0; i<array.length-1; i++){
			swapped = false;
			for(int j=0; j<array.length-i-1; j++){
				if(array[j] > array[j+1]){
					swap(array,j,j+1);
					swapped = true;
				}
			}
			if(!swapped){
				break;
			}
		}
		System.out.println(Arrays.toString(array));
	}
	
	public static void swap(int[] array, int p, int q){
		int temp = array[p];
		array[p] = array[q];
		array[q] = temp;
	}
}
