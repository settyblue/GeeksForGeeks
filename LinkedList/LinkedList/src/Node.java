/**
 * 
 */

/**
 * @author rakshith
 *
 */
public class Node<T extends Comparable<T>> implements Comparable<Node<T>>{
	public T data;
	Node<T> next;
	
	Node(T data){
		this.data = data;
		this.next = null;
	}
	
	@Override
	public int compareTo(Node<T> node){
		return this.data.compareTo(node.data);
	}
	
	public boolean equals(Node<T> node){
		if(this.data == node.data){
			return true;
		}else{
			return false;
		}
	}
}
