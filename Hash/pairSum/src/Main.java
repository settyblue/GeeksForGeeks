import java.util.HashMap;

/**
 * http://www.geeksforgeeks.org/write-a-c-program-that-given-a-set-a-of-n-numbers-and-another-number-x-determines-whether-or-not-there-exist-two-elements-in-s-whose-sum-is-exactly-x/
 * Given an array A[] and a number x, check for pair in A[] with sum as x.
 * Write a C program that, given an array A[] of n numbers and another number x, 
 * determines whether or not there exist two elements in S whose sum is exactly x. 
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] array = {1, 4, 45, 6, 10, 8};
		int sum = 19;
		if(checkPairNumbers(array, sum)){
			System.out.println("pair of numbers equalling the sum exist.");
		}else{
			System.out.println("pair of numbers equalling the sum dont exist.");
		}
		
	}

	private static boolean checkPairNumbers(int[] array, int sum) {
		HashMap<Integer,Boolean> map = new HashMap<Integer,Boolean>();
		//Boolean result = false;
		for(int i=0; i<array.length; i++){
			if(map.containsKey(sum - array[i])){
				System.out.println("pair of numbers are : "+array[i]+" and "+(sum-array[i]));
				return true;
			}else{
				map.put(array[i], true);
			}
		}
		return false;
	}

}
