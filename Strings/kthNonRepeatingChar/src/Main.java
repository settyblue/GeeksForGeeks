import java.util.LinkedHashMap;
/**
 * http://www.geeksforgeeks.org/kth-non-repeating-character/
 * 
 * K’th Non-repeating Character.
 * Given a string and a number k, find the k’th non-repeating character 
 * in the string. Consider a large input string with lots of characters 
 * and a small character set. How to find the character by only doing only 
 * one traversal of input string?
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		String s = "geeksforgeeks";
		int k = 3;
		
		printKthNonRepeatingChar(s,k);

	}

	private static void printKthNonRepeatingChar(String s, int k) {
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character,Integer>();
		for(int i=0; i<s.length(); i++){
			if(map.containsKey(s.charAt(i))){
				map.put(s.charAt(i), map.get(s.charAt(i))+1);
			}else{
				map.put(s.charAt(i), 1);
			}
		}
		int count =0;
		for(int key:map.keySet()){
			if(map.get((char)(key)) == 1){
				count++;
				if(count == k){
					System.out.println("print kth non repeating number : "+(char)key);
					break;
				}
			}
		}
		if(count<k){
			System.out.println("no element found");
		}
	}

}
