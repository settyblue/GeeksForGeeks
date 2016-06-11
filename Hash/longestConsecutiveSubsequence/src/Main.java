import java.util.Arrays;
import java.util.HashSet;

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
		//int[] array={1, 9, 4, 10, 3, 20, 2};
		//printLengthOfLongestConsecutiveSubsequence(array);
		Integer[] array={2, 9, 1, 10, 3, 20, 2};
		printLengthOfLongestConsecutiveSubsequence2(array);

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
	
	//Implemented using hashing.
	private static void printLengthOfLongestConsecutiveSubsequence2(Integer[] array) {
		HashSet<Integer> set = new HashSet<Integer>();
		set.addAll(Arrays.asList(array));
		int curLength, curElem;
		int maxLength = 0;
		for(int i=0; i<set.size(); i++){
			if(set.contains(array[i]-1)){
				continue;
			}
			curLength = 0;
			curElem = array[i];
			while(set.contains(curElem)){
				curElem++;
				curLength++;
			}
			maxLength = Math.max(maxLength, curLength);
		}
		
		System.out.println("Maximum subsequence length : "+maxLength);
	}
}
