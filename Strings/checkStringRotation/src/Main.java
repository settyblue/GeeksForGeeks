/**
 * http://www.geeksforgeeks.org/a-program-to-check-if-strings-are-rotations-of-each-other-or-not/
 * check if string is a rotation of b.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		String a = "ABCD";
		String b = "CDAB";
		
		if(isRotated(a,b)){
			System.out.println("Given string are rotated.");
		}else{
			System.out.println("Given strings are not rotated.");
		}

	}

	private static boolean isRotated(String a, String b) {
		String c = a+a;
		if(c.indexOf(b) != -1)
			return true;
		return false;
	}

}
