import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/longest-consecutive-subsequence/
 * 
 * Longest Consecutive Subsequence
 * Given an array of integers, find the length of the longest sub-sequence such 
 * that elements in the subsequence are consecutive integers, the consecutive 
 * numbers can be in any order.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] array={1, 9, 4, 10, 3, 20, 2};
		printLengthOfLongestConsecutiveSubsequence(array);

	}
	
	//Implemented using sorting.
	private static void printLengthOfLongestConsecutiveSubsequence(int[] array) {
		int prevInt = array[0];
		int maxLength = 0;
		int curLength = 1;
		
		Arrays.sort(array);
		
		for(int i=1; i< array.length; i++){
			if(array[i]-prevInt == 1){
				curLength++;
			}else{
				maxLength = Math.max(maxLength, curLength);
				curLength = 1;
			}
			prevInt = array[i];
		}
		
		System.out.println("Maximum subsequence length : "+maxLength);
	}

}
