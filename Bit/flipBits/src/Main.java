/**
 * http://www.geeksforgeeks.org/count-number-of-bits-to-be-flipped-to-convert-a-to-b/
 * 
 * You are given two numbers A and B. Write a program to count number of bits needed to 
 * be flipped to convert A to B.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int x = 2;
		int y = 4;
		System.out.println("Number of bits to be flipped to change "+Integer.toBinaryString(x)+" to "+Integer.toBinaryString(y)
							+" is "+numberOfFlippedBits(x,y));

	}
	
	public static int numberOfFlippedBits(int x, int y){
		int z =  x ^ y;
		int count = 0;
		while(z > 0){
			z = z & z-1;
			count++;
		}
		return count;
	}
}
