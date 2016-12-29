/**
 * http://www.geeksforgeeks.org/find-the-minimum-distance-between-two-numbers/
 * 
 * Given an unsorted array arr[] and two numbers x and y, find the minimum distance between x and y in arr[]. 
 * The array might also contain duplicates. You may assume that both x and y are different and present in arr[].
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] array =  {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
		int x = 3, y = 6;
		
		System.out.println(minDistance(array, x, y));

	}

	private static int minDistance(int[] array, int x, int y) {
		int prev = -1;
		int i = 0;
		int n = array.length;
		while(array[i] != x && array[i] != y)i++;
		if(i==n)return -1;
		if(x==y)return 0;
		int minDistance = Integer.MAX_VALUE;
		prev = i;
		for(int j=i+1;j<n;j++){
			if(array[j] == x || array[j] == y){
				if(array[j] == array[prev]){
					prev = j;
				}else{
					minDistance = Math.min(j-prev, minDistance);
					prev = j;
				}
			}
		}
		
		return minDistance;
	}

}
