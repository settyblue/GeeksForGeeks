/**
 * Find even occurring elements in an array of limited range
 * Given an array that contains odd number of occurrences for 
 * all numbers except for a few elements which are present 
 * even number of times. Find the elements which have even 
 * occurrences in the array in O(n) time complexity and O(1) 
 * extra space.
 * 
 * Assume array contain elements in the range 0 to 63.
 * 
 * Input: [9, 12, 23, 10, 12, 12, 15, 23, 14, 12, 15]
 * Output: 12, 23 and 15
 * 
 */

 Solution:
 ---------
 Implemented using xor operator.