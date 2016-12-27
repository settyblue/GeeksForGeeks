/**
 * http://www.geeksforgeeks.org/wildcard-character-matching/
 * 
 * Given two strings where first string may contain wild card characters and 
 * second string is a normal string. Write a function that returns true if the two strings match. 
 * The following are allowed wild card characters in first string.
 * 
 *  * --> Matches with 0 or more instances of any character or set of characters.
 *  ? --> Matches with any one character.
 *  
 *  For example, “g*ks” matches with “geeks” match. And string “ge?ks*” matches with “geeksforgeeks”.
 *  But “g*k” doesn’t match with “gee” as character ‘k’ is not present in second string.
 *  
 */

 Solution:
 =========
 Important algo.
 Used recursion.
 Need to consider all the cases.