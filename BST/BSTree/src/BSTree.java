import java.util.ArrayList;

/**
 * 
 */

/**
 * @author rakshith
 *
 */
public class BSTree <K extends Comparable<? super K>> {

	private BSTNode <K> root;
	
	//Constructors.
	public BSTree() {
		this.root = null;
	}
	
	public BSTree(BSTNode <K> node) {
		this.root = node;
	}
	
	//Getters and setters
	public BSTNode<K> getRoot(){
		return this.root;
	}
	
	public void setRoot(BSTNode<K> node){
		this.root = node;
	}
	
	//Tree Methods.
	public boolean lookup(K key) {
	    return lookup(this.root, key);
	}
	
	public void insert(K key) {
	    this.root = insert(this.root, key);
	}
	
	public void delete(K key){
		this.root = delete(this.root, key);
	}
	
	public K getMin(){
		if(this.root == null){
			return null;
		}else{
			return smallest(this.root);
		}
	}
	
	public K getMax(){
		if(this.root == null){
			return null;
		}else{
			return largest(this.root);
		}
	}
	
	public K ceil(K key){
		if(this.root == null){
			return null;
		}else{
			return ceil(this.root,key);
		}
	}
	
	public K floor(K key){
		if(this.root == null){
			return null;
		}else{
			return floor(this.root,key);
		}
	}
	
	public K inOrderSuccessor(K key){
		if(this.root == null){
			return null;
		}else{
			return inOrderSuccessor(this.root, key);
		}
	}
	
	public ArrayList<K> toList() {
		ArrayList<K> inOrderList = new ArrayList<K>();
		populateInOrderList(this.root, inOrderList);
		return inOrderList;
	}
	
	public void printKeysInRange(K key1,K key2){
		if(this.root == null){
			return;
		}else{
			printKeysInRange(this.root, key1, key2);
			System.out.println();
		}
	}
	
	@Override
	public String toString(){
		if(this.root == null){
			return "Null Tree.";
		}else{
			return serialized(this.root);
		}
	}
	
	public String treeOrder() {
		if(this.root == null){
			return "";
		}else{
			return treeOrder(this.root);
		}
	}
	
	//Method implementations.
	private boolean lookup(BSTNode<K> node, K key) {
		if(node == null){
			return false;
		}
		
		if(node.getKey().equals(key)){
			return true;
		}else{
			if(node.getKey().compareTo(key) > 0){
				return lookup(node.getLeft(), key);
			}else{
				return lookup(node.getRight(), key);
			}
		}
	}
	
	private BSTNode<K> insert(BSTNode<K> node, K key) {
		if(node == null){
			return new BSTNode<K>(key);
		}
		
		if(node.getKey().equals(key)){
			System.out.println("node already exists");
			return this.root;
		}
		
		if(node.getKey().compareTo(key) > 0){
			node.setLeft(insert(node.getLeft(), key));
			return node;
		}else{
			node.setRight(insert(node.getRight(), key));
			return node;
		}
	}

	private BSTNode<K> delete(BSTNode<K> node, K key){
		if(node==null){
			return null;
		}
		
		if(node.getKey().equals(key)){
			if(node.getLeft() == null && node.getRight() == null){
				return null;
			}else if(node.getLeft() == null){
				return node.getRight();
			}else if(node.getRight() == null){
				return node.getLeft();
			}else{
				K smallValue = smallest(node.getRight());
				node.setKey(smallValue);
				node.setRight(delete(node.getRight(),smallValue));
				return node;
			}
		}else{
			if(node.getKey().compareTo(key) > 0){
				node.setLeft(delete(node.getLeft(), key));
				return node;
			}else{
				node.setRight(delete(node.getRight(), key));
				return node;
			}
		}
	}

	private K smallest(BSTNode<K> node) {
		//precondition: node cannot be null.
		if(node.getLeft() == null){
			return node.getKey();
		}else{
			return smallest(node.getLeft());
		}
	}
	
	private K largest(BSTNode<K> node) {
		//precondition: node cannot be null.
		if(node.getRight() == null){
			return node.getKey();
		}else{
			return largest(node.getRight());
		}
	}
	
	
	private K ceil(BSTNode<K> node, K key){
		if(node == null){
			return null;
		}
		
		if(node.getKey().equals(key)){
			return key;
		}else if(node.getKey().compareTo(key) < 0){
			return ceil(node.getRight(),key);
		}else{
			K value = ceil(node.getLeft(), key);
			if(value == null){
				return node.getKey();
			}else{
				return value;
			}
		}
	}
	
	private K floor(BSTNode<K> node, K key){
		
		if(node == null){
			return null;
		}else if(node.getKey().equals(key)){
			return key;
		}else if(node.getKey().compareTo(key) > 0){
			return floor(node.getLeft(), key);
		}else{
			K value = floor(node.getRight(), key);
			if(value == null){
				return node.getKey();
			}else{
				return value;
			}
		}
	}
	private K inOrderSuccessor(BSTNode<K> node, K key) {
		//Precondition: node is not null;
		if(node == null){
			System.out.println("Node with given key doesn't exist.");
			return null;
		}
		
		if(node.getKey().equals(key)){
			if(node.getRight() != null){
				return smallest(node.getRight());
			}else{
				K returnValue = null;
				BSTNode<K> tempNode = this.root;
				while(tempNode != null){
					if(tempNode.getKey().compareTo(key) > 0){
						returnValue = tempNode.getKey();
						tempNode = tempNode.getLeft();
					}else if(tempNode.getKey().equals(key)){
						return returnValue;
					}else{
						tempNode = tempNode.getRight();
					}
				}
				return null;
			}
		}else if(node.getKey().compareTo(key) > 0){
			return inOrderSuccessor(node.getLeft(), key);
		}else{
			return inOrderSuccessor(node.getRight(), key);
		}
	}
	
	private void populateInOrderList(BSTNode<K> node, ArrayList<K> inOrderList) {
		if(node == null){
			return;
		}else{
			populateInOrderList(node.getLeft(),inOrderList);
			inOrderList.add(node.getKey());
			populateInOrderList(node.getRight(),inOrderList);
			return;
		}
	}
	
	private void printKeysInRange(BSTNode<K> node, K key1, K key2) {
		
		if(node == null){
			return;
		}
		
		if(node.getKey().compareTo(key1) > 0){
			printKeysInRange(node.getLeft(), key1, key2);
		}
		if(node.getKey().compareTo(key1) >=0 && node.getKey().compareTo(key2) <= 0){
			System.out.print(node.getKey()+", ");
		}
		if(node.getKey().compareTo(key2) < 0){
			printKeysInRange(node.getRight(), key1, key2);
		}
	}
	
	private String serialized(BSTNode<K> node) {
		if(node == null){
			return "";
		}else{
			return serialized(node.getLeft())+node.getKey().toString()+", "+
					serialized(node.getRight());
		}
	}

	private String treeOrder(BSTNode<K> node) {
		StringBuffer returnString = new StringBuffer("");
		returnString.append(node.getKey());
		if(node.getLeft() != null && node.getRight() == null){
			returnString.append(" < left="+treeOrder(node.getLeft())+" >");
		}else if(node.getLeft() == null && node.getRight() != null){
			returnString.append(" < right="+treeOrder(node.getRight())+" >");
		}else if(node.getLeft() != null && node.getRight() != null){
			returnString.append(" < left="+treeOrder(node.getLeft())+", right="+treeOrder(node.getRight())+" >");
		}
		return returnString.toString();
	}
}
