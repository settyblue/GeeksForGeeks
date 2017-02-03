/**
 * http://www.geeksforgeeks.org/recursively-remove-adjacent-duplicates-given-string/
 * 
 * Given a string, recursively remove adjacent duplicate characters from string. 
 * The output string should not have any adjacent duplicates.
 * 
 * Input: caaabbbaacdddd
 * Output: Empty String
 * 
 * Input: acaaabbbacdddd
 * Output: acac
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		//String s = "acaaabbbacdddd";
		//String s = "axzzxy";
		//String s = "caaabbbaacdddd";
		//String s = "";
		//String s = "abcc";
		//String s = "acbbcc";
		String s = "acbbccd";
		System.out.println(s+" -> "+removeDuplicates(s));
		System.out.println(s+" -> "+removeDuplicates2(s));

	}
	//TODO: both require more carefull implementation.
	//not passing for all cases.
	private static String removeDuplicates(String s) {
		//System.out.println(s);
		int i=1;
		int n = s.length();
		char[] sarr = s.toCharArray();
		int curP = -1;
		while(i<n){
			if(sarr[i] != sarr[i-1]){
				sarr[++curP] = sarr[i-1];
				i++;continue;
			}
			while(i<n && sarr[i]==sarr[i-1]){
				i++;
			}
			i++;
			//break;
			//System.out.println("yo: "+String.copyValueOf(sarr,0,curP+1));
		}
		if(i-1<n)
			sarr[++curP] = sarr[i-1];
		//System.out.println("yo: "+String.copyValueOf(sarr,0,curP+1));
		String answer = String.copyValueOf(sarr,0,curP+1);
		return curP+1==n?answer:removeDuplicates(answer);
	}
	
	public static String removeDuplicates2(String s){
		char[] lastRemoved = {'\0'};
		return removeDuplicateUtil(s, lastRemoved);
	}
	
	//TODO: not yet complete. O(n) implementation.
	private static String removeDuplicateUtil(String s, char[] lastRemoved) {
		if(s.length()==0 || s.length()==1)
			return s;
		
		if(s.charAt(0)==s.charAt(1)){
			lastRemoved[0] = s.charAt(0);
			while(s.length()>=2 && s.charAt(0)==s.charAt(1)){
				s = s.substring(1);
			}
			return removeDuplicateUtil(s.substring(1),lastRemoved);
		}
		
		String remainingString = removeDuplicateUtil(s.substring(1),lastRemoved);
		if(remainingString.length()>0 && remainingString.charAt(0) == s.charAt(0)){
			lastRemoved[0] = s.charAt(0);
			return remainingString.substring(1);
		}
		
		if(remainingString.length() == 0 && lastRemoved[0]==s.charAt(0)){
			return "";
		}
		
		
		return s.charAt(0)+remainingString;
	}
}
