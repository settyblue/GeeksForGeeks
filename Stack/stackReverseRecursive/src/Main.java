import java.util.Stack;
/**
 * http://www.geeksforgeeks.org/reverse-a-stack-using-recursion/
 * 
 * Reverse a stack using recursion
 * 
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println(stack.toString());
		reverseStack(stack);
		System.out.println(stack.toString());

	}
	
	public static void reverseStack(Stack<Integer> stack){
		if(!stack.isEmpty()){
			int temp = stack.pop();
			reverseStack(stack);
			insertAtBottom(stack,temp);
		}else{
			return;
		}
	}
	
	public static void insertAtBottom(Stack<Integer> stack, int temp){
		if(stack.isEmpty()){
			stack.push(temp);
		}else{
			int temp2 = stack.pop();
			insertAtBottom(stack,temp);
			stack.push(temp2);
		}
	}
}
