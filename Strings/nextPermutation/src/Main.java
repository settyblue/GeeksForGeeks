import java.util.ArrayList;
import java.util.Collections;

/**
 * http://www.geeksforgeeks.org/lexicographically-previous-permutation-in-c/
 * http://www.geeksforgeeks.org/find-the-next-lexicographically-greater-word-than-a-given-word/
 * 
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		String s = "gfg"; //ggf
		//String s = "53334432";
		System.out.println(s);
		System.out.println("next : "+nextPermutation(s));
		System.out.println("prev : "+prevPermutation(s));
	}

	private static String prevPermutation(String s) {
		int n = s.length();
		int i = n-1;
		ArrayList<Character> list = new ArrayList<>();
		list.add(s.charAt(n-1));
		while(i>0 && s.charAt(i-1) <= s.charAt(i)){
			list.add(s.charAt(i-1));
			i--;
		}
		
		if(i==0){
			return "Not possible";
		}
		
		char c = s.charAt(i-1);
		char ch = '?';
		for(char temp:list){
			if(temp<c){
				ch = temp;
				break;
			}
		}
		
		String answer = "";
		answer = s.substring(0,i-1);
		
		list.remove(Character.valueOf(ch));
		answer += ch;
		list.add(c);
		Collections.sort(list);
		for(i=list.size()-1;i>=0;i--){
			answer += list.get(i);
		}
		return answer;
	}

	private static String nextPermutation(String s) {
		int n = s.length();
		int i = n-1;
		ArrayList<Character> list = new ArrayList<>();
		list.add(s.charAt(n-1));
		while(i>0 && s.charAt(i-1) >= s.charAt(i)){
			list.add(s.charAt(i-1));
			i--;
		}
		//System.out.println(list);
		if(i==0){
			return "Not Possible";
		}
		
		char c = s.charAt(i-1);
		char ch = '?';
		for(char temp:list){
			if(temp>c){
				ch = temp;
				break;
			}
		}
		//System.out.println(ch);
		String answer = "";
		answer = s.substring(0,i-1);
		answer += ch;
		
		list.remove(Character.valueOf(ch));
		list.add(c);
		Collections.sort(list);
		for(char temp:list){
			answer += temp;
		}
		
		return answer;
	}

}
