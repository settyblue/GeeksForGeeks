import java.util.HashSet;
/**
 * http://www.geeksforgeeks.org/given-an-array-of-pairs-find-all-symmetric-pairs-in-it/
 * 
 * Given an array of pairs, find all symmetric pairs in it
 * Two pairs (a, b) and (c, d) are said to be symmetric if c is equal to b and a is equal to d. 
 * For example (10, 20) and (20, 10) are symmetric. 
 */


/**
 * @author rakshith
 *
 */
public class Main {
	
	public static class Pairs{
		int a,b;
		
		Pairs(int i, int j){
			a=i;b=j;
		}
		
		public String toString(){
			return "("+a+", "+b+")";
		}
		
		@Override
		public boolean equals(Object obj){
			if (this == obj)
		         return true;
		    if (obj == null)
		         return false;
		    if (getClass() != obj.getClass())
		         return false;
		    Pairs other = (Pairs) obj;
		    if (a != other.a || b != other.b)
		         return false;
		    
		    return true;
		}
		
		@Override
		public int hashCode() {
		    return a+b;
		}
	}
	
	public static void main(String[] args) {
		Pairs[] array = new Pairs[5];
		array[0] = new Pairs(11, 20);
		array[1] = new Pairs(30, 40);
		array[2] = new Pairs(5, 12);
		array[3] = new Pairs(40, 30);
		array[4] = new Pairs(10, 5);
		
		printSymmetricPairs(array);
	}

	private static void printSymmetricPairs(Pairs[] array) {
		HashSet<Pairs> set = new HashSet<Pairs>();
		System.out.println("Symmetric pairs :");
		for(int i=0; i<array.length; i++){
			if(set.contains(new Pairs(array[i].b,array[i].a))){
				System.out.println(array[i]+" and "+new Pairs(array[i].b,array[i].a));
			}else{
				set.add(array[i]);
			}
		}
		
	}
	
	public boolean equals(Pairs p){
		return false;
	}

}
