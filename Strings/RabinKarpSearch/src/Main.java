/**
 * http://www.geeksforgeeks.org/searching-for-patterns-set-3-rabin-karp-algorithm/
 * 
 * Given a text txt[0..n-1] and a pattern pat[0..m-1], 
 * write a function search(char pat[], char txt[]) that prints all 
 * occurrences of pat[] in txt[]. You may assume that n > m.
 */

/**
 * @author rakshith
 *
 */
public class Main {
	
	public static int d = 256;
	public static void main(String[] args) {
		String s = "TEST IS A TEST TEST STRING.TEST";
		String pattern = "TEST";
		
		//using 101 as the prime number.
		RabinKarpSearch(s, pattern, 101);
	}

	private static void RabinKarpSearch(String s, String pattern, int q) {
		int m = pattern.length();
		int n = s.length();
		
		int s_hash = 0, p_hash = 0;
		int h = 1;
		
		//value of h should be pow(d,m-1)%q
		for(int i=0; i<m-1; i++){
			h = (h*d)%q;
		}
		
		for(int i=0;i<m;i++){
			s_hash = (s_hash*d + s.charAt(i))%q;
			p_hash = (p_hash*d + pattern.charAt(i))%q;
		}
		
		System.out.println(p_hash+" "+s_hash);
		for(int i=0;i<=n-m;i++){
			if(s_hash==p_hash){
				int j = 0;
				for(j=0;j<m;j++){
					if(s.charAt(i+j) != pattern.charAt(j)){
						break;
					}
				}
				if(j==m){
					System.out.println("pattern found at position "+(i));
				}
			}
			
			if(i<n-m){
				s_hash = (s.charAt(i+m) + d*(s_hash - s.charAt(i)*h))%q;
				if(s_hash < 0) s_hash += q;
				System.out.println(s_hash+" "+s.substring(i+1,i+m+1));
			}
		}
	}
}
