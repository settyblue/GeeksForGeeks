import java.util.ArrayList;
import java.util.Stack;
import static java.lang.Math.max;
//import static java.lang.Math.min;
/**
 * 
 */

/**
 * @author rakshith
 *
 */
public class BinaryTree<T> {
	public Node<T> root;
	
	BinaryTree(){
		this.root = null;
	}
	
	BinaryTree(Node<T> node){
		this.root = node;
	}
	
	public void printPostOrder(){
		if(this.root == null)return;
		printPostOrder(this.root);
		System.out.println();
	}
	
	public void printInOrder(){
		if(this.root == null)return;
		printInOrder(this.root);
		System.out.println();
	}
	
	public void printPreOrder(){
		if(this.root == null)return;
		printPreOrder(this.root);
		System.out.println();
	}
	
	public void printPostOrder(Node<T> node){
		if(node==null)return;
		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.print(node.data+"\t");
	}
	
	public void printInOrder(Node<T> node){
		if(node==null)return;
		printInOrder(node.left);
		System.out.print(node.data+"\t");
		printInOrder(node.right);
	}
	
	public void printPreOrder(Node<T> node){
		if(node==null)return;
		System.out.print(node.data+"\t");
		printPreOrder(node.left);
		printPreOrder(node.right);
	}
	
	public void printLevelOrder(){
		if(this.root == null)return;
		ArrayList<Node<T>> queue = new ArrayList<Node<T>>();
		queue.add(root);
		while(!queue.isEmpty()){
			System.out.print(queue.get(0).getData()+"\t");
			if(queue.get(0).getLeft() != null)queue.add(queue.get(0).getLeft());
			if(queue.get(0).getRight() != null)queue.add(queue.get(0).getRight());
			queue.remove(0);
		}
	}
	
	public void printLevelSpiralOrder(){
		Stack<Node<T>> stack1 = new Stack<Node<T>>();
		Stack<Node<T>> stack2 = new Stack<Node<T>>();
		stack1.push(this.root);
		while(!stack1.isEmpty() || !stack2.isEmpty()){
			while(!stack1.isEmpty()){
				Node<T> temp = stack1.pop();
				if(temp != null){
					stack2.push(temp.getLeft());
					stack2.push(temp.getRight());
					System.out.print(temp.getData()+"\t");
				}
			}
			System.out.println();
			while(!stack2.isEmpty()){
				Node<T> temp = stack2.pop();
				if(temp != null){
					stack1.push(temp.getRight());
					stack1.push(temp.getLeft());
					System.out.print(temp.getData()+"\t");
				}
			}
			System.out.println();
		}
	}
	
	public void printAllLeafPaths(){
		if(this.root == null)return;
		String s = "start";
		this.root.printAllLeafPaths(s);
	}
	
	public int size(){
		if(this.root == null)return 0;
		return size(root);
	}
	
	public int size(Node<T> node){
		if(node == null)return 0;
		return size(node.getLeft())+1+size(node.getRight());
	}
	
	public int depth(){
		if(this.root == null)return 0;
		return depth(this.root);
	}
	
	public int depth(Node<T> node){
		if(node== null)return 0;
		return 1+max(depth(node.getLeft()),depth(node.getRight()));
	}
	
	public int height(){
		return this.depth();
	}
	
	public int diameter(){
		if(this.root == null)return 0;
		return this.root.diameter();
	}
	
	public int diameterOptimized(){
		if(this.root == null)return 0;
		return this.root.diameterOptimized();
	}
	
	public Node<T> getRoot() {
		return root;
	}
	
	public boolean equals(BinaryTree<T> tree){
		if(this.root==null && tree.getRoot()==null)return true;
		if(this.root==null || tree.getRoot()==null)return false;
		return this.root.equals(tree.getRoot());
	}
	
	public void deleteTree(){
		if(this.root == null)return;
		this.root.deleteNode(this.root);
		this.root = null;
	}
	
	public void mirrorTree(){
		if(this.root == null) return;
		this.root.mirrorNode();
	}
	
	public int leafNodeCount(){
		if(this.root == null)return 0;
		return this.root.leafNodesCount();
	}
	
}
