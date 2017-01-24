/**
 * @author Rakshith Kunchum
 *
 */

/**
 * 
 */
public class Main {

	public static void main(String[] args) {
		Node<Integer> node = new Node<Integer>(10);
		ThreadedBinaryTree<Integer> tree = new ThreadedBinaryTree<Integer>(node);
		Node<Integer> node1 = new Node<Integer>(20);
		Node<Integer> node2 = new Node<Integer>(30);
		node.left = node1;
		node.right = node2;
		
		node1.left = new Node<Integer>(40);
		node1.right = new Node<Integer>(50);
		node2.left = new Node<Integer>(60);
		node2.right = new Node<Integer>(70);
		
		tree.printInOrder();
		tree.populateNextPointer();
		tree.printWithNextPointer();
		node1.left.printWithNextPointer();
	}

}
