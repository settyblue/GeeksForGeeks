/**
 * http://www.geeksforgeeks.org/place-replace-multiple-occurrences-pattern/
 * 
 * Given a string and a pattern, replace multiple occurrences of a pattern by character ‘X’. 
 * The conversion should be in-place and solution should replace multiple consecutive (and non-overlapping) 
 * occurrences of a pattern by a single ‘X’.
 * 
 * String – GeeksForGeeks
 * Pattern – Geeks
 * Output: XforX
 *  
 * String – GeeksGeeks
 * Pattern – Geeks
 * Output: X
 * 
 * String – aaaa
 * Pattern – aa
 * Output: X
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		String s = "aaaa";//"GeeksForGeeks";
		String pattern = "aa";//"Geeks";
		char replace = 'X';
		System.out.println(inPlaceMorph(s,pattern,replace));
	}

	private static String inPlaceMorph(String s, String pattern, char replace) {
		int i=0, j=0;
		int n = s.length();
		StringBuffer answer = new StringBuffer(s);
		while(i<n){
			if(s.charAt(i) == pattern.charAt(0)){
				int k = 1;
				while(k<pattern.length() && s.charAt(i+k) == pattern.charAt(k)){
					k++;
				}
				if(k == pattern.length()){
					answer.setCharAt(j, replace);j++;
					i = i+pattern.length();
				}else{
					answer.setCharAt(j, s.charAt(i));
					i++;j++;
				}
				
			}else{
				answer.setCharAt(j, s.charAt(i));
				j++;
				i++;
			}
		}
		
		return answer.toString().substring(0,j);
	}

}
