/**
 * http://quiz.geeksforgeeks.org/merge-sort/
 * 
 * Merge Sort
 */

 Solution:
 ---------
 Time Complexity: Sorting arrays on different machines. Merge Sort is a recursive algorithm and time complexity can be expressed as following recurrence relation.
 T(n) = 2T(n/2) + \Theta(n)
 The above recurrence can be solved either using Recurrence Tree method or Master method. It falls in case II of Master Method and solution of the recurrence is \Theta(nLogn).
 Time complexity of Merge Sort is \Theta(nLogn) in all 3 cases (worst, average and best) as merge sort always divides the array in two halves and take linear time to merge two halves.
 Auxiliary Space: O(n)
 Algorithmic Paradigm: Divide and Conquer
 Sorting In Place: No in a typical implementation
 Stable: Yes

 Aplications:
 1. Merge sort is good in sorting linked lists.
 2. Used in Count inversion problem.
 3. External Sorting.
