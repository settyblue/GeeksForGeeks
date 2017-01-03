/**
 * 
 */

/**
 * @author rakshith
 *
 */
public class BSTNode <K> {
	
	private K key;
	private BSTNode<K> left, right;
	
	public BSTNode(K key) {
		this.key = key;
		this.left = null;
		this.right = null;
	}
	
	public BSTNode(K key, BSTNode<K> left, BSTNode<K> right) {
		this.key = key;
		this.left = left;
		this.right = right;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public BSTNode<K> getLeft() {
		return left;
	}

	public void setLeft(BSTNode<K> left) {
		this.left = left;
	}

	public BSTNode<K> getRight() {
		return right;
	}

	public void setRight(BSTNode<K> right) {
		this.right = right;
	}
	
}
