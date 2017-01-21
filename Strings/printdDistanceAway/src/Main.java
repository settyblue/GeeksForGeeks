import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * http://www.geeksforgeeks.org/rearrange-a-string-so-that-all-same-characters-become-atleast-d-distance-away/
 * 
 * Given a string and a positive integer d, rearrange characters of the given string such that the same 
 * characters become at-least d distance away from each other.
 *
 * Note that there can be many possible rearrangements, the output should be one of the possible rearrangements. 
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		//String s = "aaaabbbcc";
		String s = "aaa";
		int d = 2;
		String[] answer = {""};
		if(printdDistanceAway(s,d, answer)){
			System.out.println(answer[0]);
		}else{
			System.out.println("Not possible.");
		}
	}

	private static boolean printdDistanceAway(String s, int d, String[] answer) {
		HashMap<Character,Freq> map = new HashMap<>();
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(map.containsKey(c)){
				map.get(c).count++;
			}else{
				map.put(c, new Freq(c,1));
			}
		}
		ArrayList<Freq> list = new ArrayList<>();
		HashMap<Character, Boolean> doneMap = new HashMap<>();
		for(char key:map.keySet()){
			list.add(map.get(key));
			doneMap.put(key, false);
		}
		
		Collections.sort(list);
		StringBuffer str = new StringBuffer();
		
		for(int i=0;i<s.length();i++){
			Freq curFreq = list.remove(0);
			char curChar = curFreq.c;
			if(!doneMap.get(curChar)){
				str.append(curChar);
				if(curFreq.count != 1){
					curFreq.count--;
					list.add(curFreq);
					doneMap.put(curChar, true);
				}else{
					doneMap.remove(curChar);
				}
			}else{
				return false;
			}
			if(i%d==d-1){
				Collections.sort(list);
				for(char key:doneMap.keySet()){
					doneMap.put(key,false);
				}
			}
		}
		answer[0] = str.toString();
		return true;
	}
	
	public static class Freq implements Comparable<Freq>{
		char c;
		int count;
		
		Freq(char c, int count){
			this.c = c;
			this.count = count;
		}
		
		@Override
		public int compareTo(Freq f){
			if(this.count > f.count)
				return -1;
			return 1;
		}
		
	}
}
