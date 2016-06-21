import java.util.Stack;
/**
 * Sort the stack using another stack.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(30);
		stack.push(-3);
		stack.push(10);
		stack.push(5);
		stack.push(6);
		System.out.println(stack.toString());
		sort(stack);
		System.out.println(stack.toString());

	}
	
	public static void sort(Stack<Integer> stack){
		Stack<Integer> stack2 = new Stack<Integer>();
		int length = stack.size();
		int min=0,max,temp;
		for(int j=0;j<length-1;j++){
			temp = stack.pop();
			for(int i=j+1; i<length; i++){
				min = Math.min(temp, stack.peek());
				max = Math.max(temp, stack.peek());
				stack2.push(max);
				stack.pop();
				temp = min;
			}
			stack.push(min);
			while(!stack2.isEmpty()){
				stack.push(stack2.pop());
			}
		}
	}
}
