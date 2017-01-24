/**
 * http://www.geeksforgeeks.org/remove-character-string-make-palindrome/
 * 
 * Given a string, we need to check whether 
 * it is possible to make this string a palindrome after removing exactly 
 * one character from this.
 * 
 * Input  : str = “abcba”
 * Output : Yes
 * 
 * Input : str = “abecbea”
 * Output : No
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		//String s = "abcba";
		//String s = "abba";
		//String s = "abda";
		//String s = "adba";
		//String s = "a";//Yes. because empty string is assumed to be palindrome.
		//String s = "";//No. because no characters to delete.
		String s = "abcd";
		if(possible(s)){
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}

	}

	private static boolean possible(String s) {
		int i=0,j=s.length()-1;
		while(i<j){
			if(s.charAt(i) == s.charAt(j)){
				i++;j--;
				continue;
			}else{
				boolean a = checkPalindrome(s.substring(i,j));
				boolean b = checkPalindrome(s.substring(i+1,j+1));
				if(a||b){
					return true;
				}else{
					return false;
				}
			}
		}
		if(i==j)return true;
		return false;
	}

	private static boolean checkPalindrome(String str) {
		if(str.length()==1){
			return true;
		}
		int i=0, j=str.length()-1;
		while(i<j){
			if(str.charAt(i) == str.charAt(j)){
				continue;
			}else{
				return false;
			}
		}
		return true;
	}

}
