import java.util.ArrayList;

/**
 * http://www.geeksforgeeks.org/find-missing-elements-of-a-range/
 * Find missing elements of a range.
 * Given an array arr[0..n-1] of distinct elements and a range [low, high], 
 * find all numbers that are in range, but not in array. 
 * The missing elements should be printed in sorted order.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] array = {1, 14, 11, 51, 52};
		int low = 50, high = 55;
		
		//ArrayList<Integer> result = new ArrayList<Integer>();
		System.out.println("The list of missing numbers in the range("+low+", "+high+") are "+findMissingNumbers(array, low, high).toString());
	}

	private static ArrayList<Integer> findMissingNumbers(int[] array, int low, int high) {
		ArrayList<Boolean> present = new ArrayList<Boolean>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i=0; i<=high-low; i++){
			present.add(false);
		}
		for(int i=0; i<array.length; i++){
			if(low<=array[i] && array[i]<=high){
				present.set(array[i]-low, true);
			}
		}
		for(int i=0; i<present.size(); i++){
			if(!present.get(i)){
				result.add(low+i);
			}
		}
		return result;
	}

}
