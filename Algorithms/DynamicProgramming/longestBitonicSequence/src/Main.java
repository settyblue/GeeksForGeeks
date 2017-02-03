import static java.lang.Math.max;
/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-15-longest-bitonic-subsequence/
 * 
 * Given an array arr[0 … n-1] containing n positive integers, a subsequence of arr[] is 
 * called Bitonic if it is first increasing, then decreasing. Write a function that takes 
 * an array as argument and returns the length of the longest bitonic subsequence.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		//int[] array = {1, 11, 2, 10, 4, 5, 2, 1}; //6
		//int[] array = {12, 11, 40, 5, 3, 1}; //5
		//int[] array = {80, 60, 30, 40, 20, 10}; //5
		int[] array = {8, 5, 3, 2, 4};
		System.out.println("length of longest bitonic sequence = "+lengthLongestBitonicSequence(array));

	}
	
	public static int lengthLongestBitonicSequence(int[] array){
		int al = array.length;
		int[] lis = new int[al];
		for(int i=0; i<al; i++){
			lis[i] = 1;
		}
		
		for(int i=1; i<al; i++){
			for(int j=0; j<i; j++){
				if(array[i] > array[j] && lis[i] < lis[j] + 1){
					lis[i] = lis[j]+1;
				}
			}
		}
		
		int[] lds = new int[al];
		for(int i=0; i<al; i++){
			lds[i] = 1;
		}
		
		for(int i=1; i<al; i++){
			for(int j=0; j<i; j++){
				if(array[i] < array[j] && lds[i] < lds[j] + 1){
					lds[i] = lds[j]+1;
				}
			}
		}
		
		int maxBitonicLength = 0;
		for(int i=0; i<al; i++){
			maxBitonicLength = max(maxBitonicLength, lds[i]+lis[i]-1);
		}
		return maxBitonicLength;
	}
}
