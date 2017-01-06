import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/find-number-of-triangles-possible/
 * 
 * Given an unsorted array of positive integers. 
 * Find the number of triangles that can be formed with 
 * three different array elements as three sides of triangles. 
 * For a triangle to be possible from 3 values, the sum of any two values (or sides) 
 * must be greater than the third value (or third side).
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] array = {10, 21, 22, 100, 101, 200, 300};
		System.out.println(numberOfTriangles(array));

	}

	private static int numberOfTriangles(int[] array) {
		int n = array.length;
		Arrays.sort(array);
		int count = 0;
		for(int i=0; i<n; i++){
			int k = i+2;
			for(int j=i+1;j<n;j++){
				while(k<n && array[k] < array[i]+array[j]){
					k++;
				}
				count += k-j-1;
			}
		}
		return count;
	}

}
