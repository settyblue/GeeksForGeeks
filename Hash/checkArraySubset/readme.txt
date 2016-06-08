/**
 * http://www.geeksforgeeks.org/find-whether-an-array-is-subset-of-another-array-set-1/
 * Find whether an array is subset of another array | Added Method 3
 * Given two arrays: arr1[0..m-1] and arr2[0..n-1]. 
 * Find whether arr2[] is a subset of arr1[] or not. Both the arrays are not in sorted order. 
 * It may be assumed that elements in both array are distinct.
 */

 Solution 1:
 -----------
 Implemented using Hashset.
 Time Complexity = O(m+n)
 Drawback of this method is that it doesnt account if the array has repeated elements.

 Solution 2:
 -----------
 Implemented using sorting to overcome the previous drawback.