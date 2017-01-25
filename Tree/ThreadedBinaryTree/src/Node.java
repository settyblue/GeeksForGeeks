/**
 * @author Rakshith Kunchum
 *
 */

public class Node <T> {
	public T data;
	public Node<T> left = null;
	public Node<T> right = null;
	public Node<T> next = null;
	
	Node(){}
	
	Node(T data){
		this.data = data;
	}
	
	public void printInOrder(){
		if(this.getLeft() != null)this.getLeft().printInOrder();
		System.out.print(this.getData()+"\t");
		if(this.getRight() != null)this.getRight().printInOrder();
	}
	
	public void printPreOrder(){
		System.out.print(this.getData()+"\t");
		if(this.getLeft() != null)this.getLeft().printPreOrder();
		if(this.getRight() != null)this.getRight().printPreOrder();
	}
	
	public void printPostOrder(){
		if(this.getLeft() != null)this.getLeft().printPostOrder();
		if(this.getRight() != null)this.getRight().printPostOrder();
		System.out.print(this.getData()+"\t");
	}
	
	public void printWithNextPointer() {
		System.out.print(this.getData()+"\t");
		if(this.getNext() != null) this.getNext().printWithNextPointer();
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public Node<T> getLeft() {
		return left;
	}
	
	public void setLeft(Node<T> left) {
		this.left = left;
	}
	
	public Node<T> getRight() {
		return right;
	}
	
	public void setRight(Node<T> right) {
		this.right = right;
	}
	
	public Node<T> getNext() {
		return next;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}

}
