/**
 * http://www.geeksforgeeks.org/transform-one-string-to-another-using-minimum-number-of-given-operation/
 * 
 * Given two strings A and B, the task is to convert A to B if possible. 
 * The only operation allowed is to put any character from A and insert it at front. 
 * Find if it’s possible to convert the string. If yes, then output minimum no. of 
 * operations required for transformation.
 * 
 * Input:  A = "EACBD", B = "EABCD"
 * Output: 3
 * Explanation: Pick B and insert at front, EACBD => BEACD
 *              Pick A and insert at front, BEACD => ABECD
 *              Pick E and insert at front, ABECD => EABCD
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		
		String s1 = "EACBD";
		String s2 = "EABCD";
		
		System.out.println("minimum number of moves is "+minMoves(s1, s2));

	}

	private static int minMoves(String s1, String s2) {
		
		if(s1.length() != s2.length())return -1;
		int[] count = new int[256];
		for(int i=0;i<s1.length();i++){
			count[s1.charAt(i)]++;
		}
		for(int i=0;i<s1.length();i++){
			count[s2.charAt(i)]--;
		}
		for(int i=0;i<256;i++){
			if(count[i] != 0)return -1;
		}
		
		int moves = 0;
		int i = s1.length()-1, j = s1.length()-1;
		while(i>=0){
			if(s1.charAt(i)==s2.charAt(j)){
				i--;j--;
			}else{
				while(i>=0 && s1.charAt(i) != s2.charAt(j)){
					i--;moves++;
				}
			}
		}
		return moves;
	}

}
