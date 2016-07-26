/**
 * http://www.geeksforgeeks.org/comb-sort/
 * Improvement over bubble sort
 */

 Solution:
 ---------
 It is an improved version of bubble sort.
 Instead of comparing elements within distance of 1 we do it within distance of 'gap'.
 'gap' start from array.length and reduces to 1 by a geometric factor of 1.3.
