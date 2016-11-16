import static java.lang.Math.min;
import static java.lang.Math.max;
/**
 * http://www.geeksforgeeks.org/length-largest-subarray-contiguous-elements-set-1/
 * 
 * Given an array of distinct integers, find length of the longest subarray which 
 * contains numbers that can be arranged in a continuous sequence.
 * 
 * Input:  arr[] = {10, 12, 11};
 * Output: Length of the longest contiguous subarray is 3
 * 
 * Input:  arr[] = {14, 12, 11, 20};
 * Output: Length of the longest contiguous subarray is 2
 * 
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		//int[] array = {14, 12, 11, 20};//2
		int[] array = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};//5
		
		printLongestContiguousSubarray(array);
	}
	
	public static void printLongestContiguousSubarray(int[] array){
		int maxLength = 1;
		int max,min;
		for(int i=0; i<array.length; i++){
			max = array[i];
			min = array[i];
			for(int j=i+1; j< array.length; j++){
				max = max(max,array[j]);
				min = min(min,array[j]);
				//System.out.println(max+" "+min+" "+i+" "+j);
				if(j-i == max-min){
					maxLength = max(maxLength,j-i+1);
				}
			}
		}
		System.out.println("The max length is "+maxLength);
	}
}
