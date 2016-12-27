import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/a-product-array-puzzle/
 * 
 * Given an array arr[] of n integers, construct a 
 * Product Array prod[] (of same size) such that prod[i] is equal 
 * to the product of all the elements of arr[] except arr[i]. 
 * Solve it without division operator and in O(n).
 * 
 * arr[] = {10, 3, 5, 6, 2}
 * prod[] = {180, 600, 360, 300, 900}
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] array = {10, 3, 5, 6, 2};
		
		System.out.println(Arrays.toString(productArray(array)));

	}

	private static int[] productArray(int[] array) {
		int n = array.length;
		int[] prodArray = new int[n];
		
		prodArray[0] = 1;
		for(int i=1; i<n; i++){
			prodArray[i] = prodArray[i-1]*array[i-1];
		}
		
		int temp = 1;
		for(int i=n-2; i>=0; i--){
			temp *= array[i+1];
			prodArray[i] *= temp;
		}
		
		return prodArray;
	}

}
