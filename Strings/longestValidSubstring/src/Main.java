import java.util.Stack;

/**
 * http://www.geeksforgeeks.org/length-of-the-longest-valid-substring/
 * 
 * Given a string consisting of opening and closing parenthesis, 
 * find length of the longest valid parenthesis substring.
 * 
 * Input : ((()
 * Output : 2
 * Explanation : ()
 * 
 * Input: )()())
 * Output : 4
 * Explanation: ()() 
 * 
 * Input:  ()(()))))
 * Output: 6
 * Explanation:  ()(()))
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		//String s = "()(()))))";
		String s = ")()(()))))";
		System.out.println(maxValidSubstring(s));
	}

	private static int maxValidSubstring(String s) {
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		int maxValue = 0;
		for(int i=0;i<s.length();i++){
			System.out.println(stack.toString());
			if(s.charAt(i)=='('){
				stack.push(i);
			}else{
				stack.pop();
				if(stack.isEmpty()){
					stack.push(i);
				}else{
					maxValue = Math.max(maxValue, i-stack.peek());
				}
			}
		}
		return maxValue;
	}

}
