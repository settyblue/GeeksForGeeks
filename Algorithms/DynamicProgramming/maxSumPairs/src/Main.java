import java.util.Arrays;
import java.lang.Math;

/**
 * http://www.geeksforgeeks.org/maximum-sum-pairs-specific-difference/
 * Given an array of integers and a number k. We can pair two number of array if difference 
 * between them is strictly less than k. The task is to find maximum possible sum of disjoint pairs.
 * Sum of P pairs is sum of all 2P numbers of pairs.
 */

/**
 * @author Rakshith Kunchum
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] array = {3, 5, 10, 15, 17, 12, 9};
		int k = 4;
		System.out.println(maxSumPairs(array, k));

	}

	private static int maxSumPairs(int[] array, int k) {
		int n = array.length;
		int[] maxSum = new int[n];
		Arrays.sort(array);
		for(int i=1; i<n; i++){
			if(array[i]-array[i-1] < k ){
				if(i == 1){
					maxSum[i] = array[i]+array[i-1];
				}else{
					maxSum[i] = Math.max(maxSum[i-1],maxSum[i-2]+array[i]+array[i-1]);
				}
			}else{
				maxSum[i] = maxSum[i-1];
			}
		}
		return maxSum[n-1];
	}

}
