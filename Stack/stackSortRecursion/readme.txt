/**
 * http://www.geeksforgeeks.org/sort-a-stack-using-recursion/
 * 
 * Sort a stack using recursion
 * Given a stack, sort it using recursion. 
 * 
 * Similar to stack reverse recursive. -> http://www.geeksforgeeks.org/reverse-a-stack-using-recursion/
 */

 Solution:
 ---------
 first cache the top stack element,
 sort the remaining stack using recursion,
 Then sort the stack after adding the cached element.