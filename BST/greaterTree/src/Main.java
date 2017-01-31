/**
 * http://www.geeksforgeeks.org/add-greater-values-every-node-given-bst/
 * 
 * Given a Binary Search Tree (BST), modify it so that all greater values in 
 * the given BST are added to every node. 
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		BSTree<Integer> bst = new BSTree<Integer>();
		populateTree(bst);
		System.out.println(bst.toString());
		System.out.println(bst.treeOrder());
		tranformtoGreaterTree(bst);
		System.out.println(bst.toString());
		System.out.println(bst.treeOrder());
	}
	
	private static void tranformtoGreaterTree(BSTree<Integer> bst) {
		if(bst.getRoot() == null){
			return;
		}else{
			tranform(bst.getRoot(), 0);
		}
	}

	private static int tranform(BSTNode<Integer> node, int sumSoFar) {
		if(node == null){
			return sumSoFar;
		}else{
			int value = tranform(node.getRight(), sumSoFar);
			node.setKey(node.getKey()+value);
			return tranform(node.getLeft(),node.getKey());
		}
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
}
