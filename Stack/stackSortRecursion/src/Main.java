import java.util.Stack;
/**
 * http://www.geeksforgeeks.org/sort-a-stack-using-recursion/
 * 
 * Sort a stack using recursion
 * Given a stack, sort it using recursion. 
 * 
 * Similar to stack reverse recursive. -> http://www.geeksforgeeks.org/reverse-a-stack-using-recursion/
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(30);
		stack.push(-5);
		stack.push(18);
		stack.push(14);
		stack.push(-3);
		System.out.println(stack.toString());
		sortRecursive(stack);
		System.out.println(stack.toString());
	}
	
	public static void sortRecursive(Stack<Integer> stack){
		if(!stack.isEmpty()){
			int temp = stack.pop();
			sortRecursive(stack);
			insertMinBottom(stack,temp);
		}
	}
	
	public static void insertMinBottom(Stack<Integer> stack, int temp){
		if(stack.isEmpty()){
			stack.push(temp);
		}else{
			if(temp > stack.peek()){
				stack.push(temp);
			}else{
				int temp2 = stack.pop();
				insertMinBottom(stack,temp);
				stack.push(temp2);
			}
		}
	}
}
