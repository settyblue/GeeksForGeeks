/**
 * http://www.geeksforgeeks.org/searching-for-patterns-set-1-naive-pattern-searching/
 * 
 * Given a text txt[0..n-1] and a pattern pat[0..m-1], 
 * write a function search(char pat[], char txt[]) that prints all 
 * occurrences of pat[] in txt[]. You may assume that n > m.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		String input = "AABAACAADAABAAABAA";
		String pattern = "AABA";
		
		patternSearch2(input,pattern);
	}
	
	public static void patternSearch(String input, String pattern){
		for(int i=0; i<input.length()-pattern.length();i++){
			int j=0;
			for(j=0; j<pattern.length();j++){
				if(input.charAt(i+j)!=pattern.charAt(j)){
					break;
				}
			}
			if(j==pattern.length())System.out.println("pattern found at : "+i);
		}
	}
	
	//Using String API function.
	public static void patternSearch2(String input, String pattern){
		int start = 0;
		int occuredAt = input.indexOf(pattern, start);
		while(occuredAt != -1){
			System.out.println("pattern found at :"+occuredAt);
			occuredAt = input.indexOf(pattern, occuredAt+1);
		}
	}
}
