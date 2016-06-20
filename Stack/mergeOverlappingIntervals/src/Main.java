import java.util.Stack;
import java.util.TreeSet;
/**
 * http://www.geeksforgeeks.org/merging-intervals/
 * 
 * Merge Overlapping Intervals
 * Given a set of time intervals in any order, merge all overlapping intervals into one 
 * and output the result which should have only mutually exclusive intervals. 
 * Let the intervals be represented as pairs of integers for simplicity. 
 * 
 * For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8} }. 
 * The intervals {1,3} and {2,4} overlap with each other, so they should be merged 
 * and become {1, 4}. Similarly {5, 7} and {6, 8} should be merged and become {5, 8}
 */

/**
 * @author rakshith
 *
 */
public class Main {
	
	public static class Interval implements Comparable<Interval>{
		int start,end;
		
		Interval(int start, int end){
			this.start = start;
			this.end = end;
		}
		
		public int compareTo(Interval a){
			return a.start - this.start;
		}
		
		public String toString(){
			return "("+this.start+", "+this.end+")";
		}
	}
	
	public static void main(String[] args) {
		TreeSet<Interval> set = new TreeSet<Interval>();
		set.add(new Interval(6,8));
		set.add(new Interval(1,1));
		set.add(new Interval(2,4));
		set.add(new Interval(4,5));
		
		System.out.println(set.toString());
		mergeIntervals(set);
		System.out.println(set.toString());
	}
	
	public static void mergeIntervals(TreeSet<Interval> set){
		Stack<Interval> stack = new Stack<Interval>();
		for(Interval interval:set){
			stack.add(interval);
		}
		set.removeAll(set);
		Interval currentInterval = stack.pop();
		while(!stack.isEmpty()){
			Interval top = stack.peek();
			if(currentInterval.end >= top.start){
				stack.pop();
				int newEnd = top.end;
				currentInterval = new Interval(currentInterval.start, Math.max(currentInterval.end, newEnd));
			}else{
				set.add(currentInterval);
				currentInterval = stack.pop();
			}
		}
		set.add(currentInterval);
	}
}
