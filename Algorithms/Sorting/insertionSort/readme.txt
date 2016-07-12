/**
 * http://quiz.geeksforgeeks.org/insertion-sort/
 * 
 */

 Solution:
 ---------
 Time Complexity: O(n*n)
 Auxiliary Space: O(1)
 Boundary Cases: Insertion sort takes maximum time to sort if elements are sorted in reverse order. And it takes minimum time (Order of n) when elements are already sorted.
 Algorithmic Paradigm: Incremental Approach
 Sorting In Place: Yes
 Stable: Yes
 Online: Yes
 Insertion sort is uses when number of elements is small. It can also be useful when input array is almost sorted, only few elements are misplaced in complete big array.
 
 We can use binary search to reduce the number of comparisons in normal insertion sort. Binary Insertion Sort find use binary search to find the proper location to insert the selected item at each iteration.