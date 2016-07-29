import java.util.Comparator;
import java.util.TreeSet;
/**
 * http://www.geeksforgeeks.org/greedy-algorithms-set-1-activity-selection-problem/
 * 
 * You are given n activities with their start and finish times. 
 * Select the maximum number of activities that can be performed by a single person, 
 * assuming that a person can only work on a single activity at a time.
 */

/**
 * @author rakshith
 *
 */
public class Main {
	
	public static class Interval implements Comparable<Interval>{
		int start, end;
		
		Interval(int s,int e){
			this.start = s;
			this.end = e;
		}
		
		public int compareTo(Interval i){
			if(this.end != i.end){
				return this.end - i.end;
			}else{
				return this.start - i.start;
			}
			
		}
		
		public static Comparator<Interval> compareByStartTime = new Comparator<Interval>(){
			
			public int compare(Interval i1, Interval i2){
				return i1.start - i2.start;
			}
		};
		
		public String toString(){
			return "("+this.start+", "+this.end+")";
		}
	}
	
	public static void main(String[] args) {
		TreeSet<Interval> set = new TreeSet<Interval>();
		//TreeSet<Interval> set = new TreeSet<Interval>(Interval.compareByStartTime);
		set.add(new Interval(3,4));
		set.add(new Interval(1,2));
		set.add(new Interval(5,7));
		set.add(new Interval(8,9));
		set.add(new Interval(5,9));
		set.add(new Interval(0,6));
		
		System.out.println(set);
		
		printSelectedActivity(set);
	}
	
	public static void printSelectedActivity(TreeSet<Interval> set){
		
		TreeSet<Interval> answer = new TreeSet<Interval>();
		int i=0;
		int prevFinishTime = 0;
		for(Interval I:set){
			if(i==0){
				//System.out.println(I.toString());
				answer.add(I);
				prevFinishTime = I.end;
				i++;
				continue;
			}
			
			if(I.start>=prevFinishTime){
				//System.out.println(I.toString());
				answer.add(I);
				prevFinishTime = I.end;
				continue;
			}
		}
		
		System.out.println(answer.toString());
	}
}
