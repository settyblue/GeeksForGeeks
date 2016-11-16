import java.lang.Math;
import java.util.Arrays;

/**
 * @author Rakshith Kunchum
 *
 */

public class SegmentTree {
	
	private int[] treeArray;
	private treetype type;
	
	public SegmentTree(int[] input, int n) {
		int depth = (int)Math.ceil(Math.log(n)/Math.log(2));
		int treeSize = 2*((int)Math.pow(2.0, depth)) - 1;
		
		this.treeArray = new int[treeSize];
		this.type = treetype.SUM;
		recursiveConstructTree(input, 0, n-1, 0);
	}
	
	public SegmentTree(int[] input, int n, treetype segTreeType) {
		int depth = (int)Math.ceil(Math.log(n)/Math.log(2));
		int treeSize = 2*((int)Math.pow(2.0, depth)) - 1;
		
		treeArray = new int[treeSize];
		this.type = segTreeType;
		recursiveConstructTree(input, 0, n-1, 0);
	}
	
	private int recursiveConstructTree(int[] input, int startIndex, int endIndex, int curIndex) {
		if(startIndex == endIndex){
			this.treeArray[curIndex] = input[startIndex];
			return input[startIndex];
		}
		int midIndex = getMidIndex(startIndex, endIndex);
		if(this.type == treetype.SUM){
			this.treeArray[curIndex] = recursiveConstructTree(input, startIndex, midIndex, 2*curIndex+1) +
					recursiveConstructTree(input, midIndex+1, endIndex, 2*curIndex+2);
		}else if(this.type == treetype.MIN_VALUE){
			this.treeArray[curIndex] = Math.min(recursiveConstructTree(input, startIndex, midIndex, 2*curIndex+1),
					recursiveConstructTree(input, midIndex+1, endIndex, 2*curIndex+2));
		}else if(this.type == treetype.MAX_VALUE){
			this.treeArray[curIndex] = Math.max(recursiveConstructTree(input, startIndex, midIndex, 2*curIndex+1),
					recursiveConstructTree(input, midIndex+1, endIndex, 2*curIndex+2));
		}
		
		return treeArray[curIndex];
	}

	private int getMidIndex(int startIndex, int endIndex) {
		return (startIndex + (endIndex-startIndex)/2);
	}

	public int getSum(int n, int fromIndex, int toIndex) {
		
		if(this.type != treetype.SUM){
			System.out.println("Function call doesn't match tree type.");
			return -1;
		}
		
		if(fromIndex < 0 || toIndex > (n-1) || toIndex < fromIndex ){
			System.out.println("Invalid input.");
			return -1;
		}
		
		return getSumRecursive(0,n-1,fromIndex,toIndex,0);
	}

	private int getSumRecursive(int curStartIndex, int curEndIndex, int queryStartIndex, int queryEndIndex, int curIndex) {
		
		if(curStartIndex >= queryStartIndex && curEndIndex <= queryEndIndex){
			return this.treeArray[curIndex];
		}
		
		if(curStartIndex > queryEndIndex || curEndIndex < queryStartIndex){
			return 0;
		}
		
		int midIndex = this.getMidIndex(curStartIndex, curEndIndex);
		return getSumRecursive(curStartIndex,midIndex,queryStartIndex,queryEndIndex,2*curIndex+1) +
				getSumRecursive(midIndex + 1,curEndIndex,queryStartIndex,queryEndIndex,2*curIndex+2);
	}

	public int getMin(int n, int fromIndex, int toIndex) {
		
		if(this.type != treetype.MIN_VALUE){
			System.out.println("Function call doesn't match tree type.");
			return -1;
		}
		
		if(fromIndex < 0 || toIndex > (n-1) || toIndex < fromIndex ){
			System.out.println("Invalid input.");
			return -1;
		}
		
		return getMinRecursive(0,n-1,fromIndex,toIndex,0);
	}
	
	private int getMinRecursive(int curStartIndex, int curEndIndex, int queryStartIndex, int queryEndIndex, int curIndex) {
		
		if(curStartIndex >= queryStartIndex && curEndIndex <= queryEndIndex){
			return this.treeArray[curIndex];
		}
		
		if(curStartIndex > queryEndIndex || curEndIndex < queryStartIndex){
			return Integer.MAX_VALUE;
		}
		
		int midIndex = this.getMidIndex(curStartIndex, curEndIndex);
		return Math.min(getMinRecursive(curStartIndex,midIndex,queryStartIndex,queryEndIndex,2*curIndex+1),
						getMinRecursive(midIndex + 1,curEndIndex,queryStartIndex,queryEndIndex,2*curIndex+2));
	}

	public void updateValue(int[] input, int n, int pos, int newVal) {
		
		if(pos < 0 || pos >= n){
			System.out.println("Invalid input.");
			return;
		}
		
		if(this.type == treetype.SUM){
			int diff = newVal - input[pos];
			input[pos] = newVal;
			updateSumTreeRecursive(0,n-1,pos,diff,0);
		}
		
		if(this.type == treetype.MIN_VALUE){
			input[pos] = newVal;
			updateMinTreeRecursive(0,n-1,pos,newVal,0);
		}
	}
	
	private void updateSumTreeRecursive(int startIndex, int endIndex, int pos, int diff, int curIndex) {
		
		if(pos < startIndex || pos > endIndex){
			return;
		}
		
		this.treeArray[curIndex] += diff;
		if(startIndex != endIndex){
			int midIndex = this.getMidIndex(startIndex, endIndex);
			this.updateSumTreeRecursive(startIndex, midIndex, pos, diff, 2*curIndex+1);
			this.updateSumTreeRecursive(midIndex+1, endIndex, pos, diff, 2*curIndex+2);
		}
	}
	
	private void updateMinTreeRecursive(int startIndex, int endIndex, int pos, int newVal, int curIndex) {
		
		if(pos < startIndex || pos > endIndex){
			return;
		}
		
		this.treeArray[curIndex] = Math.min(this.treeArray[curIndex],newVal);
		
		if(startIndex != endIndex){
			int midIndex = this.getMidIndex(startIndex, endIndex);
			this.updateMinTreeRecursive(startIndex, midIndex, pos, newVal, 2*curIndex+1);
			this.updateMinTreeRecursive(midIndex+1, endIndex, pos, newVal, 2*curIndex+2);
		}else{
			this.treeArray[curIndex] = newVal;
		}
	}	
	

	public String toString(){
		return Arrays.toString(this.treeArray);
	}
	
	
	public static enum treetype{
		SUM,
		MIN_VALUE,
		MAX_VALUE;
	}
}
