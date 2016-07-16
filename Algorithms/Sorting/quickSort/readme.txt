/**
 * http://quiz.geeksforgeeks.org/quick-sort/
 * 
 */

 Avg Time Complexity = O(nlogn)
 Best Time Complexity = O(nlogn)
 Worst Time Complexity = O(n^2)

 3-Way QuickSort - used for array having redundant elements.
 In 3 Way QuickSort, an array arr[l..r] is divided in 3 parts:
	a) arr[l..i] elements less than pivot.
	b) arr[i+1..j-1] elements equal to pivot.
	c) arr[j..r] elements greater than pivot.

 Not a stable sorting algorithm in typical implementation.

 When first element or last element is chosen as pivot, Quick Sort's worst case occurs for the sorted arrays. In every step of quick sort, numbers are divided as per the following recurrence. T(n) = T(n-1) + O(n)

 Now consider a QuickSort implementation where we first find median using O(n) algorithm, then use median as pivot. The worst case time complexity of this modified QuickSort is O(nlogn).

 * Randomly picking up to make worst case less likely to occur.
 * Calling insertion sort for small sized arrays to reduce recursive calls.
 * QuickSort is tail recursive, so tail call optimizations can be done.

 Quick-sort is better for large arrays as compared to merge-sort since it does inplace sorting.
 Insertion sort is better if the array is nearly sorted.