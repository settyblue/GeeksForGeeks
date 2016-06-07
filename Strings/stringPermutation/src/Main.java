/**
 * http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 * Print all permutations of a given string.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		String s = "ABC";
		printStringPermutations(s.toCharArray());
	}

	private static void printStringPermutations(char[] cs) {
		permutateString(cs,0,cs.length-1);
	}
	
	//Backtracking method
	private static void permutateString(char[] cs, int i, int j) {
		if(i==j){
			System.out.println(new String(cs));
		}else{
			for(int k=i; k<=j; k++){
				swap(cs,i,k);
				permutateString(cs,i+1,j);
				swap(cs,i,k);
			}
		}
	}

	private static void swap(char[] cs, int i, int k) {
		char temp = cs[i];
		cs[i] = cs[k];
		cs[k] = temp;
	}

}
