import static java.lang.Math.max;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
 * 
 * The longest Increasing Subsequence (LIS) problem is to find the length of the longest 
 * subsequence of a given sequence such that all elements of the subsequence are sorted 
 * in increasing order. For example, length of LIS for { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] array = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };	
		printLongestIncreasingSubSequence(array);
		printLongestIncreasingSubSequence2(array);
	}
	
	public static void printLongestIncreasingSubSequence(int[] array){
		int n = array.length;
		int[][] lis = new int[n][n+1];
		for(int i=0;i<n;i++){
			lis[i][n] = 1;
		}
		
		for(int j=n-1;j>=0;j--){
			for(int i=j-1; i>=0; i--){
				if(array[i] > array[j]){
					lis[i][j] = lis[i][j+1];
				}else{
					lis[i][j] = max(lis[j][j+1]+1,lis[i][j+1]);
				}
			}
		}
		
		System.out.println("longest increasing subsequence length is "+lis[0][1]);
		
		/*
		for(int i=0;i<n;i++){
			for(int j=0;j<=n;j++){
				System.out.print(lis[i][j]);
			}
			System.out.println();
		}
		*/
	}
	
	public static void printLongestIncreasingSubSequence2(int[] array){
		int al = array.length;
		int[] lis = new int[al];
		
		for(int i=0; i<al; i++){
			lis[i] = 1;
		}
		
		for(int i=1; i<al; i++){
			for(int j=0; j<i; j++){
				if(array[i]>array[j] && lis[i] < lis[j]+1){
					lis[i] = lis[j]+1;
				}
			}
		}
		int max = 0;
		for(int i=0; i<al; i++){
			max = max(lis[i],max);
		}
		System.out.println("longest incresing subsequence length is "+max);
	}
}
