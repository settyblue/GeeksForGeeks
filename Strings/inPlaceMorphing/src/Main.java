/**
 * https://www.careercup.com/question?id=18460667
 * http://www.geeksforgeeks.org/remove-a-and-bc-from-a-given-string/
 * 
 * Eliminate all ‘b’ and ‘ac’ in an array of characters, 
 * you have to replace them in-place, and you are only allowed to 
 * iterate over the char array once. 
 * 
 * The two conditions are:
 * 1. Filtering of all ‘b’ and ‘ac’ should be in single pass
 * 2. No extra space allowed.
 * 
 * Examples: 
 * abc -> ac 
 * ac->'' 
 * react->ret
 * abaaaccreactba -> aareta
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("abaaaccreactba");
		System.out.println("actual   string : "+sb);
		modifyString(sb);
		System.out.println("modified string : "+sb);
	}

	private static void modifyString(StringBuffer sb) {
		int j=0;
		boolean tracker = false;
		for(int i=0; i< sb.length(); i++){
			if(sb.charAt(i) != 'b' && sb.charAt(i) != 'a'){
				if(!tracker){
					sb.setCharAt(j, sb.charAt(i));
					j++;
				}
				else{
					if(sb.charAt(i)!='c'){
						sb.setCharAt(j, 'a');
						j++;
						if(sb.charAt(i)!='a'){
							sb.setCharAt(j, sb.charAt(i));
							j++;
						}
					}
				}
			}else if(tracker){
				sb.setCharAt(j, 'a');
				j++;
			}
			if(sb.charAt(i) == 'a'){
				tracker = true;
			}else{
				tracker = false;
			}
			
			if(j>1 && sb.charAt(j-1) == 'c' && sb.charAt(j-2) == 'a'){
				j = j-2;
			}
		}
		if(tracker){
			sb.setCharAt(j, 'a');
			j++;
		}
		sb.setCharAt(j, '\0');
		return;
	}

}
