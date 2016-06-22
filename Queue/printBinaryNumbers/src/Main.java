import java.util.LinkedList;
/**
 * http://www.geeksforgeeks.org/interesting-method-generate-binary-numbers-1-n/
 * 
 * Given a number n, write a function that generates and prints all binary numbers 
 * with decimal values from 1 to n.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int n = 10;
		printBinaryNumbers(n);

	}
	
	public static void printBinaryNumbers(int n){
		LinkedList<String> queue = new LinkedList<String>();
		queue.add("1");
		
		for(int i=0; i<n; i++){
			String s = queue.remove();
			System.out.println(s);
			
			queue.add(s+"0");
			queue.add(s+"1");
		}
	}
}
