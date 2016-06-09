/**
 * http://www.geeksforgeeks.org/check-if-an-array-can-be-divided-into-pairs-whose-sum-is-divisible-by-k/
 * 
 * Check if an array can be divided into pairs whose sum is divisible by k
 * Given an array of integers and a number k, write a function 
 * that returns true if given array can be divided into pairs such 
 * that sum of every pair is divisible by k.
 * Input: arr[] = {92, 75, 65, 48, 45, 35}, k = 10
 * Output: True
 * We can divide array into (92, 48), (75, 65) and 
 * (45, 35). Sum of all these pairs is a multiple of 10.
 * 
 */


/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		//int[] array = {92, 75, 65, 48, 45, 35};
		//int k = 10;
		int[] array = {1, 2, 3, 4, 5, 3};
		int k = 3;
		if(checkPairs(array,k)){
			System.out.println("Pairs can be formed");
		}else{
			System.out.println("Pairs cannot be formed");
		}
	}

	private static boolean checkPairs(int[] array, int k) {
		int[] count = new int[k];
		
		for(int i=0; i<array.length; i++){
			count[array[i]%k]++;
		}
		
		for(int i=0; i<k; i++){
			if(i==0){
				if(count[0]%2 !=0){
					return false;
				}
			}else {
				if(count[i] != count[k-i]){
					return false;
				}
			}
			if(k%2==0){
				if(count[k/2]%2 != 0){
					return false;
				}
			}
		}
		return true;
	}

}
