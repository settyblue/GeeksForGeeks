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
	
	@Override
	public String toString(){
		if(this.root == null){
			return "Null Tree.";
		}else{
			return serialized(this.root);
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
	
	private String serialized(BSTNode<K> node) {
		if(node == null){
			return "";
		}else{
			return serialized(node.getLeft())+node.getKey().toString()+", "+
					serialized(node.getRight());
		}
	}
}
