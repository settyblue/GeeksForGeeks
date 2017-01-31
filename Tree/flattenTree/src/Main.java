/**
 * 
 */

/**
 * @author rakshith
 *
 */
public class Main {

	/**
	 * @param args
	 */
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
		node1.right.right = new Node<Integer>(80);
		node2.left.left = new Node<Integer>(90);
		
		tree.printInOrder();
		flattenTree(tree);
		tree.printInOrder();
		
		
	}
	
	public static <T> void flattenTree(BinaryTree<T> tree){
		if(tree.getRoot() != null){
			flattenNode(tree.getRoot());
		}
	}
	
	public static <T> void flattenNode(Node<T> node){
		if(node == null || node.getLeft() == null){
			return;
		}else{
			flattenNode(node.getRight());
			flattenNode(node.getLeft());
			Node<T> temp = node.getLeft();
			while(temp.getRight() != null){
				temp = temp.getRight();
			}
			temp.setRight(node.getRight());
			node.setRight(node.getLeft());
			node.setLeft(null);
		}
	}
}
