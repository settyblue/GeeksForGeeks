/**
 * http://quiz.geeksforgeeks.org/binary-search/
 * 
 * Given a sorted array arr[] of n elements, write a 
 * function to search a given element x in arr[].
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		//int[] array = {2, 3, 4, 5, 6};
		int[] array = {2, 3, 4, 5, 6, 7};
		int n = 6;
		System.out.println("element is found at "+binarySearch(array,n));

	}
	
	public static int binarySearch(int[] array, int n){
		//return binarySearchRecursive(array,0,array.length,n);
		return binarySearchIterative(array,n);
	}
	
	public static int binarySearchRecursive(int[] array, int start, int end, int n){
		//System.out.println("start : "+start+ " ,end : "+end);
		if(start==end-1){
			if(array[start] == n){
				return start;
			}else{
				return -1;
			}
		}
		
		int mid = (start+end)/2;
		if(array[mid] == n){
			return mid;
		}
		if(n < array[mid]){
			return binarySearchRecursive(array, start, mid, n);
		}
		
		return binarySearchRecursive(array, mid, end, n);
		
	}
	
	public static int binarySearchIterative(int[] array, int n){
		int start=0,end=array.length-1;
		while(start <= end){
			int mid = (start+end)/2;
			if(array[mid]==n)
				return mid;
			if(array[mid] < n){
				start = mid+1;
			}else{
				end = mid-1;
			}
		}
		return -1;
	}
}
