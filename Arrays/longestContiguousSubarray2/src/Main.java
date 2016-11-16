import static java.lang.Math.max;
import static java.lang.Math.min;
import java.util.HashSet;

/**
 * http://www.geeksforgeeks.org/length-largest-subarray-contiguous-elements-set-2/
 * 
 * Given an array of integers, find length of the longest subarray which contains 
 * numbers that can be arranged in a continuous sequence.
 * 
 * Input:  arr[] = {10, 12, 12, 10, 10, 11, 10};
 * Output: Length of the longest contiguous subarray is 2 
 * 
 * Numbers in the array can be repeated.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] array = {10, 12, 12, 10, 10, 11, 10};//2
		//int[] array = {10, 12, 12, 10, 12, 11, 10};//3
		printLongestContiguousSubarray(array);
	}
	
	public static void printLongestContiguousSubarray(int[] array){
		int maxLength = 1;
		int max,min;
		for(int i=0; i<array.length; i++){
			max = array[i];
			min = array[i];
			HashSet<Integer> set = new HashSet<Integer>();
			set.add(array[i]);
			for(int j=i+1; j< array.length; j++){
				if(set.contains(array[j])){
					break;
				}else{
					set.add(array[j]);
				}
				max = max(max,array[j]);
				min = min(min,array[j]);
				if(j-i == max-min){
					maxLength = max(maxLength,j-i+1);
				}
			}
		}
		System.out.println("The max length is "+maxLength);
	}

}
