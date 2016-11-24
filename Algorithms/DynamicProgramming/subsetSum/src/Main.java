import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/
 * 
 * Given a set of non-negative integers, and a value sum, determine if 
 * there is a subset of the given set with sum equal to given sum.
 */

/**
 * @author Rakshith Kunchum
 *
 */

public class Main {

	public static void main(String[] args) {
		//int[] array = {3, 34, 4, 12, 5, 2};
		//int[] array = {3, 34, 4, 12, 5};
		int[] array = {3, 34, 4, 12};
		int k = 9;
		
		if(sumPossibleRecursive(array, k)){
			System.out.println("True");
		}else{
			System.out.println("False");
		}

	}

	private static boolean sumPossibleRecursive(int[] array, int k) {
		if(sumPossible(array,k,0,0)){
			return true;
		}
		return false;
	}

	private static boolean sumPossible(int[] array, int k, int i, int sumTillNow) {
		if(sumTillNow == k){
			return true;
		}
		if(i == array.length){
			return false;
		}
		if(array[i] > k-sumTillNow){
			return sumPossible(array, k, i+1, sumTillNow);
		}else{
			return sumPossible(array, k, i+1, sumTillNow) || sumPossible(array, k, i+1, sumTillNow+array[i]);
		}
	}

	private static boolean sumPossibleIterative(int[] array, int k) {
		boolean[][] sum = new boolean[array.length][k+1];
		sum[0][array[0]] = true;
		for(int i=1; i<array.length; i++){
			int curElement = array[i]; 
			if(curElement <= k)sum[i][curElement] = true;
			for(int j=0; j<k+1; j++){
				if(j+curElement < k+1 && sum[i-1][j]){
					sum[i][j+curElement] = true;
				}
				sum[i][j] = sum[i][j]||sum[i-1][j];
			}
			System.out.println(Arrays.deepToString(sum));
			if(sum[array.length-1][k])return true;
		}
		
		return false;
	}

}
