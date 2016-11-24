import java.util.Arrays;
import java.util.Comparator;

/**
 * http://www.geeksforgeeks.org/weighted-job-scheduling/
 * Given N jobs where every job is represented by following three elements of it - (Start Time, Finish Time, Profit).
 * Find the maximum profit subset of jobs such that no two jobs in the subset overlap.
 * 
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[][] jobs = {{3, 10, 20}, {1, 2, 50}, {16, 19, 100}, {2, 100, 200}};
		System.out.println(maxProfit(jobs));
	}
	
	public static class jobComparator implements Comparator<int[]>{
		public int compare(int[] job1, int[] job2){
			if(job1[1] < job2[1]){
				return -1;
			}
			return 1;
		}
	}
	
	public static int maxProfit(int[][] jobs){
		int n = jobs.length;
		Arrays.sort(jobs,new jobComparator());
		System.out.println(Arrays.deepToString(jobs));
		int[] maxProfit = new int[n];
		maxProfit[0] = jobs[0][2];
		for(int i=1; i<n; i++){
			int profitIncludingThisJob = jobs[i][2];
			int j = getPreviousNoClashMaxProfit(jobs, i);
			if(j != -1){
				profitIncludingThisJob += maxProfit[j];
			}
			maxProfit[i] = Math.max(profitIncludingThisJob, maxProfit[i-1]);
		}
		return maxProfit[n-1];
	}

	private static int getPreviousNoClashMaxProfit(int[][] jobs, int i) {
		for(int j=i-1; j>=0; j--){
			if(jobs[i][0] >= jobs[j][1]){
				return j;
			}
		}
		return -1;
	}
}
