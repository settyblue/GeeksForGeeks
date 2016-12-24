import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/reverse-an-array-in-groups-of-given-size/
 * 
 * Given an array, reverse every sub-array formed by consecutive k elements.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8,9};
		int k = 3;
		System.out.println(Arrays.toString(array));
		reverseElements(array,k);
		System.out.println(Arrays.toString(array));
	}
	
	public static void reverseElements(int[] array, int k){
		int len = array.length;
		int i=0;
		for(i=0;i< len/k;i++){
			int start=i*k, end=(i+1)*k-1;
			while(start<end){
				swap(array,start++,end--);
			}
		}
		if(i*k < len-1){
			int start=i*k, end=len-1;
			while(start<end){
				swap(array,start++,end--);
			}
		}
	}
	
	public static void swap(int[] array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
