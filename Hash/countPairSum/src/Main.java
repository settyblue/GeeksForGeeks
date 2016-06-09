import java.util.HashMap;
/**
 * http://www.geeksforgeeks.org/count-pairs-with-given-sum/
 * Count pairs with given sum
 * Given an array of integers, and a number ‘sum’, 
 * find the number of pairs of integers in the array whose sum is equal to ‘sum’.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] array = {10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1};
		int sum = 11;
		
		System.out.println("Number of pairs = "+numberOfPairs(array,sum));

	}

	private static int numberOfPairs(int[] array, int sum) {
		int count = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
		
		for(int i=0; i<array.length; i++){
			if(map.containsKey(sum - array[i])){
				count += map.get(sum - array[i]);
			}
			if(map.containsKey(array[i])){
				map.put(array[i], map.get(array[i])+1);
			}else{
				map.put(array[i], 1);
			}
		}
		return count;
	}

}
