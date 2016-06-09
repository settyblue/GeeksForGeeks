import java.util.HashMap;
/**
 * http://www.geeksforgeeks.org/find-four-elements-a-b-c-and-d-in-an-array-such-that-ab-cd/
 * 
 * Find four elements a, b, c and d in an array such that a+b = c+d
 * Given an array of distinct integers, find if there are two pairs (a, b) and (c, d) 
 * such that a+b = c+d, and a, b, c and d are distinct elements. 
 * If there are multiple answers, then print any of them.
 * 
 * Example:
 * Input:   {3, 4, 7, 1, 2, 9, 8}
 * Output:  (3, 8) and (4, 7)
 * Explanation: 3+8 = 4+7
 */

/**
 * @author rakshith
 *
 */
public class Main {
	
	public static class Pairs{
		int a,b;
		
		Pairs(int i, int j){
			this.a=i;
			this.b=j;
		}
		
		public String toString(){
			return "("+this.a+" ,"+this.b+")";
		}
	}
	
	public static void main(String[] args) {
		int[] array =  {3, 4, 7, 1, 2, 9};
		if(checkEqualSumPairs(array)){
			System.out.println("Pairs exist.");
		}else{
			System.out.println("No pairs exist.");
		}

	}

	private static boolean checkEqualSumPairs(int[] array) {
		HashMap<Integer, Pairs> map = new HashMap<Integer, Pairs>();
		
		for(int i=0; i<array.length; i++){
			for(int j=i+1; j<array.length; j++){
				if(map.containsKey(array[i]+array[j])){
					System.out.println("The pairs are : ("+array[i]+", "+array[j]+") and "
										+ map.get(array[i]+array[j]));
					return true;
				}else{
					map.put(array[i]+array[j], new Pairs(array[i], array[j]));
				}
			}
		}
		return false;
	}

}