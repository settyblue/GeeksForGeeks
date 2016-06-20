import java.util.Stack;
/**
 * http://www.geeksforgeeks.org/next-greater-element/
 * 
 * Given an array, print the Next Greater Element (NGE) 
 * for every element. The Next greater Element for an element x 
 * is the first greater element on the right side of x in array. 
 * Elements for which no greater element exist, consider next greater element as -1.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] array = {11, 13, 75, 21, 18, 20, 19, 4, 3, 25, 27, 30, 35, 5};
		//printNextGreaterElement(array);//print out of order.
		printNextGreaterElement2(array);//print in order.
	}
	
	public static void printNextGreaterElement(int[] array){
		Stack<Integer> stack = new Stack<Integer> ();
		stack.push(array[0]);
		for(int i=1; i<array.length; i++){
			while(!stack.isEmpty() && stack.peek() < array[i]){
				System.out.println(stack.peek()+" "+array[i]);
				stack.pop();
			}
			stack.push(array[i]);
		}
		while(!stack.isEmpty()){
			System.out.println(stack.peek()+" -1");
			stack.pop();
		}
		
	}
	
	//prints in order.
	public static void printNextGreaterElement2(int[] array){
		int[] nge = new int[array.length];
		Stack<Integer> stack = new Stack<Integer> ();
		stack.push(0);
		for(int i=1; i<array.length; i++){
			while(!stack.isEmpty() && array[stack.peek()] < array[i]){
				nge[stack.pop()] = array[i];
			}
			stack.push(i);
		}
		while(!stack.isEmpty()){
			nge[stack.pop()] = -1;
		}
		
		for(int i=0; i<nge.length; i++){
			System.out.println(array[i]+ " "+nge[i]);
		}
	}

}
