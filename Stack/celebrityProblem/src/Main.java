import java.util.Stack;

/**
 * http://www.geeksforgeeks.org/the-celebrity-problem/
 * 
 * In a party of N people, only one person is known to everyone. Such a person may be present in the party, 
 * if yes, (s)he doesn’t know anyone in the party. 
 * We can only ask questions like “does A know B? “. 
 * Find the stranger (celebrity) in minimum number of questions.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[][] matrix = {{0, 0, 1, 0},
			    {0, 0, 1, 0},
			    {0, 0, 0, 0},
			    {0, 0, 1, 0}};
		
		System.out.println(celebrity(matrix));
		System.out.println(celebrityUsingPointers(matrix));

	}
	
	private static String celebrityUsingPointers(int[][] matrix) {
		int n = matrix.length;
		int[] array = new int[n];
		int a = 0, b = n-1;
		
		while(a<b){
			if(haveAcq(a,b,matrix) == 1){
				a++;
			}else{
				b--;
			}
		}
		int c = a;
		for(int j=0;j<n;j++){
			if(j==c)continue;
			else if(haveAcq(j,c,matrix) != 1){
				return "No celebrity";
			}
		}
		
		return ""+c;
	}

	private static String celebrity(int[][] matrix) {
		int n = matrix.length;
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		while(i<n){
			stack.push(i);
			i++;
		}
		
		int a = stack.pop();
		int b = stack.pop();
		
		while(stack.size()>1){
			if(haveAcq(a,b,matrix)==1){
				a = stack.pop();
			}else{
				b = stack.pop();
			}
		}
		
		int c = 0;
		if(haveAcq(a,b,matrix) == 1){
			c = b;
		}else{
			c = a;
		}
		
		for(int j=0;j<n;j++){
			if(j==c)continue;
			else if(haveAcq(j,c,matrix) != 1){
				return "No celebrity";
			}
		}
		
		return ""+c;
	}

	public static int haveAcq(int a, int b, int[][] matrix){
		return matrix[a][b];
	}
	
}
