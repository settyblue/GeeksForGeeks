/**
 * http://www.geeksforgeeks.org/transform-one-string-to-another-using-minimum-number-of-given-operation/
 * 
 * Given two strings A and B, the task is to convert A to B if possible. 
 * The only operation allowed is to put any character from A and insert it at front. 
 * Find if it’s possible to convert the string. If yes, then output minimum no. of 
 * operations required for transformation.
 * 
 * Input:  A = "EACBD", B = "EABCD"
 * Output: 3
 * Explanation: Pick B and insert at front, EACBD => BEACD
 *              Pick A and insert at front, BEACD => ABECD
 *              Pick E and insert at front, ABECD => EABCD
 */

Solution:
=========
Important and elegant algorithm.