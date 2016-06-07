/**
 * http://www.geeksforgeeks.org/find-the-number-occurring-odd-number-of-times/
 * Find the Number Occurring Odd Number of Times
 * Given an array of positive integers. 
 * All numbers occur even number of times except one number which occurs odd number of times. 
 * Find the number in O(n) time & constant space.
 */


/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] array = {2, 3, 10, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2};
		System.out.println("The number occuring odd number of times is " + oddManOut(array));
	}

	private static int oddManOut(int[] array) {
		int a = 0;
		for(int i=0; i< array.length; i++){
			a = a^array[i];
		}
		return a;
	}

}
