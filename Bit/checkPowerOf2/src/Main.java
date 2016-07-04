/**
 * http://www.geeksforgeeks.org/write-one-line-c-function-to-find-whether-a-no-is-power-of-two/
 * Write java function to find whether a no. is power of two
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int x = 16;
		if(isPowerOf2(x)){
			System.out.println(x+" is a power of 2.");
		}else{
			System.out.println(x+" is not a power of 2.");
		}
	}
	
	public static boolean isPowerOf2(int x){
		return (x & (x-1)) == 0;
	}
}
