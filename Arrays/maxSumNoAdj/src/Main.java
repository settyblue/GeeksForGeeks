/**
 * http://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
 * Maximum sum such that no two elements are adjacent
 * Question: Given an array of positive numbers, find the maximum sum 
 * of a subsequence with the constraint that no 2 numbers in the sequence 
 * should be adjacent in the array. So 3 2 7 10 should return 13 (sum of 3 and 10) 
 * or 3 2 5 10 7 should return 15 (sum of 3, 5 and 7).
 */

/**
 * @author rakshith
 *
 */
//solved using Dynamic Programming.

public class Main {

	public static void main(String[] args) {
		
		int[] array = {5, 5, -100, 100, 10, 15};
		System.out.println("Max sum = "+FindMaxSum(array, array.length));
	}

	private static int FindMaxSum(int[] array, int length) {
		if (length == 0){
			return -1;
		}
		int excluded_sum = 0;
		int included_sum = array[0];
		int temp;
		
		for(int i=1; i< length; i++){
			//if current element is to be excluded. store excluded sum in temp.
			temp = Math.max(included_sum, excluded_sum);
			
			//if current element is to be included given previous element was not included.
			included_sum = excluded_sum + array[i];
					
			//update excluded_sum.
			excluded_sum = temp;
			
		}
		return Math.max(included_sum, excluded_sum);
	}

}
