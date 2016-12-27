import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/find-subarray-with-given-sum/
 * 
 * Given an unsorted array of nonnegative integers, find a 
 * continous subarray which adds to a given number.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		//int[] array = {1, 4, 20, 3, 10, 5};
		//int[] array = {20, 3, 10};
		int[] array = {20, 3, 1};
		int sum = 33;
		printSubArrayWithSum(array, sum);
	}

	private static void printSubArrayWithSum(int[] array, int sum) {
		int start = 0; 
		int end = 1;
		boolean done = false;
		int curSum = array[0];
		while(start < end && end < array.length){
			if(curSum == sum){
				done = true;
				System.out.println(Arrays.toString(Arrays.copyOfRange(array, start, end)));
				break;
			}
			if(curSum < sum){
				curSum += array[end];
				end++;
			}else{
				curSum -= array[start];
				start++;
			}
		}
		
		if(!done && curSum == sum){
			System.out.println(Arrays.toString(Arrays.copyOfRange(array, start, end)));
		}
	}

}
