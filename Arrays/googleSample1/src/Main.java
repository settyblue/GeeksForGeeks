/**
 * 
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int x = 623315;
		int maxSoFar = 0;
		String num = Integer.toString(x);
		String answer = "";
		int n = Integer.toString(x).length();
		for(int i=0; i<n-1; i++){
			int cur = Character.getNumericValue(num.charAt(i));
			int next = Character.getNumericValue(num.charAt(i+1));
			int replacedValue = 0;
			int sum = cur + next;
			if(sum%2==0){
				replacedValue = (cur + next)/2;
			}else{
				replacedValue = (cur + next + 1)/2;
			}
			
			answer = num.substring(0,i)+ replacedValue + num.substring(i+2,n);
			maxSoFar = Math.max(maxSoFar, Integer.parseInt(answer));
			//System.out.println(answer);
		}
		System.out.println(maxSoFar);
	}

}
