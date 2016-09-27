/**
 * http://www.geeksforgeeks.org/add-1-to-a-given-number/
 * 
 * Write a program to add one to a given number. You are not allowed 
 * to use operators like ‘+’, ‘-‘, ‘*’, ‘/’, ‘++’, ‘–‘ …etc.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int x = 15;
		//System.out.println("increment of "+x+" is "+incrementByOne(x));
		System.out.println("increment of "+x+" is "+incrementByOne2(x));
	}
	
	public static int incrementByOne(int x){
		
		int y = 1;
		while((x & y) > 0){
			x = x ^ y;
			y = y << 1;
		}
		
		return (x | y);
	}
	
	public static int incrementByOne2(int x){
		return -(~x);
	}
}
