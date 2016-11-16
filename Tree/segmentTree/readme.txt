/**
 * http://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/
 * http://www.geeksforgeeks.org/segment-tree-set-1-range-minimum-query/
 * 
 * We have an array arr[0 . . . n-1]. We should be able to
 * 
 * 1. Find the sum of elements from index l to r where 0 <= l <= r <= n-1
 * 2. Change value of a specified element of the array to a new value x. We need to do arr[i] = x where 0 <= i <= n-1
 */

 Segmented tree makes preprocessing time O(n) and query time O(log n)
 Right now only static arrays supported. not dynamic arrays. we can have dynamic arrays.