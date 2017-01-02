import java.util.Stack;

/**
 * http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 * 
 * Find the largest rectangular area possible in a given histogram 
 * where the largest rectangle can be made of a number of contiguous bars. 
 * For simplicity, assume that all bars have same width and the width is 1 unit.
 * 
 * For example, consider the following histogram with 7 bars of heights {6, 2, 5, 4, 5, 2, 6}. 
 * The largest possible rectangle possible is 12.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] array = {6, 2, 5, 4, 5, 2, 6};
		System.out.println(maxArea(array));
	}

	private static int maxArea(int[] array) {
		int maxArea = 0;
		int n = array.length;
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0;i<n;i++){
			while(!stack.empty() && array[stack.peek()] >= array[i]){
				stack.pop();
			}
			if(!stack.empty()){
				maxArea = Math.max(array[i]*(i-stack.peek()), maxArea);
			}else{
				maxArea = Math.max(array[i]*(i+1), maxArea);
			}
			stack.push(i);
		}
		return maxArea;
	}

}
