import java.util.Stack;

/**
 * http://www.geeksforgeeks.org/find-a-pair-with-given-sum-in-bst/
 * 
 * Given a Balanced Binary Search Tree and a target sum, write a function 
 * that returns true if there is a pair with sum equals to target sum, 
 * otherwise return false. Expected time complexity is O(n) and only O(Logn) 
 * extra space can be used. Any modification to Binary Search Tree is not allowed. 
 * Note that height of a Balanced BST is always O(Logn).
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		BSTree<Integer> bst = new BSTree<Integer>();
		populateTree(bst);
		//bst.insert(10);bst.insert(40);bst.insert(0);
		//bst.insert(5);bst.insert(20);bst.insert(100);
		System.out.println(bst.toString());
		System.out.println(bst.treeOrder());
		
		int sum = 27;
		printPairWithSum(bst,sum);
	}
	
	/*
	 *             8
	 *	         /    \
	 *	       3       10
	 *	     /  \        \
	 *	    1     6       14
	 *	        /   \     /
	 *	       4     7   13  
	 */
	private static void populateTree(BSTree<Integer> bst) {
		int[] array = {8, 3, 6, 1, 4, 7, 10, 14, 13};
		for(Integer i:array){
			bst.insert(i);
		}
	}

	private static void printPairWithSum(BSTree<Integer> bst, int sum) {
		BSTNode<Integer> prev = bst.getRoot(), front = bst.getRoot(),back = bst.getRoot();
		Stack<BSTNode<Integer>> forward, backward;
		forward = new Stack<>();backward = new Stack<>();
		
		while(prev != null){
			forward.push(prev);
			prev = prev.getLeft();
		}
		front = forward.pop();
		
		prev = bst.getRoot();
		while(prev !=null){
			backward.push(prev);
			prev = prev.getRight();
		}
		back = backward.pop();
		
		boolean fdone = true,bdone = true;
		while(front.getKey()<back.getKey()){
			if(!fdone){
				front = forward.pop();
				prev = front.getRight();
				while(prev != null){
					forward.push(prev);
					prev = prev.getLeft();
				}
				fdone = true;
			}
			
			if(!bdone){
				back = backward.pop();
				prev = back.getLeft();
				while(prev != null){
					backward.push(prev);
					prev = prev.getRight();
				}
				bdone = true;
			}
			
			int curSum = front.getKey()+back.getKey();
			if(curSum == sum){
				System.out.println("elements are "+front.getKey()+" "+back.getKey());
				return;
			}else if(curSum < sum){
				fdone = false;
			}else{
				bdone = false;
			}
		}
	}

}
