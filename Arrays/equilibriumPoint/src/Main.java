/**
 * http://www.geeksforgeeks.org/equilibrium-index-of-an-array/
 * 
 * Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements 
 * at higher indexes. For example, in an arrya A:
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] array = {-7, 1, 5, 2, -4, 2, 1};
		System.out.println(equilibriumPoint(array));
	}

	private static int equilibriumPoint(int[] array) {
		int totalSum = 0;
		int n = array.length;
		
		for(int i=0;i<n;i++){
			totalSum += array[i];
		}
		
		int rightSum = 0;
		for(int j=n-1;j>=0;j--){
			totalSum -= array[j];
			if(totalSum == rightSum){
				return j;
			}
			rightSum += array[j];
		}
		return -1;
	}

}
