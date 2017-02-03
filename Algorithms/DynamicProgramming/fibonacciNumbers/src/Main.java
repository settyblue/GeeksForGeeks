/**
 * 
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int n=10;
		System.out.println("nth fibonacci = "+getFibonacci2(n));

	}
	
	//Time Complexity = O(n), Space Complexity = O(1)
	public static int getFibonacci(int n){
		if(n==0 || n==1)return n;
		int a=0,b=1,c=1;
		int i=1;
		while(i<n){
			c = a+b;
			a = b;
			b = c;
			i++;
			System.out.print(c+"\t");
		}
		return c;
	}
	
	//Time Complexity = O(logn), Space COmplexity = O(n)
	public static int getFibonacci2(int n){
		int F[] = new int[n+1];
		return getF(F,n);
	}
	
	public static int getF(int[] F, int n){
		if(n==0)return 0;
		if(n==1 || n==2){
			F[n] = 1;
			return 1;
		}
		int k = (n%2==1) ? (n+1)/2 : n/2;
		if(F[n] != 0)
			return F[n];
		else{
			F[n] = (n%2==1) ? getF(F,k)*getF(F,k) + getF(F,k-1)*getF(F,k-1) :
								(2*getF(F,k-1)+getF(F,k))*getF(F,k);
			return F[n];
		}
	} 
}
