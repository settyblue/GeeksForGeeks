import java.util.Arrays;

/**
 * http://quiz.geeksforgeeks.org/merge-sort/
 * 
 * Merge Sort
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		//int[] array = {64, 25, 12, 22, 11, 66};
		int[] array = {6, 5, 4, 3, 2, 2};
		//int[] array = {1, 2, 3, 4, 5, 6};
		mergeSortAndPrint(array);
	}
	
	public static void mergeSortAndPrint(int[] array){
		mergeSort(array,0,array.length-1);
		System.out.println(Arrays.toString(array));
	}
	
	public static void mergeSort(int[] array, int l, int r){
		if(l<r){
			int m = (l+r)/2;
			mergeSort(array,l,m);
			mergeSort(array,m+1,r);
			merge(array,l,m,r);
		}
	}
	
	public static void merge(int[] array,int l, int m, int r){
		int l_len = m-l+1;
		int r_len = r-m;
		int[] L = new int[l_len];
		int[] R = new int[r_len];
		
		for(int i=0;i<l_len;i++){
			L[i] = array[l+i];
		}
		for(int i=0;i<r_len;i++){
			R[i] = array[m+1+i];
		}
		
		int i=0,j=0,k=l;
		while(i<l_len && j<r_len){
			if(L[i]<R[j]){
				array[k] = L[i];
				i++;
			}else{
				array[k] = R[j];
				j++;
			}
			k++;
		}
		
		while(i<l_len){
			array[k] = L[i];
			i++;k++;
		}
		
		while(j<r_len){
			array[k] = R[j];
			j++;k++;
		}
	}
}
