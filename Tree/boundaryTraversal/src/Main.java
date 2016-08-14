/**
 * http://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
 * http://articles.leetcode.com/print-edge-nodes-boundary-of-binary/
 * Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise starting from the root.
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
		node1.right.right = new Node<Integer>(80);
		node1.right.left = new Node<Integer>(100);
		node2.left.left = new Node<Integer>(90);
		
		tree.printInOrder();
		printBoundaryTraversal(tree);
	}
	
	public static <T> void printBoundaryTraversal(BinaryTree<T> tree){
		if(tree.getRoot() == null)return;
		//System.out.print(tree.getRoot().getData()+"\t");
		printLeftBoundary(tree.getRoot());
		printleafNodes(tree.root.getLeft());
		printleafNodes(tree.root.getRight());
		printRightBoundary(tree.getRoot());
	}
	
	public static <T> void printLeftBoundary(Node<T> node){
		if(node != null){
			if(node.getLeft() != null){
				System.out.print(node.getData()+"\t");
				printLeftBoundary(node.getLeft());
			}else if (node.getRight() != null){
				System.out.print(node.getData()+"\t");
				printLeftBoundary(node.getRight());
			}
		}
	}
	
	public static <T> void printleafNodes(Node<T> node){
		if(node != null){
			printleafNodes(node.getLeft());
			if(node.getLeft() == null && node.getRight() == null){
				System.out.print(node.getData()+"\t");
			}
			printleafNodes(node.getRight());
		}
	}
	
	public static <T> void printRightBoundary(Node<T> node){
		if(node != null){
			if(node.getRight() != null){
				printRightBoundary(node.getRight());
				System.out.print(node.getData()+"\t");
			}else if(node.getLeft() != null){
				printRightBoundary(node.getLeft());
				System.out.print(node.getData()+"\t");
			}
		}
	}
}
