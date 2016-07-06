/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
 * 
 * Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert 'str1' into 'str2'.
 * 
 * Insert
 * Remove
 * Replace
 * 
 * All of the above operations are of equal cost.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		String a = "world";
		String b = "wrse";
		printEditDistance(a,b);
	}
	
	public static void printEditDistance(String a, String b){
		int al = a.length();
		int bl = b.length();
		int[][] ed = new int[al+1][bl+1];
		
		for(int i=0;i<=al;i++){
			for(int j=0;j<=bl;j++){
				if(i==0){
					ed[i][0] = i;
					continue;
				}
				if(j==0){
					ed[0][j] = j;
					continue;
				}
				if(Character.toLowerCase(a.charAt(i-1))==
						Character.toLowerCase(b.charAt(j-1))){
					ed[i][j] = ed[i-1][j-1];
				}else{
					ed[i][j] = 1 + min(ed[i-1][j-1],
									   ed[i][j-1],
									   ed[i-1][j]);
				}
			}
		}
		
		System.out.println(a+" "+b);
		System.out.println("edit distance = "+ed[al][bl]);
	}
	
	public static int min(int a, int b, int c){
		return Math.min(a,  Math.min(b, c));
	}
}
