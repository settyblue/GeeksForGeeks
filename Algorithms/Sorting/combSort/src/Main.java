import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/comb-sort/
 * Improvement over bubble sort
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
		System.out.println(Arrays.toString(array));
		combSortAndPrint(array);

	}
	
	public static void combSortAndPrint(int[] array){
		boolean swapped = true;
		int gap = array.length;
		while(gap != 1 || swapped){
			gap = getNextGap(gap);
			swapped = false;
			for(int i=0; i<array.length-gap; i++){
				if(array[i] > array[i+gap] ){
					swap(array,i,i+gap);
					swapped=true;
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}
	
	public static int getNextGap(int n){
		int m = (n*10)/13;
		if(m >= 1){
			return m;
		}
		return 1; 
	}
	
	public static void swap(int[] array, int p, int q){
		int temp = array[p];
		array[p] = array[q];
		array[q] = temp;
	}
}
