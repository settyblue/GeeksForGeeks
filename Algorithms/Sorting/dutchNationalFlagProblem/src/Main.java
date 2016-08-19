import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 * https://www.careercup.com/question?id=5702373701844992   -- similar
 * https://www.careercup.com/question?id=2245664
 * 
 * Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[]. The functions should put all 0s first, then all 1s and all 2s in last.
 * 
 * Example
 * Input = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
 * Output = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] array = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		sort(array);
		System.out.println(Arrays.toString(array));
	}
	
	public static void sort(int[] array){
		int start=0,end=array.length-1;
		for(int mid=0; mid<=end; ){
			if(array[mid] == 0){
				swap(array,start,mid);
				start++;mid++;
			}else if(array[mid]==1){
				mid++;
			}else{
				swap(array,mid,end);
				end--;
			}
		}
	}
	
	public static void swap(int[] array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
}
