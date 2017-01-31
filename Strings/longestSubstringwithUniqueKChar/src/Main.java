import java.util.HashMap;

/**
 * http://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/
 * 
 * Given a string you need to print longest possible substring that has exactly M unique characters. 
 * If there are more than one substring of longest possible length, then print any one of them.
 * 
 * "aabbcc", k = 3
 * There are substrings with exactly 3 unique characters
 * {"aabbcc" , "abbcc" , "aabbc" , "abbc" }
 * Max is "aabbcc" with length 6.
 * 
 * "aaabbb", k = 3
 * There are only two unique characters, thus show error message. 
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		String s = "aabacbebebe";
		int k = 3;
		
		printSubstringWithKUniqueCharacters(s, k);
	}

	private static void printSubstringWithKUniqueCharacters(String s, int k) {
		HashMap<Character, Integer> map = new HashMap<>();
		int n = s.length();
		int start=0,curPointer=0;
		int max = 0,curMax = 0,startIndexMax=0;
		while(curPointer<n){
			if(map.containsKey(s.charAt(curPointer)) && map.size()==k){
				curMax++;
				char c = s.charAt(curPointer);
				if(max < curMax){
					max = curMax;
					startIndexMax = start;
				}
				map.put(c, map.get(c)+1);
				curPointer++;
			}else if(map.containsKey(s.charAt(curPointer)) && map.size()<k){
				char c = s.charAt(curPointer);
				map.put(c, map.get(c)+1);
				curMax++;
				curPointer++;
			}else if(!map.containsKey(s.charAt(curPointer)) && map.size()==k){
				while(map.size()==k){
					char c = s.charAt(start);
					if(map.get(c)>1){
						map.put(c, map.get(c)-1);
					}else{
						map.remove(c);
					}
					start++;
					curMax--;
				}
				map.put(s.charAt(curPointer),1);
				curMax++;
				curPointer++;
			}else{
				map.put(s.charAt(curPointer),1);
				curMax++;
				curPointer++;
				if(map.size()==k){
					if(max < curMax){
						max = curMax;
						startIndexMax = start;
					}
				}
			}
			//System.out.println(curPointer+": "+map.toString()+", start = "+start+", maxLen = "+max+", startMax = "+startIndexMax);
		}
		
		System.out.println(s.substring(startIndexMax,startIndexMax+max)+" of length "+max);
	}

}
