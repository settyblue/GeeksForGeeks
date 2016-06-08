import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * http://www.geeksforgeeks.org/find-whether-an-array-is-subset-of-another-array-set-1/
 * Find whether an array is subset of another array | Added Method 3
 * Given two arrays: arr1[0..m-1] and arr2[0..n-1]. 
 * Find whether arr2[] is a subset of arr1[] or not. Both the arrays are not in sorted order. 
 * It may be assumed that elements in both array are distinct.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		Integer[] array1 = {11, 1, 13, 21, 3, 7};
		Integer[] array2 = {11, 3, 7, 1};
		if(checkSubset2(array1,array2)){
			System.out.println("subset yes.");
		}else{
			System.out.println("subset no.");
		}
	}
	
	//Implemented using hashset.
	private static boolean checkSubset(Integer[] array1, Integer[] array2) {
		Integer[] s=array1,b=array2;
		
		if(array1.length > array2.length){
			s=array2;b=array1;
		}
		Set<Integer> set = new HashSet<Integer>(Arrays.asList(b));
		for(int i=0; i<s.length; i++){
			if(!set.contains(s[i])){
				return false;
			}
		}
		return true;
	}
	
	
	private static boolean checkSubset2(Integer[] array1, Integer[] array2) {
		Arrays.sort(array1);
		Arrays.sort(array2);
		
		Integer[] s=array1,b=array2;
		if(array1.length > array2.length){
			s=array2;b=array1;
		}
		int i=0,j=0;
		while(i<s.length && j<b.length){
			if(b[j] < s[i]){
				j++;
			}else if(b[j] == s[i]){
				i++;
				j++;
			}else{
				return false;
			}
		}
		if(i==s.length){
			return true;
		}
		return false;
	}
}
