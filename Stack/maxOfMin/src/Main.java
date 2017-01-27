import java.util.Arrays;
import java.util.Stack;

/**
 * http://www.geeksforgeeks.org/find-the-maximum-of-minimums-for-every-window-size-in-a-given-array/
 * 
 * Find maximum of minimum for every window size in a given array
 * Given an integer array of size n, find the maximum of the minimum’s 
 * of every window size in the array. Note that window size varies from 
 * 1 to n.
 * 
 */


/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] array = {10, 20 ,30 , 50, 10, 70, 30};
		System.out.println(Arrays.toString(maxOfMin(array)));
	}

	private static int[] maxOfMin(int[] array) {
		int n = array.length;
		int[] prevSmall = new int[n];
		int[] nextSmall = new int[n];
		
		Stack<Integer> stack = new Stack<Integer>();

		for(int i=0; i<n; i++){
			prevSmall[i] = -1;
			nextSmall[i] = n;
		}
		
		for(int i=0;i<n;i++){
			
			while(!stack.empty() && array[stack.peek()] >= array[i]){
				stack.pop();
			}
			
			if(!stack.empty()){
				prevSmall[i] = stack.peek();
			}
			
			stack.push(i);
		}
		System.out.println(Arrays.toString(prevSmall));
		stack.removeAllElements();
		
		for(int i=n-1;i>=0;i--){
			
			while(!stack.empty() && array[stack.peek()] >= array[i]){
				stack.pop();
			}
			
			if(!stack.empty()){
				nextSmall[i] = stack.peek();
			}
			
			stack.push(i);
		}
		System.out.println(Arrays.toString(nextSmall));
		
		int[] maxOfMin = new int[n+1];
		
		for(int i=0;i<n;i++){
			int x = nextSmall[i] - prevSmall[i] - 1;
			maxOfMin[x] = Math.max(maxOfMin[x], array[i]);
		}
		
		System.out.println(Arrays.toString(maxOfMin));
		
		for(int i=n-1;i>=1;i--){
			maxOfMin[i] = Math.max(maxOfMin[i], maxOfMin[i+1]);
		}
		
		return maxOfMin;
	}

}
