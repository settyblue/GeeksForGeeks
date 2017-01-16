/**
 * http://www.geeksforgeeks.org/check-whether-a-given-string-is-an-interleaving-of-two-other-given-strings-set-2/
 * 
 * Given three strings A, B and C. Write a function that checks whether C is an interleaving of A and B. 
 * C is said to be interleaving A and B, if it contains all characters of A and B and order of all characters 
 * in individual strings is preserved.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		testInterleaved("XXY", "XXZ", "XXZXXXY");
		testInterleaved("XY" ,"WZ" ,"WZXY");
		testInterleaved("XY", "X", "XXY");
		testInterleaved("YX", "X", "XXY");
		testInterleaved("XXY", "XXZ", "XXXXZY");
		
	}

	private static void testInterleaved(String A, String B, String C) {
		if(isInterleaved(A,B,C)){
			System.out.println(C+" is interleaved of "+A+" "+B);
		}else{
			System.out.println(C+" is not interleaved of "+A+" "+B);
		}
	}

	private static boolean isInterleaved(String a, String b, String c) {
		if(a.length()+b.length() != c.length()){
			return false;
		}
		
		if(a.length()==0){
			if(b.equals(c)){
				return true;
			}else{
				return false;
			}
		}
		
		if(b.length()==0){
			if(a.equals(c)){
				return true;
			}else{
				return false;
			}
		}
		
		if(a.charAt(0) == c.charAt(0)){
			return isInterleaved(a.substring(1),b,c.substring(1));
		}
		if(b.charAt(0) == c.charAt(0)){
			return isInterleaved(a,b.substring(1),c.substring(1));
		}
		return false;
	}

}
