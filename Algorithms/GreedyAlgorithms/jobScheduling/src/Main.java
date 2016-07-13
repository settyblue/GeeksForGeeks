import java.util.Comparator;
import java.util.TreeSet;
import java.util.Set;
/**
 * http://www.geeksforgeeks.org/job-sequencing-problem-set-1-greedy-algorithm/
 * 
 * Given an array of jobs where every job has a deadline and associated profit 
 * if the job is finished before the deadline. It is also given that every job 
 * takes single unit of time, so the minimum possible deadline for any job is 1. 
 * How to maximize total profit if only one job can be scheduled at a time.
 */

/**
 * @author rakshith
 *
 */
public class Main {
	
	public static class Job implements Comparable<Job>{
		String id;
		int profit;
		int deadline;
		
		Job(String id, int profit, int deadline){
			this.id = id;
			this.profit = profit;
			this.deadline = deadline;
		}
		
		@Override
		public int compareTo(Job j){
			return this.profit - j.profit;
		}
		
		public static Comparator<Job> decscendingOrder = new Comparator<Job>(){
			public int compare(Job j1, Job j2){
				return j2.profit - j1.profit;
			}
		};
		
		public String toString(){
			return "["+this.id+", "+this.profit+", "+this.deadline+"]";
		}
	}
	
	public static void main(String[] args) {
		TreeSet<Job> set = new TreeSet<Job>(Job.decscendingOrder);
		set.add(new Job("a", 10, 2));
		set.add(new Job("b", 19, 8));
		set.add(new Job("c", 27, 2));
		set.add(new Job("d", 25, 1));
		set.add(new Job("e", 15, 3));
		int maxDeadline = 3;
		printScheduledJobs(set, maxDeadline);
	}
	
	public static void printScheduledJobs(Set<Job> set, int maxDeadline){
		int count = 0;
		boolean[] slot = new boolean[Math.min(set.size(), maxDeadline)];
		for(Job j:set){	
			for(int i=Math.min(slot.length,j.deadline)-1; i>=0; i--){
				if(!slot[i]){
					System.out.println("Time : "+i+" "+j.toString());
					slot[i] = true;
					count++;
					break;
				}
			}
			if(count==slot.length){
				break;
			}
		}
	}
}
