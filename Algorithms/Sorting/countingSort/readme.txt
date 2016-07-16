/**
 * http://www.geeksforgeeks.org/counting-sort/
 * http://pages.cs.wisc.edu/~paton/readings/Old/fall08/LINEAR-SORTS.html
 * 
 */

 Counting sort is a sorting technique based on keys between a specific range. It works by counting the number of objects having distinct key values (kind of hashing). Then doing some arithmetic to calculate the position of each object in the output sequence.

 Time Complexity = O(n+k)
 Space Complexity = O(n+k)

 Points to be noted:
 	1. Counting sort is efficient if the range of numbers is not significantly greater than the number of integers in the input array.
 	2. It is not comparision based sorting.
 	3. It is often used as a sub-routine to other sorting algorithms such as radix-sorting.
 	4. Counting sort can also be extended to negative inputs.
