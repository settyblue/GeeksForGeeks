import java.util.HashMap;
/**
 * http://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/
 * 
 * Count distinct elements in every window of size k.
 * Given an array of size n and an integer k, return the 
 * of count of distinct numbers in all windows of size k.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] array = {1, 2, 1, 3, 4, 2, 3};
		int k = 4;
		printNumberOfDistinctElements(array, k);

	}

	private static void printNumberOfDistinctElements(int[] array, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		if(array.length < k){
			System.out.println("window size is larger than array length");
			return;
		}
		for(int i=0; i<k; i++){
			if(map.containsKey(array[i])){
				map.put(array[i], map.get(array[i])+1);
			}else{
				map.put(array[i],1);
			}
		}
		System.out.println("number of distinct elements in current window : "+map.size());
		int evict=array[0];
		
		for(int i=k; i<array.length; i++){
			if(map.containsKey(array[i])){
				map.put(array[i], map.get(array[i])+1);
			}else{
				map.put(array[i],1);
			}
			if(map.get(evict)>1){
				map.put(evict, map.get(evict)-1);
			}else{
				map.remove(evict);
			}
			evict = array[i-k+1];
			System.out.println("number of distinct elements in current window : "+map.size());
		}
	}

}
