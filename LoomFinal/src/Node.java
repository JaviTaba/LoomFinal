
public class Node <T> {
	
	private T data;	
	private Node<T> next;


	public Node(){
			setData(null);	
	}
	
	public Node(T data) {
		setData(data);
	}
	
	public boolean isValid() {
		return (getData() != null);
	}
	
	public void addAfter(Node<T> previousNode) {
		this.setNext(previousNode.getNext());
		previousNode.setNext(this);;
	}
	
	 public void removeNext() {
		 this.setNext(this.getNext().getNext());
	 }

	
	

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
}
