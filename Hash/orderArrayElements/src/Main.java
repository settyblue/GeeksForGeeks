import java.util.LinkedHashMap;
/**
 * http://www.geeksforgeeks.org/group-multiple-occurrence-of-array-elements-ordered-by-first-occurrence/
 * Group multiple occurrence of array elements ordered by first occurrence.
 * Given an unsorted array with repetitions, the task is to group multiple occurrence of individual elements.
 * The grouping should happen in a way that the order of first occurrences of all elements is maintained.
 * 
 * Input: arr[] = {4, 6, 9, 2, 3, 4, 9, 6, 10, 4}
 * Output:        {4, 4, 4, 6, 6, 9, 9, 2, 3, 10}
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] array = {4, 6, 9, 2, 3, 4, 9, 6, 10, 4};
		printOrderedArray(array);
	}

	private static void printOrderedArray(int[] array) {
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		
		for(int i=0; i<array.length; i++){
			if(map.containsKey(array[i])){
				map.put(array[i], map.get(array[i])+1);
			}else{
				map.put(array[i], 1);
			}
		}
		
		for(Integer key:map.keySet()){
			for(int i=0; i<map.get(key); i++){
				System.out.print(key+" ");
			}
		}
	}

}
