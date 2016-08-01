import java.util.HashSet;
/**
 * http://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
 * 
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		String s = "geeksforgeeks";
		//String s = "geeks";
		System.out.println("Length of longest non repeating character subtring is "+lengthSubstring(s));

	}
	
	public static int lengthSubstring(String s){
		int maxLength = 0;
		int curLength = 0;
		int startIndex = 0;
		HashSet<Character> set = new HashSet<Character>();
		
		for(int i=0; i<s.length(); i++){
			if(!set.contains(s.charAt(i))){
				curLength++;
				set.add(s.charAt(i));
				maxLength = Math.max(maxLength, curLength);
			}else{
				while(set.contains(s.charAt(i))){
					set.remove(s.charAt(startIndex));
					startIndex++;
					curLength--;
				}
				curLength++;
				set.add(s.charAt(i));
			}
		}
		return maxLength;
	}
}
