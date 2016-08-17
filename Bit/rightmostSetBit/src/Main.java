/**
 * http://www.geeksforgeeks.org/position-of-rightmost-set-bit/
 * 
 * Write a java function to return position of first 1 from right to left, in binary representation of an Integer.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x = 16;
		System.out.println("The right most set bit of "+Integer.toBinaryString(x)+" is at position : "+positionOfRightmostSetBit(x));
	}
	
	public static int positionOfRightmostSetBit(int x){
		
		int y = x & (-x);
		int count=0;
		while((y & 1)==0){
			y = y>>1;
			count++;
		}
		return count;
	}
}
