import java.util.ArrayList;

/**
 * http://www.geeksforgeeks.org/union-and-intersection-of-two-sorted-arrays-2/
 * 
 * For example, if the input arrays are: 
 * arr1[] = {1, 3, 4, 5, 7}
 * arr2[] = {2, 3, 5, 6}
 * Then your program should print Union as {1, 2, 3, 4, 5, 6, 7} and Intersection as {3, 5}. 
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] A = {1, 3, 4, 5, 7};
		int[] B = {2, 3, 5, 6};
		
		printUnionIntersection(A,B);

	}

	private static void printUnionIntersection(int[] a, int[] b) {
		int m = a.length;
		int n = b.length;
		int i = 0,j = 0;
		
		ArrayList<Integer> union = new ArrayList<>();
		ArrayList<Integer> intersection = new ArrayList<>();
		while(i < m && j < n){
			if(a[i] == b[j]){
				union.add(a[i]);
				intersection.add(a[i]);
				i++;j++;
				continue;
			}else if(a[i] < b[j]){
				union.add(a[i]);
				i++;
				continue;
			}else{
				union.add(b[j]);
				j++;
				continue;
			}
		}
		
		if(i<m){
			for(;i<m;i++){
				union.add(a[i]);
			}
		}
		
		if(j<n){
			for(;j<n;j++){
				union.add(b[j]);
			}
		}
		
		System.out.println(union.toString());
		System.out.println(intersection.toString());
	}

}
