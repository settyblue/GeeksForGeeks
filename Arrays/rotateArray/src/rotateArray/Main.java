/**
 * http://www.geeksforgeeks.org/array-rotation/
 * Write a function rotate(ar[], d, n) 
 * that rotates arr[] of size n by d elements.
 */
package rotateArray;

/**
 * @author rakshith
 *
 */

//Juggling Algorithm
public class Main {

	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
		//leftRotate(array,4,array.length);
		leftRotateReverse(array,3,array.length);
		printArray(array);
	}

	private static void printArray(int[] array) {
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
		
	}

	//Using Juggling Algorithm.
	private static void leftRotate(int[] array, int d, int n) {
		int temp,i,j,k;
		for(i=0; i<gcd(n,d); i++){
			temp = array[i];
			j = i;
			while(true){
				k = j+d;
				if(k >= n)k=k%n;
				if(k == i)break;
				array[j] = array[k];
				j = k;
			}
			array[j] = temp;
		}
		
	}

	private static int gcd(int n, int d) {
		if(d==0){
			return n;
		}
		else {
			return gcd(d,n%d);
		}
	}
	
	//Using Reverse Algorithm.
	private static void leftRotateReverse(int[] array, int i, int length) {
		reverse(array,0,i-1);
		reverse(array,i,length-1);
		reverse(array,0,length-1);
	}

	private static void reverse(int[] array, int i, int j) {
		int temp,start=i,end=j;
		while(start<end){
			temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}
	}
}
