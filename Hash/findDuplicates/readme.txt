/**
 * http://www.geeksforgeeks.org/check-given-array-contains-duplicate-elements-within-k-distance/
 * Check if a given array contains duplicate elements within k distance from each other.
 * Given an unsorted array that may contain duplicates. Also given a number k which is smaller 
 * than size of array. Write a function that returns true if array contains duplicates within k distance.
 * 
 * Input: k = 3, arr[] = {1, 2, 3, 4, 1, 2, 3, 4}
 * Output: false
 * All duplicates are more than k distance away.
 * 
 * Input: k = 3, arr[] = {1, 2, 3, 1, 4, 5}
 * Output: true
 * 1 is repeated at distance 3.
 */

 Solution:
 ---------
 Implemented using hashmap.
 Time Complexity = O(n)