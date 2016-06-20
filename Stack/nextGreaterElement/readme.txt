/**
 * http://www.geeksforgeeks.org/next-greater-element/
 * 
 * Similar problem -> http://www.geeksforgeeks.org/the-stock-span-problem/
 * Given an array, print the Next Greater Element (NGE) 
 * for every element. The Next greater Element for an element x 
 * is the first greater element on the right side of x in array. 
 * Elements for which no greater element exist, consider next greater element as -1.
 */

 Solution 1:
 -----------
 Implemented using stack.
 Complicated algorithm. Read it again.
 Prints out of order. But prints correctly.
 Time Complexity = O(n)  <-- very impressive!!
 Space Complexity = O(n) <-- (stack space)

 Solution 2:
 -----------
 Implemented using stack.
 prints in order.
 Time Complexity = O(n)
 Space Complexity = O(n) (stack) + O(n) (auxiliary array)