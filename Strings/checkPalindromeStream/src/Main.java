/**
 * http://www.geeksforgeeks.org/online-algorithm-for-checking-palindrome-in-a-stream/
 * 
 * Given a stream of characters (characters are received one by one), 
 * write a function that prints ‘Yes’ if a character makes the complete string palindrome, else prints ‘No’.
 */

/**
 * @author rakshith
 *
 */
public class Main {
	
	public static int q = 101;
	public static int d = 256;
	public static void main(String[] args) {
		String s = "aabaacaabaa";
		checkPlaindromeStream(s);
		
	}
	
	private static void checkPlaindromeStream(String s) {
		int n = s.length();
		
		if(n==0)return;
		System.out.println(s.charAt(0)+" : YES");
		if(n==1)return;
		
		int first_hash = s.charAt(0)%q;
		int last_hash = s.charAt(1)%q;
		
		int h = 1;
		
		for(int i=1;i<n;i++){
			if(first_hash == last_hash){
				int j = 0;
				for(j=0;j<i/2;j++){
					if(s.charAt(j) != s.charAt(i-j)){
						break;
					}
				}
				
				if(j==i/2){
					System.out.println(s.substring(0,i+1)+" : YES");
				}else{
					System.out.println(s.substring(0,i+1)+" : NO");
				}
			}else{
				System.out.println(s.substring(0,i+1)+" : NO");
			}
			
			if(i != n-1){
				if(i%2==0){
					h = (h*d)%q;
					first_hash = (first_hash + h*s.charAt(i/2))%q;
					last_hash = (last_hash*d + s.charAt(i+1))%q;
					
				}else{
					last_hash = (((last_hash - s.charAt((i+1)/2)*h)*d + q)%q + s.charAt(i+1) )%q;
				}
			}
		}
	}

}
