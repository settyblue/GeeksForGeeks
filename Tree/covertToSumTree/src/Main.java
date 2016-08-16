/**
 * http://www.geeksforgeeks.org/convert-a-given-tree-to-sum-tree/
 * 
 * Given a Binary Tree where each node has positive and negative values. 
 * Convert this to a tree where each node contains the sum of the left and 
 * right sub trees in the original tree. The values of leaf nodes are changed to 0.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		Node<Integer> node = new Node<Integer>(10);
		BinaryTree<Integer> tree = new BinaryTree<Integer>(node);
		Node<Integer> node1 = new Node<Integer>(-2);
		Node<Integer> node2 = new Node<Integer>(6);
		
		node.left = node1;
		node.right = node2;
		node1.left = new Node<Integer>(8);
		node1.right = new Node<Integer>(-4);
		node2.left = new Node<Integer>(7);
		node2.right = new Node<Integer>(5);
		
		tree.printInOrder();
		toSumTree(tree.getRoot());
		tree.printInOrder();
	}
	
	@SuppressWarnings("unchecked")
	public static int toSumTree(Node node){
		if(node == null){
			return 0;
		}
		int temp = (int) node.getData();
		node.setData(toSumTree(node.getLeft())+toSumTree(node.getRight()));
		
		return temp+(int)node.getData();
	}
}
