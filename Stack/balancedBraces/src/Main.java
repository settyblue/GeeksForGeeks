import java.util.Stack;
/**
 * http://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
 * 
 * Check for balanced parentheses in an expression
 * Given an expression string exp, write a program to examine 
 * whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” 
 * are correct in exp. 
 * For example, the program should print true for exp = “[()]{}{[()()]()}” 
 * and false for exp = “[(])”
 * 
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		//String s = "[()]{}{[()()]()}" ;
		//String s = "({)}" ;
		//String s = "()}" ;
		String s = "{()";
		if(isBalanced(s)){
			System.out.println("braces are balanced.");
		}else{
			System.out.println("braces are not balanced.");
		}
	}

	private static boolean isBalanced(String s) {
		Stack<Character> stack = new Stack<Character>();
		char c = ' ';
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
				stack.push(s.charAt(i));
				continue;
			}else{
				if(!stack.isEmpty()){
					c = stack.pop();
				}else{
					return false;
				}
				if((c =='(' && s.charAt(i)==')') || (c=='[' && s.charAt(i)==']')
						|| (c=='{' && s.charAt(i)=='}') ){
					continue;
				}else{
					return false;
				}
			}
		}
		if(stack.isEmpty()){
			return true;
		}else{
			return false;
		}
	}

}
