/**
 * http://www.geeksforgeeks.org/searching-for-patterns-set-3-rabin-karp-algorithm/
 * 
 * Given a text txt[0..n-1] and a pattern pat[0..m-1], 
 * write a function search(char pat[], char txt[]) that prints all occurrences 
 * of pat[] in txt[]. You may assume that n > m.
 */

/**
 * @author rakshith
 *
 */
public class Main {
	
	//private static int prime = 137;
	public static void main(String[] args) {
		String input = "AABAACAADAABAAABAA";
		String pattern = "AABA";
		//patternSearchRabinKarpSimple(input,pattern);
		patternSearchRabinKarp(input,pattern);

	}
	
	public static void patternSearchRabinKarpSimple(String input, String pattern){
		int patternHashCode = pattern.hashCode();
		for(int i=0; i<input.length()-pattern.length(); i++){
			if(input.substring(i, i+pattern.length()).hashCode() == patternHashCode){
				System.out.println("pattern found at :"+i);
			}
		}
	}
	
	public static void patternSearchRabinKarp(String input, String pattern){
		int patternHashCode = customHashCode(pattern);
		for(int i=0; i<input.length()-pattern.length(); i++){
			if(customHashCode(input.substring(i, i+pattern.length())) == patternHashCode){
				if(input.substring(i, i+pattern.length()).equals(pattern))
					System.out.println("pattern found at :"+i);
			}
		}
	}
	
	public static int customHashCode(String s){
		int hashCode = 0;
		
		for(int i=0; i<s.length(); i++){
			hashCode += s.charAt(i);
			//hashCode = hashCode%prime;
		}
		return hashCode;
	}
}
