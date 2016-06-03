/**
 * Write a function to find if a given integer x appears more 
 * than n/2 times in a sorted array of n integers.
 * http://www.geeksforgeeks.org/check-for-majority-element-in-a-sorted-array/
 */
package checkMajority;

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World.");
		int[] array = {1, 2, 3, 4, 4, 4, 4};
		int x = 3;
		int n = 6;
		if(isMajorityBinary(array,n,x)){
			System.out.println(x+" is majority in given array.");
		}else{
			System.out.println(x+" is not majority in given array.");
		}
	}

	//Using linear search.
	private static boolean isMajority(int[] array, int n, int x) {
		int middleIndex = (n%2==0) ?(n/2) : (n/2+1);
		if(array[middleIndex] != x){
			return false;
		}
		for (int i=0; i<middleIndex+1; i++){
			if(array[i]==x && array[i+n/2]==x){
				return true;
			}
		}
		return false;
	}
	
	//Using binary search.
	private static boolean isMajorityBinary(int[] array, int n, int x) {
		// First index of occurrence of x in array.
		int middleIndex = (n%2==0) ?(n/2) : (n/2+1);
		if(array[middleIndex] != x){
			return false;
		}
		int index = binarySearch(array,0,middleIndex,x);
		if(index != -1 && array[index + n/2] == x){
			return true;
		}
		return false;
	}

	private static int binarySearch(int[] array, int low, int high, int x) {
		if(high >= low){
			int middleIndex = (low + high)/2;
			
			if((array[middleIndex] == x || middleIndex == 0) && array[middleIndex-1] < x){
				return middleIndex;
			}
			else if(x > array[middleIndex]){
				return binarySearch(array,middleIndex+1,high,x);
			}else {
				return binarySearch(array,low,middleIndex-1,x);
			}
		}
		return -1;
	}
}
