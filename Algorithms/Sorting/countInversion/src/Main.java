import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/counting-inversions/
 * 
 * Inversion Count for an array indicates – how far (or close) 
 * the array is from being sorted. If array is already sorted then 
 * inversion count is 0. If array is sorted in reverse order that 
 * inversion count is the maximum. 
 * Formally speaking, two elements a[i] and a[j] form an inversion 
 * if a[i] > a[j] and i < j
 * 
 * Example:
 * The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] array = {64, 25, 12, 22, 11, 66}; //9
		//int[] array = {6, 5, 4, 3, 2, 2}; //14
		//int[] array = {1, 2, 3, 4, 5, 6}; //0
		//int[] array = {1, 2, 3, 4, 6, 5}; //1
		//int[] array = {2, 4, 1, 3, 5}; //3
		System.out.println(Arrays.toString(array));
		System.out.println("inversion count = "+inversionCount(array));
		System.out.println(Arrays.toString(array));
	}
	
	public static int inversionCount(int[] array){
		return mergeSortAndCount(array,0,array.length-1);
	}
	
	public static int mergeSortAndCount(int[] array,int l, int r){
		int invCount=0;
		if(l<r){
			int m = (l+r)/2;
			invCount = mergeSortAndCount(array,l,m);
			invCount += mergeSortAndCount(array,m+1,r);
			invCount += merge(array,l,m,r);
		}
		return invCount;
	}
	
	public static int merge(int[] array, int l, int m, int r){
		int l_len = m-l+1;
		int r_len = r-m;
		int[] L = new int[l_len];
		int[] R = new int[r_len];
		int invCount = 0;
		for(int i=0; i<l_len; i++){
			L[i] = array[i+l];
		}
		for(int i=0; i<r_len; i++){
			R[i] = array[i+m+1];
		}
		
		int i=0,j=0,k=l;
		while(i < l_len && j < r_len){
			if(L[i] <= R[j]){
				array[k] = L[i];
				i++;k++;
			}else{
				//System.out.println(Arrays.toString(array)+" i,j,k,m = "+i+" "+j+" "+k+" "+m+" invcount = "+invCount);
		 		array[k] = R[j];
				j++;k++;
				invCount  += m+1-(l+i);
			}
		}
		
		while(i < l_len){
			array[k] = L[i];
			k++;i++;
		}
		while(j < r_len){
			array[k] = R[j];
			k++;j++;
		}
		return invCount;
	}
}
