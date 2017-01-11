/**
 * http://www.geeksforgeeks.org/add-two-numbers-without-using-arithmetic-operators/
 * https://leetcode.com/problems/sum-of-two-integers/
 * 
 * Write a function Add() that returns sum of two integers. The function should not 
 * use any of the arithmetic operators (+, ++, –, -, .. etc).
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int x = 16, y = 12;
		System.out.println("Sum of two numbers is "+add(x,y));

	}
	
	public static int add(int x, int y){
		if(y==0){
			return x;
		}else{
			return add(x^y,(x&y)<<1);
		}
	}
}
