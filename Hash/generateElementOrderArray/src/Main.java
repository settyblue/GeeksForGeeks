import java.util.TreeMap;
/**
 * http://www.geeksforgeeks.org/convert-array-reduced-form/
 * 
 * Convert an array to reduced form
 * Given an array with n distinct elements, convert the given array 
 * to a form where all elements are in range from 0 to n-1. 
 * The order of elements is same, i.e., 0 is placed in place of smallest element, 
 * 1 is placed for second smallest element, … n-1 is placed for largest element.
 * Input:  arr[] = {10, 40, 20}
 * Output: arr[] = {0, 2, 1}
 * 
 * Input:  arr[] = {5, 10, 40, 30, 20}
 * Output: arr[] = {0, 1, 4, 3, 2}
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] array =  {5, 10, 40, 30, 20};
		System.out.println("Order array :"+generateOrderArray(array));

	}

	private static String generateOrderArray(int[] array) {
		TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
		for(int i=0; i<array.length; i++){
			map.put(array[i], 0);
		}
		int count=0;
		for(Integer key: map.keySet()){
			map.put(key, count);
			count++;
		}
		String result="";
		for(int i=0; i<array.length; i++){
			result = result+" "+map.get(array[i]);
		}
		
		return result;
	}

}
