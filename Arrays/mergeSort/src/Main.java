/**
 * Merge two sorted arrays into single sorted array.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] a = {2, 8, 13, 15, 20};
		int[] b = {5, 7, 9, 10};
		int[] c = new int[a.length+b.length];
		mergeSort(a,b,c);
		printArray(c);
	}

	private static void printArray(int[] c) {
		for(int i=0;i<c.length;i++){
			System.out.print(c[i]+" ");
		}
		
	}

	private static void mergeSort(int[] a, int[] b, int[] c) {
		int i=0,j=0,k=0,m=a.length+b.length;
		while(k<m){
			if(i!=a.length && j!=b.length){
				if(a[i]<b[j]){
					c[k] = a[i];
					i++;
				}else{
					c[k] = b[j];
					j++;
				}
				k++;
			}else{
				if(i!=a.length){
					while(i<a.length){
						c[k] = a[i];
						k++;i++;
					}
				}else{
					while(j<b.length){
						c[k] = b[j];
						k++;j++;
					}
				}
			}
		}
	}

}
