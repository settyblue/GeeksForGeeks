/**
 * @author Rakshith Kunchum
 *
 */

/**
 * 
 */
public class ThreadedBinaryTree <T> {
	public Node<T> root;
	
	ThreadedBinaryTree(Node<T> root){
		this.root = root;
	}
	
	public void populateNextPointer(){
		if(this.getRoot() == null){
			return;
		}
		populateNextPointer(this.getRoot(), null);
	}

	private Node<T> populateNextPointer(Node<T> node, Node<T> next){
		if(node != null){
			next = populateNextPointer(node.getRight(), next);
			node.setNext(next);
			next = node;
			next = populateNextPointer(node.getLeft(), next);
		}
		return next;
	}
	
	public void printPostOrder(){
		if(this.root == null)return;
		this.root.printPostOrder();
		System.out.println();
	}
	
	public void printInOrder(){
		if(this.root == null)return;
		this.getRoot().printInOrder();
		System.out.println();
	}
	
	public void printPreOrder(){
		if(this.root == null)return;
		this.root.printPreOrder();
		System.out.println();
	}
	
	public void printWithNextPointer(){
		if(this.root == null)return;
		this.root.printWithNextPointer();
		System.out.println();
	}
	
	private Node<T> getRoot() {
		return this.root;
	}
}
