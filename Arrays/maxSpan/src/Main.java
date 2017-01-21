import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
 * 
 * Given an array arr[], find the maximum j – i such that arr[j] > arr[i].
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] array = {34, 8, 10, 3, 2, 80, 30, 33, 1};//4
		System.out.println(maxSpan(array));

	}

	private static int maxSpan(int[] array) {
		int n = array.length;
		int[] leftMin = new int[n];
		int[] rightMax = new int[n];
		
		leftMin[0] = array[0];
		for(int i=1; i<n; i++){
			leftMin[i] = Math.min(array[i],leftMin[i-1]);
		}
		rightMax[n-1] = array[n-1];
		for(int i=n-2; i>=0; i--){
			rightMax[i] = Math.max(array[i], rightMax[i+1]);
		}
		//System.out.println(Arrays.toString(leftMin));
		//System.out.println(Arrays.toString(rightMax));
		int i=0,j=0;
		int maxLen = -1;
		while(i<n && j<n){
			if(leftMin[i]<rightMax[j]){
				maxLen = Math.max(j-i, maxLen);
				j++;
			}else{
				i++;
			}
		}
		
		return maxLen;
	}

}
