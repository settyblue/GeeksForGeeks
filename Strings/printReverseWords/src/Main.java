/**
 * print each word in a given sentence in reverse order.
 * ex : "what should i say now i"
 * ans : "tahw dluohs i yas won i"
 * 
 * part 2:
 * print the words in a reverse order in the given sentence.
 * ex : "what should i say now i"
 * ans : "i now say i should what"
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		String s = "what should i say now i";
		printWordReverse(s);

	}

	private static void printWordReverse(String s) {
		StringBuffer sb = new StringBuffer(s);
		int i=0, start=0, end;
		while(i<sb.length()){
			start = i;
			while(i<sb.length() && sb.charAt(i) != ' '){
				i++;
			}
			end =i;
			reverse(sb,start,end);
			i++;
		}
		System.out.println(sb);
		reverse(sb,0,sb.length());
		System.out.println(sb);
	}

	private static void reverse(StringBuffer sb, int start, int end) {
		char temp;
		for(int i=start; i<(start+end)/2; i++){
			temp = sb.charAt(i);
			sb.setCharAt(i, sb.charAt(end-1-(i-start)));
			sb.setCharAt(end-1-(i-start), temp);
		}
		
	}

}
