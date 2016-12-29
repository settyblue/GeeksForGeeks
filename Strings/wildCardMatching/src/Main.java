/**
 * http://www.geeksforgeeks.org/wildcard-character-matching/
 * 
 * Given two strings where first string may contain wild card characters and 
 * second string is a normal string. Write a function that returns true if the two strings match. 
 * The following are allowed wild card characters in first string.
 * 
 *  * --> Matches with 0 or more instances of any character or set of characters.
 *  ? --> Matches with any one character.
 *  
 *  For example, “g*ks” matches with “geeks” match. And string “ge?ks*” matches with “geeksforgeeks”.
 *  But “g*k” doesn’t match with “gee” as character ‘k’ is not present in second string.
 *  
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		
		System.out.print("g*ks"+",geeks"+" ");stringWildcardMatch("g*ks", "geeks");
		System.out.print("ge?ks*"+",geeksforgeeks"+" ");stringWildcardMatch("ge?ks*", "geeksforgeeks");
		System.out.print("g*k"+",gee"+" ");stringWildcardMatch("g*k", "gee");
		System.out.print("*pqrs"+",pqrst"+" ");stringWildcardMatch("*pqrs", "pqrst");
		System.out.print("*pqrs"+",pqrs"+" ");stringWildcardMatch("*pqrs", "pqrs");
		System.out.print("abc*bcd"+",abcdhghgbcd"+" ");stringWildcardMatch("abc*bcd", "abcdhghgbcd");
		System.out.print("abc*c?d"+",abcd"+" ");stringWildcardMatch("abc*c?d", "abcd");
		System.out.print("*c*d"+",abcd"+" ");stringWildcardMatch("*c*d", "abcd");
		System.out.print("*?c*d"+",abcd"+" ");stringWildcardMatch("*?c*d", "abcd");
		System.out.print("*?c*d"+",abc"+" ");stringWildcardMatch("*?c*d", "abc");
		
	}

	private static void stringWildcardMatch(String wildCardStr, String str) {
		if(wildcardMatch(wildCardStr, str)){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
	}

	private static boolean wildcardMatch(String wildCardStr, String str) {
		//System.out.println(wildCardStr+" "+str);
		if(wildCardStr.length()==0 && str.length()==0){
			return true;
		}
		
		if(wildCardStr.length()==0 || str.length()==0){
			if(wildCardStr.length()==0){
				return false;
			}
			if(str.length()==0 && wildCardStr.length()==1 && wildCardStr.charAt(0)=='*'){
				return true;
			}else if(str.length()==0 && wildCardStr.length()>1){
				return false;
			}
		}
		
		if(wildCardStr.charAt(0)=='*' && wildCardStr.length()>1 && str.length()==0){
			return false;
		}
		
		if(wildCardStr.charAt(0)=='?' && str.length()==0){
			return false;
		}
		
		if(wildCardStr.charAt(0)=='?' || wildCardStr.charAt(0) == str.charAt(0)){
			return wildcardMatch(wildCardStr.substring(1),str.substring(1));
		}
		
		if(wildCardStr.charAt(0)=='*'){
			return wildcardMatch(wildCardStr.substring(1),str) || wildcardMatch(wildCardStr,str.substring(1));
		}
		
		return false;
	}

}
