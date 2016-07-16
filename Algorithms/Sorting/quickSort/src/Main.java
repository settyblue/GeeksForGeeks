import java.util.Arrays;

/**
 * http://quiz.geeksforgeeks.org/quick-sort/
 * 
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		//int[] array = {64, 25, 12, 22, 11, 66};
		int[] array = {6, 5, 4, 3, 2, 2};
		//int[] array = {1, 2, 3, 4, 5, 6};
		quickSortAndPrint(array);

	}
	
	public static void quickSortAndPrint(int[] array){
		System.out.println(Arrays.toString(array));
		quickSort(array,0,array.length-1);
		System.out.println(Arrays.toString(array));
	}
	
	public static void quickSort(int[] array, int low, int high){
		if(low < high){
			int pivot = partition(array,low,high);
			quickSort(array,low,pivot-1);
			quickSort(array,pivot+1,high);
		}
	}
	
	public static int partition(int[] array, int low, int high){
		int pivotElement = array[high];
		int i = (low-1);//index of smaller element. i is already in place.
		for(int j=low; j<high; j++){
			if(array[j] <= pivotElement){
				i++;
				swap(array, i, j);
			}
		}
		
		swap(array,i+1,high);
		return i+1;
	}
	
	public static void swap(int[] array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
