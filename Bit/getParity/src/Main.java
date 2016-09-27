/**
 * http://www.geeksforgeeks.org/write-a-c-program-to-find-the-parity-of-an-unsigned-integer/
 * http://www.geeksforgeeks.org/count-set-bits-in-an-integer/
 * 
 * Parity of a number refers to whether it contains an odd or even number of 1-bits. The number 
 * has “odd parity”, if it contains odd number of 1-bits and is “even parity” if it contains 
 * even number of 1-bits.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int x =11;
		System.out.println("parity of "+Integer.toBinaryString(x)+" is "+getParity(x));

	}
	
	public static boolean getParity(int x){
		boolean parity = false;
		while(x > 0){
			parity = !parity;
			x = (x & x-1);
		}
		return parity;
	}

}
