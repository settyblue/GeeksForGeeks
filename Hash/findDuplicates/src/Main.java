import java.util.HashSet;
/**
 * http://www.geeksforgeeks.org/check-given-array-contains-duplicate-elements-within-k-distance/
 * Check if a given array contains duplicate elements within k distance from each other.
 * Given an unsorted array that may contain duplicates. Also given a number k which is smaller 
 * than size of array. Write a function that returns true if array contains duplicates within k distance.
 * 
 * Input: k = 3, arr[] = {1, 2, 3, 4, 1, 2, 3, 4}
 * Output: false
 * All duplicates are more than k distance away.
 * 
 * Input: k = 3, arr[] = {1, 2, 3, 1, 4, 5}
 * Output: true
 * 1 is repeated at distance 3.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] array = {1, 2, 4, 1, 4, 5};
		int k = 2;
		
		if(hasDuplicates(array,k)){
			System.out.println("The array has duplicates within window.");
		}else{
			System.out.println("The array has no duplicates within window.");
		}
	}

	private static boolean hasDuplicates(int[] array, int k) {
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0; i<array.length; i++){
			if(set.contains(array[i])){
				return true;
			}
			set.add(array[i]);
			if(i>=k){
				set.remove(array[i-k]);
			}
		}
		return false;
	}

}
