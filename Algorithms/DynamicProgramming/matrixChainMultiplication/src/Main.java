/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-8-matrix-chain-multiplication/
 * http://www.personal.kent.edu/~rmuhamma/Algorithms/MyAlgorithms/Dynamic/chainMatrixMult.htm
 * 
 * Given a sequence of matrices, find the most efficient way to multiply these matrices together. 
 * The problem is not actually to perform the multiplications, but merely to decide in which order 
 * to perform the multiplications.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		//int[] array = {40, 20, 30, 10, 30}; //26000
		//int[] array = {10, 20, 30, 40, 30}; //30000
		int[] array = {10, 30, 5, 60}; //4500
		System.out.println("Minimum number of multiplciaiton operations : "+minOperations(array));
	}
	
	//recursive solution.
	public static int minOperations(int[] array){
		return minMatrixChain(array,1,array.length-1);
	}
	
	public static int minMatrixChain(int[] array, int i, int j){
		if(i==j){
			return 0;
		}
		int minCount=Integer.MAX_VALUE;
		for(int p=i; p<j; p++){
			minCount = Math.min(minCount,  minMatrixChain(array,i,p)
										 + minMatrixChain(array,p+1,j)
										 + array[i-1]*array[p]*array[j]);
		}
		return minCount;
	}

}
