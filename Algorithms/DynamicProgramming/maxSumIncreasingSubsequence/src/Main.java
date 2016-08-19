import static java.lang.Math.max;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-14-maximum-sum-increasing-subsequence/
 * Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence 
 * of the given array such that the intgers in the subsequence are sorted in increasing order. 
 * For example, if input is {1, 101, 2, 3, 100, 4, 5}, then output should be 106 (1 + 2 + 3 + 100), 
 * if the input array is {3, 4, 5, 10}, then output should be 22 (3 + 4 + 5 + 10) and 
 * if the input array is {10, 5, 4, 3}, then output should be 10.
 * 
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] array = {1, 101, 2, 3, 100, 4, 95};//106
		//int[] array = {1, 101, 2, 3, 100, 4, 97};//107
		System.out.println("Max sum of increasing subsequence "+maxSumIncSubSeq(array));

	}
	
	public static int maxSumIncSubSeq(int[] array){
		int[] maxSum = new int[array.length];
		maxSum[0] = 1;
		for(int i=1;i<array.length;i++){
			for(int j=0; j<i; j++){
				if(array[i] > array[j] && maxSum[j]+array[i] > maxSum[i]){
					maxSum[i] = maxSum[j]+array[i];
				}
			}
		}
		int max = 0;
		for(int i=0; i<array.length; i++){
			max = max(maxSum[i],max);
		}
		return max;
	}
}
