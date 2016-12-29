/**
 * http://www.geeksforgeeks.org/maximum-difference-between-two-elements/
 * 
 * Given an array arr[] of integers, find out the difference between 
 * any two elements such that larger element appears after the smaller number in arr[].
 * 
 * Examples: If array is [2, 3, 10, 6, 4, 8, 1] then returned value should be 8 (Diff between 10 and 2). 
 * If array is [ 7, 9, 5, 6, 3, 2 ] then returned value should be 2 (Diff between 7 and 9)
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		//int[] A = {2, 3, 10, 6, 4, 8, 1};
		int[] array = {7, 9, 5, 6, 3, 2};
		System.out.println(maxDiff(array));
	}

	private static int maxDiff(int[] a) {
		int maxDiff = 0;
		int smallestTillNow = a[0];
		
		for(int i=1; i<a.length; i++){
			maxDiff = Math.max(maxDiff, a[i]-smallestTillNow);
			smallestTillNow = Math.min(a[i], smallestTillNow);
		}
		return maxDiff;
	}

}
