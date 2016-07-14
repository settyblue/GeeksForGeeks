import java.util.Arrays;

/**
 * http://quiz.geeksforgeeks.org/selection-sort/
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
		selectSortAndPrint(array);
	}
	
	public static void selectSortAndPrint(int[] array){
		
		for(int i=0; i<array.length-1; i++){
			int minIndex = i;
			for(int j=i+1;j<array.length;j++){
				if(array[j]<array[minIndex]){
					minIndex = j;
				}
			}
			swap(array,i,minIndex);
		}
		System.out.println(Arrays.toString(array));
	}
	
	public static void swap(int[] array, int p, int q){
		int temp = array[p];
		array[p] = array[q];
		array[q] = temp;
	}
}
