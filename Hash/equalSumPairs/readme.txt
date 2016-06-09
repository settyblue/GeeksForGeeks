/**
 * http://www.geeksforgeeks.org/find-four-elements-a-b-c-and-d-in-an-array-such-that-ab-cd/
 * 
 * Find four elements a, b, c and d in an array such that a+b = c+d
 * Given an array of distinct integers, find if there are two pairs (a, b) and (c, d) 
 * such that a+b = c+d, and a, b, c and d are distinct elements. 
 * If there are multiple answers, then print any of them.
 * 
 * Example:
 * Input:   {3, 4, 7, 1, 2, 9, 8}
 * Output:  (3, 8) and (4, 7)
 * Explanation: 3+8 = 4+7
 */

Solution:
---------
Implemented using Hashmap.
Time Complexity = O(n^2)