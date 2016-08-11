/**
 * https://www.careercup.com/question?id=5171244619005952
 * https://www.careercup.com/question?id=5640778723360768
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
		node2.left.left = new Node<Integer>(90);
		
		Node<Integer> lca = findLCA(tree,new Node<Integer>(30), new Node<Integer>(90));
		if(lca != null)System.out.println("lca is "+lca.getData());
		System.out.println("Number of leaf nodes = "+tree.leafNodeCount());
		
	}
	
	public static <T> Node<T> findLCA(BinaryTree<T> tree,Node<T> node1,Node<T> node2){
		if (tree.getRoot()==null)return null;
		boolean[] b = {false, false};
		Node<T> temp = findLCA(tree.getRoot(), node1, node2, b);
		if(b[0] && b[1]){
			return temp;
		}else return null;
	}
	//Incomplete implementation. fails for (30,90) 
	private static <T> Node<T> findLCA(Node<T> root, Node<T> node1, Node<T> node2, boolean[] b) {
		if(root==null){
			return null;
		}
		if(root.getData()==node1.getData() || root.getData()==node2.getData()){
			if(root.getData()==node1.getData()){
				b[0] = true;
			}else{
				b[1] = true;
			}
			return root;
		}
		
		Node<T> left_lca = findLCA(root.getLeft(), node1, node2, b);
		Node<T> right_lca = findLCA(root.getRight(), node1, node2, b);
		
		if(left_lca != null && right_lca != null)return root;
		
		return left_lca != null ? left_lca : right_lca;
	}
}
