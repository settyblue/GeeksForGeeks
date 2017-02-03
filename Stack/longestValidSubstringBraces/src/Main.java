import java.util.Stack;
/**
 * http://www.geeksforgeeks.org/length-of-the-longest-valid-substring/
 * 
 * Length of the longest valid substring
 * Given a string consisting of opening and closing parenthesis, find length of the longest valid parenthesis substring.
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
		
		String[] sa = {""};
		String s = "()";
		//String s = "((()";//2
		//String s = ")()())";//4
		//String s = "()(()))))";//6
		//String s = "())(())";//4
		//String s = "()(()"; //2
		//String s = "()()(()"; //4
		//String s = "()((()()";
		//String s = "())((()()";
		for(String str: sa){
			System.out.println(str);
			printLengthLongestValidSubstring(str);
			//printLengthLongestValidSubstring2(s);
			printLengthLongestValidSubstring4(str);
			System.out.println();
		}
	}
	
	public static void printLengthLongestValidSubstring(String s){
		Stack<Integer> stack = new Stack<Integer>();
		int maxLength = 0;
		stack.push(-1);
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == '('){
				stack.push(i);
			}else{
				stack.pop();
				
				if(!stack.isEmpty()){
					maxLength = Math.max(maxLength, i-stack.peek());
				}else{
					stack.push(i);
				}
			}
		}

		System.out.println("max valid substring length = "+maxLength);
	}
	
	//TODO: Doesn't work.
	public static void printLengthLongestValidSubstring2(String s){
		int maxLength = 0, curLength = 0;
		int count = 0, interimLength = 0;
		boolean reachedZero = true;
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == '('){
				count++;
			}else{
				if(count > 0){
					count--;
					interimLength += 2;
					if(count==0){
						reachedZero = false;
					}
				}
				if(count==0 && reachedZero==false){
					reachedZero = true;
					curLength = curLength+interimLength;
					maxLength = Math.max(maxLength, curLength);
					interimLength = 0;
				}else if(count==0 && reachedZero==true){
					curLength = 0;
				}
			}
		}
		if(curLength > maxLength) maxLength = curLength;
		if(interimLength > maxLength) maxLength = interimLength;
		System.out.println("max valid substring length = "+maxLength);
	}
	//Doesn't work
	public static void printLengthLongestValidSubstring3(String s){
		int maxLength = 0, curLength = 0;
		int count = 0, interimLength = 0;
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == '('){
				if(count>=0){
					count++;
				}else{
					count = 1;
				}
			}else{
				count--;
				if(count > 0){
					interimLength += 2;
				}
				else if(count==0){
					interimLength += 2;
					curLength = curLength+interimLength;
					maxLength = Math.max(maxLength, curLength);
					interimLength = 0;
				}else if(count<0){
					curLength = 0;
					interimLength = 0;
				}
			}
		}
		if(interimLength > maxLength) maxLength = interimLength;
		System.out.println("max valid substring length = "+maxLength);
	}
	
	//Doesn't work
	public static void printLengthLongestValidSubstring4(String s){
		int maxLength = 0, curLength = 0;
		int count = 0, maxLengthRunning = 0;
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == '('){
				if(count>=0){
					count++;
				}else{
					count = 1;
				}
			}else{
				count--;
				if(count > 0){
					curLength += 2;
				}else if(count==0){
					curLength += 2;
					maxLengthRunning += curLength;
					curLength = 0;
				}else{
					maxLength = Math.max(maxLength,maxLengthRunning);
					maxLengthRunning = 0;
				}
			}
		}
		if(curLength > maxLengthRunning) maxLengthRunning = curLength;
		if(maxLengthRunning > maxLength) maxLength = maxLengthRunning;
		System.out.println("max valid substring length = "+maxLength);
	}
}
