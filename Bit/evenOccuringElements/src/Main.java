/**
 * Find even occurring elements in an array of limited range
 * Given an array that contains odd number of occurrences for 
 * all numbers except for a few elements which are present 
 * even number of times. Find the elements which have even 
 * occurrences in the array in O(n) time complexity and O(1) 
 * extra space.
 * 
 * Assume array contain elements in the range 0 to 63.
 * 
 * Input: [9, 12, 23, 10, 12, 12, 15, 23, 14, 12, 15]
 * Output: 12, 23 and 15
 * 
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] array = { 9, 12, 23, 10, 12, 12, 15, 23, 
                14, 12, 15 };//12 23 15
		printEvenOccuringElements(array);
	}
	
	public static void printEvenOccuringElements(int[] array){
		long x = 0;
		for(int i=0; i<array.length; i++){
			long temp = 1<<array[i];
			x = x^temp;
		}
		for(int i=0; i<array.length; i++){
			long temp = 1<<array[i];
			if((temp&x) == 0){
				System.out.print(array[i]+" ");
				x = x|temp;
			}
		}
	}
}
