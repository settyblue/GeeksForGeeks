/**
 * http://www.geeksforgeeks.org/check-if-an-array-can-be-divided-into-pairs-whose-sum-is-divisible-by-k/
 * 
 * Check if an array can be divided into pairs whose sum is divisible by k
 * Given an array of integers and a number k, write a function 
 * that returns true if given array can be divided into pairs such 
 * that sum of every pair is divisible by k.
 * Input: arr[] = {92, 75, 65, 48, 45, 35}, k = 10
 * Output: True
 * We can divide array into (92, 48), (75, 65) and 
 * (45, 35). Sum of all these pairs is a multiple of 10.
 * 
 */

 Solution:
 ---------
 Implemented using single scan.
 Time Complexity = O(n)
 Space Complexity = O(k)