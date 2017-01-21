/**
 * http://www.geeksforgeeks.org/print-possible-strings-can-made-placing-spaces/
 * 
 * Given a string you need to print all possible strings that can be made by placing spaces (zero or one) in between 
 * 
 * Input:  str[] = "ABC"
 * Output: ABC,
 *         AB C,
 *         A BC,
 *         A B C,
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		String s = "ABCD";
		printSpacedStrings(s);
	}

	private static void printSpacedStrings(String s) {
		if(s.length()==0){
			return;
		}
		if(s.length()==1){
			System.out.println(s);
			return;
		}
		
		int n = s.length();
		char[] buffer = new char[2*n-1];
		buffer[0] = s.charAt(0);
		printAllSpacedStrings(s,buffer,1,1);
	}

	private static void printAllSpacedStrings(String s, char[] buffer, int i, int j) {
		int n = s.length();
		if(i==n){
			System.out.println(String.copyValueOf(buffer,0,j));
			return;
		}
		
		buffer[j] = s.charAt(i);
		printAllSpacedStrings(s,buffer,i+1,j+1);
		
		buffer[j] = ' ';
		buffer[j+1] = s.charAt(i);
		printAllSpacedStrings(s,buffer,i+1,j+2);

	}

}
