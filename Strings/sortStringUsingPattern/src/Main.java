import java.util.HashMap;

/**
 * http://www.geeksforgeeks.org/sort-string-according-order-defined-another-string/
 * 
 * Given two strings (of lowercase letters), a pattern and a string. 
 * The task is to sort string according to the order defined by pattern. It may be assumed that 
 * pattern has all characters of the string and all characters in pattern appear only once.
 * 
 * Input  : pat = "bxyzca", str = "abcabcabc"
 * Output : str = "bbbcccaaa"
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		String s =  "abcabcabc";
		String pattern = "bxyzca";
		
		System.out.println(sortStringUsingPattern(s, pattern));
	}

	private static String sortStringUsingPattern(String s, String pattern) {
		int n = s.length();
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i=0;i<n;i++){
			char c = s.charAt(i);
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}else{
				map.put(c, 1);
			}
		}
		StringBuffer answer = new StringBuffer();
		for(int i=0;i<pattern.length();i++){
			char c = pattern.charAt(i);
			if(map.containsKey(c)){
				for(int j=0; j<map.get(c);j++){
					answer.append(c);
				}
			}
		}
		return answer.toString();
	}

}
