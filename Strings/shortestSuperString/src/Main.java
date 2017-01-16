import java.util.ArrayList;

/**
 * http://www.geeksforgeeks.org/shortest-superstring-problem/
 * 
 * Given a set of n strings arr[], find the smallest string that 
 * contains each string in the given set as substring. We may assume 
 * that no string in arr[] is substring of another string.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		String array[] = {"catgc", "ctaagt", "gcta", "ttca", "atgcatc"}; // gctaagttcatgcatc
		System.out.println(shortestSuperString(array));

	}

	private static String shortestSuperString(String[] array) {
		ArrayList<String> temp = new ArrayList<>();
		for(String s:array){
			temp.add(s);
		}
		
		while(temp.size() != 1){
			int maxOverlap = -1; //store max overlap value.
			int l = 0,r = 1; //store index values of string with max overlap.
			
			String resultStr = "";
			
			for(int i=0;i<temp.size();i++){
				for(int j=i+1;j<temp.size();j++){
					String[] tempStr = {""};
					int curOverlapValue = computeMaxOverLap(temp.get(i),temp.get(j),tempStr);
					if(maxOverlap < curOverlapValue){
						maxOverlap = curOverlapValue;
						l = i; r = j;
						resultStr = tempStr[0];
					}
				}
			}
			System.out.println(temp.toString());
			temp.set(l, resultStr);temp.remove(r);
		}
		return temp.get(0);
	}

	private static int computeMaxOverLap(String str1, String str2, String[] returnStr) {
		int maxOverlap = 0;
		int m = str1.length();
		int n = str2.length();
		
		for(int i=1;i<=Math.min(m, n);i++){
			if(str1.endsWith(str2.substring(0,i))){
				if(i>maxOverlap){
					maxOverlap = i;
					returnStr[0] = str1+str2.substring(i,n);
				}
			}
		}
		
		for(int i=1;i<=Math.min(m, n);i++){
			if(str2.endsWith(str1.substring(0,i))){
				if(i>maxOverlap){
					maxOverlap = i;
					returnStr[0] = str2+str1.substring(i,m);
				}
			}
		}
		if(maxOverlap == 0){
			returnStr[0] = str1+str2;
		}
		return maxOverlap;
	}

}
