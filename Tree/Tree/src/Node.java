import static java.lang.Math.max;

/**
 * 
 */

/**
 * @author rakshith
 *
 */
public class Node<T> {
	public T data;
	public Node<T> left;
	public Node<T> right;
	
	Node (){
		this.data = null;
		this.left = null;
		this.right = null;
	}
	
	Node (T data){
		this.data = data;
		this.left = null;
		this.right = null;
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
	
	public int size(){
		int count = 1;
		if(this.getLeft() != null)count += this.getLeft().size();
		if(this.getRight() != null)count += this.getRight().size();
		return count;
	}
	
	public int depth(){
		int leftDepth = this.getLeft()!= null ? this.getLeft().depth() : 0;
		int rightDepth = this.getRight() != null ? this.getRight().depth() : 0;
		return 1+max(leftDepth,rightDepth);
	}
	
	public int height(){
		return this.depth();
	}
	
	//TODO: simplify
	public boolean equals(Node<T> node){
		if(node == null) return false;
		boolean a = (this.data == node.getData());
		boolean b,c;
		if(this.left != null && node.getLeft() != null){
			b = this.left.equals(node.getLeft());
		}else if(this.left == null && node.getLeft() == null){
			b = true;
		}else{
			b = false;
		}
		if(this.right != null && node.getRight() != null){
			c = this.right.equals(node.getRight());
		}else if(this.right == null && node.getRight() == null){
			c = true;
		}else{
			c = false;
		}
		return ( a && b && c);
	}
	
	//TODO: Implement delete node.
	public void deleteNode(Node<T> node){
		if(node==null)return;
		deleteNode(node.getLeft());
		deleteNode(node.getRight());
		node = null;
	}

	public void mirrorNode() {
		if(this.getRight() != null){
			this.getRight().mirrorNode();
		}
		if(this.getLeft() != null){
			this.getLeft().mirrorNode();
		}
		Node<T> temp = this.getLeft();
		this.left = this.getRight();
		this.right = temp;
	}
	
	public void printAllLeafPaths(String pathSoFar){
		if(this.getLeft() == null && this.getRight() == null){
			System.out.println(pathSoFar+"->"+this.getData());
		}else{
			if(this.getLeft() != null){
				this.getLeft().printAllLeafPaths(pathSoFar+"->"+this.getData());
			}
			if(this.getRight() != null){
				this.getRight().printAllLeafPaths(pathSoFar+"->"+this.getData());
			}
		}
	}

	public int leafNodesCount() {
		if(this.getLeft()== null && this.getRight()==null)return 1;
		int count = 0;
		if(this.getLeft() != null)count += this.getLeft().leafNodesCount();
		if(this.getRight() != null)count += this.getRight().leafNodesCount();
		return count;
	}

	public int diameter() {
		int widthThruRoot = 1;
		int leftDiameter = 0, rightDiameter = 0;
		if(this.getLeft() != null){
			widthThruRoot += this.getLeft().depth();
			leftDiameter = this.getLeft().diameter();
		}
		if(this.getRight() != null){
			widthThruRoot += this.getRight().depth();
			rightDiameter = this.getRight().diameter();
		}
		return max(widthThruRoot,max(leftDiameter,rightDiameter));
	}
	
	//TODO:Implement optimized approach.
	public int diameterOptimized() {
		int widthThruRoot = 1;
		int leftDiameter = 0, rightDiameter = 0;
		if(this.getLeft() != null){
			widthThruRoot += this.getLeft().depth();
			leftDiameter = this.getLeft().diameter();
		}
		if(this.getRight() != null){
			widthThruRoot += this.getRight().depth();
			rightDiameter = this.getRight().diameter();
		}
		return max(widthThruRoot,max(leftDiameter,rightDiameter));
	}
}
