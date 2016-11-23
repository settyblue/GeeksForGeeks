/**
 * 
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		Node<Integer> node = new Node<Integer>(10);
		BinaryTree<Integer> tree = new BinaryTree<Integer>(node);
		Node<Integer> node1 = new Node<Integer>(20);
		Node<Integer> node2 = new Node<Integer>(30);
		node.left = node1;
		node.right = node2;
		
		node1.left = new Node<Integer>(40);
		node1.right = new Node<Integer>(50);
		node2.left = new Node<Integer>(60);
		node2.right = new Node<Integer>(70);
		
		tree.printLevelOrder();
		System.out.println("\nsize of tree = "+tree.size());
		System.out.println("depth of tree = "+tree.depth());
		System.out.println("size of node = "+node2.size());
		System.out.println("depth of node = "+node2.depth());
		System.out.println("diameter of tree = "+tree.diameter());
		System.out.println("diameter of node = "+node2.diameter());
		tree.printAllLeafPaths();
		System.out.println("Number of leaf nodes = "+tree.leafNodeCount());
		//tree.root.printNodeAtKDistance(1);
		tree.printVerticalSum();
	}

}
