import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeMap;

import static java.lang.Math.max;
//import static java.lang.Math.min;

/**
 * @author Rakshith Kunchum
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
	
	public void printVerticalSum(){
		if(!(this.root.data instanceof Integer)){
			System.out.println("vertical sum can be called only for tree of type Integer.");
			return;
		}
		TreeMap<Integer,Integer> sumMap = new TreeMap<>();
		computeVerticalSum(this.root,sumMap,0);
		for(int i:sumMap.keySet()){
			System.out.print(sumMap.get(i)+" ");
		}
	}

	private void computeVerticalSum(Node<T> node, TreeMap<Integer, Integer> sumMap, int verticalIndex) {
		if(node == null){
			return;
		}
		
		if(sumMap.containsKey(verticalIndex)){
			sumMap.put(verticalIndex, sumMap.get(verticalIndex)+(Integer)node.getData());
		}else{
			sumMap.put(verticalIndex, (Integer)node.getData());
		}
		
		computeVerticalSum(node.left, sumMap, verticalIndex-1);
		computeVerticalSum(node.right, sumMap, verticalIndex+1);
	}
	
}
