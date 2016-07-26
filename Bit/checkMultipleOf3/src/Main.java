import static java.lang.Math.abs;
/**
 * http://www.geeksforgeeks.org/write-an-efficient-method-to-check-if-a-number-is-multiple-of-3/
 * 
 * Write an Efficient Method to Check if a Number is Multiple of 3
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int x =11;
		if(isMultipleOf3(x)){
			System.out.println(x+" is a mutiple of 3.");
		}else{
			System.out.println(x+" is not a mutiple of 3.");
		}
	}

	public static boolean isMultipleOf3(int x){
		
		if(x==0) return true;
		if(x==1 || x==2) return false;
		
		int odd_count=0, even_count=0;
		int y = 1;
		while(x>0){
			if((x & y) > 0){
				odd_count++;
			}
			x = x >> 1;
			if((x & y) > 0){
				even_count++;
			}
			x = x >> 1;
		}
		return isMultipleOf3(abs(odd_count-even_count));
	}
}
