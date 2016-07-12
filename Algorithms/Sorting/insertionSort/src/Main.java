import java.util.Arrays;

/**
 * http://quiz.geeksforgeeks.org/insertion-sort/
 * 
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		//int[] array = {64, 25, 12, 22, 11, 66};
		//int[] array = {6, 5, 4, 3, 2, 2};
		int[] array = {1, 2, 3, 4, 5, 6};
		insertionSortAndPrint(array);
	}
	
	public static void insertionSortAndPrint(int[] array){
		int i,j,key;
		for(i=1; i<array.length; i++){
			j = i-1;
			key = array[i];
			while(j >= 0 && key < array[j]){
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = key;
		}
		System.out.println(Arrays.toString(array));
	}
}
