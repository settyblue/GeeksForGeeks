import java.util.Iterator;

/**
 * 
 */

/**
 * @author rakshith
 *
 */
public class LinkedList<T extends Comparable<T>> implements List<T>{
	Node<T> head;
	private int count;
	
	LinkedList(){
		this.head = null;
		this.count = 1;
	}
	
	LinkedList(T data){
		this.head = new Node<T>(data);
		this.count = 1;
	}
	
	public void addEnd(T data){
		Node<T> node = new Node<T>(data);
		if(this.head == null){
			this.head = node;
		}else{
			Node<T> temp = this.head;
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = node;
		}
		this.count++;
	}
	
	public void addBegin(T data){
		Node<T> node = new Node<T>(data);
		if(this.head == null){
			this.head = node;
		}else{
			node.next = this.head;
			this.head = node;
		}
		this.count++;
	}
	
	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer();
		Node<T> temp = this.head;
		while(temp.next != null){
			sb.append(temp.data.toString()+"->");
			temp = temp.next;
		}
		
		return sb.append(temp.data).toString();
	}
	
	public void printLinkedList(){
		System.out.println(this.toString());
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount() {
		return this.count;
	}

	@Override
	public T get(int index) {
		if(index >= this.count){
			return null;
		}else{
			int i = 0;
			Node<T> temp = this.head;
			while(i < index){
				temp = temp.next;
			}
			return temp.data;
		}
	}

	@Override
	public void set(int index, T data) {
		if(index >= this.count){
			return;
		}else{
			int i = 0;
			Node<T> temp = this.head;
			while(i < index){
				temp = temp.next;
				i++;
			}
			temp.data = data;
		}
	}

	@Override
	public void add(T data) {
		this.addEnd(data);
	}

	@Override
	public void insert(int index, T data) {
		Node<T> node = new Node<T>(data);
		if(this.count == 0 || index == 0){	
			node.next = this.head.next;
			this.head = node;
		}else{
			Node<T> temp = this.head;
			if(this.count > index){
				int i = 0;
				while(i < index-1){
					temp = temp.next;
					i++;
				}
				node.next = temp.next;
				temp.next = node;
			}else{
				while(temp.next != null){
					temp = temp.next;
				}
				temp.next = node;
			}
		}
		this.count++;
	}

	@Override
	public void remove(T data) {
		if(this.head == null){
			return;
		}
		if(this.head.data == data){
			head = head.next;
			this.count--;
			return;
		}
		
		Node<T> temp = this.head;
		Node<T> prev = null;
		while(temp != null){
			if(temp.data.equals(data)){
				prev.next = temp.next;
				this.count--;
				return;
			}
			prev = temp;
			temp = temp.next;
		}
	}

	@Override
	public void removeAt(int index) {
		if(this.count == 0){	
			return;
		}
		if(index == 0){
			this.head = this.head.next;
			this.count--;
			return;
		}else if(this.count > index){
			Node<T> temp = this.head;
			int i = 0;
			while(i < index - 1){
				temp = temp.next;
				i++;
			}
			temp.next = temp.next.next;
			this.count--;
		}
	}
}
