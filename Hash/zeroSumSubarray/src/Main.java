import java.util.HashMap;
/**
 * http://www.geeksforgeeks.org/find-if-there-is-a-subarray-with-0-sum/
 * Find if there is a subarray with 0 sum
 * Given an array of positive and negative numbers, 
 * find if there is a subarray (of size at-least one) with 0 sum.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		//int[] array = {4, 2, -3, 1, 6};
		int[] array = {4, 2, 0, 1, 6};
		//int[] array = {-3, 2, 3, 1, 6};
		
		if(checkZeroSumSubarray(array)){
			System.out.println("The is zero sum subarrary");
		}else{
			System.out.println("The is no zero sum subarrary");
		}
	}

	private static boolean checkZeroSumSubarray(int[] array) {
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		int sum=0;
		for(int i=0; i<array.length; i++){
			sum += array[i];
			if(map.containsKey(sum)){
				System.out.println("range of sub array : "+(map.get(sum)+1)+", "+i);
				return true;
			}else{
				map.put(sum, i);
			}
		}
		return false;
	}

}
