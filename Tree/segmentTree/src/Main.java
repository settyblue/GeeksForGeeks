/**
 * http://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/
 * http://www.geeksforgeeks.org/segment-tree-set-1-range-minimum-query/
 * 
 * We have an array arr[0 . . . n-1]. We should be able to
 * 
 * 1. Find the sum of elements from index l to r where 0 <= l <= r <= n-1
 * 2. Change value of a specified element of the array to a new value x. We need to do arr[i] = x where 0 <= i <= n-1
 */

/**
 * @author Rakshith Kunchum
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] input = {2,5,1,4,9,3};
        int n = input.length;
        
        // Build segment tree from given array
        SegmentTree  tree = new SegmentTree(input, n, SegmentTree.treetype.MIN_VALUE);
        System.out.println(tree);
        // Print sum of values in array from index 1 to 3
        //System.out.println("Sum of values in given range = " + tree.getSum(n, 1, 3));
        //System.out.println("Sum of values in given range = " + tree.getSum(n, 0, 3));
        // Update: set input[1] = 10 and update corresponding segment
        // tree nodes
        System.out.println("min value in the given range = " + tree.getMin(n, 0, 3));
        System.out.println("min value in the given range = " + tree.getMin(n, 0, 1));
        tree.updateValue(input, n, 1, 0);
        System.out.println("min value in the given range = " + tree.getMin(n, 0, 3));
        System.out.println("min value in the given range = " + tree.getMin(n, 0, 1));
        System.out.println(tree);
        // Find sum after the value is updated
        //System.out.println("Updated sum of values in given range = " + tree.getSum(n, 1, 3));
	}

}
