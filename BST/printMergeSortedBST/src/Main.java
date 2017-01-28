import java.util.Stack;

/**
 * http://www.geeksforgeeks.org/merge-two-bsts-with-limited-extra-space/
 * 
 * Given two Binary Search Trees(BST), print the elements of both BSTs in sorted form. 
 * The expected time complexity is O(m+n) where m is the number of nodes in first tree 
 * and n is the number of nodes in second tree. 
 * Maximum allowed auxiliary space is O(height of the first tree + height of the second tree).
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		BSTree<Integer> bst1 = new BSTree<Integer>();
		BSTree<Integer> bst2 = new BSTree<Integer>();
		populateTree1(bst1);
		populateTree2(bst2);
		printMergSorted(bst1, bst2);
	}

	private static void printMergSorted(BSTree<Integer> bst1, BSTree<Integer> bst2) {
		BSTNode<Integer> front1,front2,prev;
		Stack<BSTNode<Integer>> stack1, stack2;
		stack1 = new Stack<>();stack2 = new Stack<>();
		prev = bst1.getRoot();
		while(prev!=null){
			stack1.push(prev);
			prev = prev.getLeft();
		}
		prev = bst2.getRoot();
		while(prev!=null){
			stack2.push(prev);
			prev = prev.getLeft();
		}
		
		front1 = stack1.pop();front2 = stack2.pop();
		boolean done1 = true,done2 = true;
		
		while(!stack1.isEmpty() && !stack2.isEmpty()){
			if(!done1){
				front1 = stack1.pop();
				prev = front1.getRight();
				while(prev != null){
					stack1.push(prev);
					prev = prev.getLeft();
				}
				done1 = true;
			}
			
			if(!done2){
				front2 = stack2.pop();
				prev = front2.getRight();
				while(prev != null){
					stack2.push(prev);
					prev = prev.getLeft();
				}
				done2 = true;
			}
			
			if(front1.getKey() < front2.getKey()){
				System.out.print(front1.getKey()+" ");
				done1 = false;
			}else if(front1.getKey() > front2.getKey()){
				System.out.print(front2.getKey()+" ");
				done2 = false;
			}else{
				System.out.print(front2.getKey()+" ");
				done1 = false;done2 = false;
			}
		}
		
		while(!stack1.isEmpty()){
			front1 = stack1.pop();
			System.out.print(front1.getKey()+" ");
			prev = front1.getRight();
			while(prev != null){
				stack1.push(prev);
				prev = prev.getLeft();
			}
		}
		
		while(!stack2.isEmpty()){
			front1 = stack2.pop();
			System.out.print(front2.getKey()+" ");
			prev = front2.getRight();
			while(prev != null){
				stack2.push(prev);
				prev = prev.getLeft();
			}
		}
	}

	private static void populateTree1(BSTree<Integer> bst) {
		int[] array = {8, 3, 6, 1, 4, 7, 10, 14, 13};
		for(Integer i:array){
			bst.insert(i);
		}
	}
	
	private static void populateTree2(BSTree<Integer> bst) {
		int[] array = {5, 3, 2, 1};
		for(Integer i:array){
			bst.insert(i);
		}
	}
	
	
}
