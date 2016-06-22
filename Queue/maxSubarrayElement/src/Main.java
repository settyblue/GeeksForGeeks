import java.util.ArrayDeque;
/**
 * http://www.geeksforgeeks.org/maximum-of-all-subarrays-of-size-k/
 * 
 * Given an array and an integer k, find the maximum for each and 
 * every contiguous subarray of size k.
 * 
 * Input:
 * arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}
 * k = 3
 * Output :
 * 3 3 4 5 5 5 6
 * 
 * Input :
 * arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}
 * k = 4
 * Output :
 * 10 10 10 15 15 90 90
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int k = 4;
		int[] array = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		printMaxSubarrayElement(array,k);

	}
	
	public static void printMaxSubarrayElement(int[] array, int k){
		ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
		
		int i=0;
		for(;i<k;i++){
			
			while(!deque.isEmpty() && array[i] >= array[deque.peekLast()]){
				deque.removeLast();
			}
			deque.addLast(i);
		}
		
		for(;i<array.length;i++){
			System.out.print(array[deque.peekFirst()]+" ");
			while( !deque.isEmpty() && deque.peekFirst() <= i-k){
				deque.removeFirst();
			}
			while(!deque.isEmpty() && array[i] >= array[deque.peekLast()]){
				deque.removeLast();
			}
			deque.addLast(i);
		}
		System.out.print(array[deque.peekFirst()]+" ");
		
	}
}
