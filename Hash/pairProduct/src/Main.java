import java.util.HashSet;
/**
 * http://www.geeksforgeeks.org/pair-with-given-product-set-1-find-if-any-pair-exists/
 * Given an array and a number x, find if there is a pair with product equal to x.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] array = {10, 20, 9, 400};
		int x = 400;

		if(checkProductPair(array,x)){
			System.out.println("Pair of numbers exist.");
		}else{
			System.out.println("Pair of numbers dont exist.");
		}
	}

	private static boolean checkProductPair(int[] array, int x) {
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0; i<array.length; i++){
			if(array[i]==0){
				if(x==0)
					return true;
			}else if(x%array[i]==0){
				if(set.contains(x/array[i])){
					return true;
				}else{
					set.add(array[i]);
				}
			}
		}
		return false;
	}

}
