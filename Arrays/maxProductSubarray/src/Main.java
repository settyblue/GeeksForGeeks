/**
 * http://www.geeksforgeeks.org/maximum-product-subarray/
 * 
 * Given an array that contains both positive and negative integers, 
 * find the product of the maximum product subarray. 
 * Expected Time complexity is O(n) and only O(1) extra space can be used.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] array = {6, -3, -10, 0, 2};
		System.out.println(maxProductSubarray(array));
	}

	private static int maxProductSubarray(int[] array) {
		int n = array.length;
		int maxProdSoFar = 1;
		int maxEndingHere = 1;
		int minEndingHere = 1;
		
		for(int i=0; i<n; i++){
			if(array[i] > 0){
				maxEndingHere = maxEndingHere*array[i];
				minEndingHere = Math.min(minEndingHere*array[i],1);
			}else if(array[i] == 0){
				maxEndingHere = 1;
				minEndingHere = 1;
			}else {
				int temp = maxEndingHere;
				maxEndingHere = Math.max(array[i]*minEndingHere, 1);
				minEndingHere = temp*array[i];
			}
			
			maxProdSoFar = Math.max(maxProdSoFar, maxEndingHere);
		}
		
		return maxProdSoFar;
	}

}
