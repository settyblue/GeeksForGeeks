/**
 * http://www.geeksforgeeks.org/maximum-length-bitonic-subarray/
 * 
 * Given an array A[0 … n-1] containing n positive integers, 
 * a subarray A[i … j] is bitonic if there is a k with i <= k <= j 
 * such that A[i] <= A[i + 1] ... <= A[k] >= A[k + 1] >= .. A[j – 1] > = A[j]. 
 * Write a function that takes an array as argument and returns the length 
 * of the maximum length bitonic subarray.
 * Expected time complexity of the solution is O(n)
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		//int[] array = {12, 4, 78, 90, 45, 23};
		int[] array = {1, 2, 3, 4};
		System.out.println(maxBitonicSubarray(array));
	}

	private static int maxBitonicSubarray(int[] array) {
		int n = array.length;
		int[] incr = new int[n];
		int[] decr = new int[n];
		
		incr[0] = 1;
		for(int i=1; i<n; i++){
			if(array[i] >= array[i-1]){
				incr[i] = incr[i-1]+1;
			}else{
				incr[i] = 1;
			}
		}
		
		decr[n-1] = 1;
		for(int i=n-2;i>=0;i--){
			if(array[i] >= array[i+1]){
				decr[i] = decr[i+1]+1;
			}else{
				decr[i] = 1;
			}
		}
		
		int maxLen = 0;
		for(int i=0; i<n; i++){
			maxLen = Math.max(maxLen, incr[i]+decr[i]-1);
		}
		return maxLen;
	}

}
