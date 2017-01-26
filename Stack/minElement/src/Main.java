import java.util.Stack;

/**
 * http://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
 * 
 * 
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		MyStack s = new MyStack();
		s.push(3);
	    s.push(5);
	    System.out.println(s);
	    System.out.println(" min = " +s.getMin());
	    s.push(2);
	    System.out.println(s);
	    s.push(1);
	    System.out.println(s);
	    System.out.println(" min = " +s.getMin());
	    s.pop();
	    System.out.println(s);
	    System.out.println(" min = " +s.getMin());
	    s.pop();
	    System.out.println(s);
	    s.peek();
	}
	
	
	public static class MyStack{
		int min;
		Stack<Integer> stack;
		
		MyStack(){
			this.min = Integer.MAX_VALUE;
			this.stack = new Stack<>();
		}
		
		public void push(int x){
			if(x >= this.min){
				this.stack.push(x);
			}else{
				if(!this.stack.empty()){
					this.stack.push(2*x-this.min);
					this.min = x;
				}else{
					this.stack.push(x);
					this.min = x;
				}
			}
		}
		
		public int pop(){
			if(this.stack.size() == 1){
				this.min = Integer.MAX_VALUE;
				return stack.pop();
			}else if(this.min < stack.peek()){
				return stack.pop();
			}else{
				int temp = this.min;
				this.min = 2*temp - stack.pop();
				return temp;
			}
		}
		
		public int getMin(){
			return this.min;
		}
		
		public int peek(){
			return this.stack.peek();
		}
		
		public String toString(){
			return this.stack.toString();
		}
	}
}
