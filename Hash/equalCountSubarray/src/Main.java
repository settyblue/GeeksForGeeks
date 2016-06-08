import java.util.HashMap;
/**
 * http://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/
 * Largest subarray with equal number of 0s and 1s.
 * Given an array containing only 0s and 1s, find the 
 * largest subarray which contain equal no of 0s and 1s. 
 * Expected time complexity is O(n).
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int array[] = {1, 1, 1, 1, 1, 0, 0};
		
		if(checkEqualCountSubarray(array)){
			System.out.println("such a sub array exists.");
		}else{
			System.out.println("such a sub array doesnt exist.");
		}
	}

	private static boolean checkEqualCountSubarray(int[] array) {
		int sum=0;
		int maxSubarrayLength=0;
		int maxIndex=-1;
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		map.put(0, -1);
		for(int i=0; i<array.length; i++){
			if(array[i] == 0){
				sum = sum-1;
			}else{
				sum = sum+1;
			}
			if(map.containsKey(sum)){
				if(maxSubarrayLength < i-map.get(sum)){
					maxSubarrayLength = i-map.get(sum);
					maxIndex = map.get(sum);
				}
			}else{
				map.put(sum,i);
			}
		}
		System.out.println("subarray length = "+maxSubarrayLength+", index = "+(maxIndex+1));
		if(maxSubarrayLength != 0){
			return true;
		}else{
			return true;
		}
	}

}
