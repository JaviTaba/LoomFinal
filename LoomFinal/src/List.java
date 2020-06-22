 
public class List<T> {
	private Node<T> first;
	private int size;
	
	
	public List(T element) {
		this.first = new Node<T>(null);
		first.setNext(new Node<T>(element));
		setSize(1);
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public T print() {
		return this.getElementAt(0);
	}
	
	public Iterator<T> getIteratorAtFirstPosition(){
		return new Iterator<T>(first.getNext());
	}
	
	public boolean isEmpty() {
		return (first.getNext() ==null);
	}
	
	public void insertNodeAtEnd(T newElement) {
		Node<T> newNode = new Node<T>(newElement);
		Iterator<T> iterator = getIteratorAtFirstPosition();
		setSize(getSize()+1);
		iterator.advanceToPosition(getSize()-1);
		newNode.addAfter(iterator.getActual());
	}
	
	public void insertNodeFirst(T newElement) {
		Node<T> newNode = new Node<T>(newElement);
		first.addAfter(newNode);
	}
	
	public void insertNodeAt(T newElement, int position) {
		if(position<0) {
			throw new Error("La posicion debe ser mayor o igual a 0.");
		}else if(position ==0) {
			insertNodeFirst(newElement);
		}else if(position == getSize()) {
			insertNodeAtEnd(newElement);
		}else {
			Node<T> newNode = new Node<T>(newElement);
			Iterator<T> iterator = getIteratorAtFirstPosition();
			iterator.advanceToPositionOutOfBounds(position-1);
			iterator.getActual().addAfter(newNode);
		}
	}

	
	
	public void deleteElementAt(int position) {
		if(position<0) {
			throw new Error("La posicion debe ser mayor o igual a 0.");
		}else if(position ==0) {
			first.removeNext();
		}else if(position>0) {
			if((position == this.getSize()) || (this.getSize()<position && position%this.getSize()==0)){
				first.removeNext();
			}else if((position == this.getSize()) || (this.getSize()<position && position%this.getSize()==1)){
				first.getNext().removeNext();
			}else {
				Iterator<T> iterator = getIteratorAtFirstPosition();
				iterator.advanceToPositionOutOfBounds(position-1);
				iterator.getActual().removeNext();
			}
		}
		setSize(getSize()-1);
	}
	
	public T getElementAt(int position) {
		Node<T> auxNode = null;
		if(position<0) {
			throw new Error("La posicion debe ser mayor o igual a 0.");
		}else if(position == 0) {
			auxNode = first.getNext();
		}else if(position > 0) {
			if(this.getSize() == position || (this.getSize()<position && position%this.getSize()==0)) {
				auxNode = first.getNext();
			}else if(this.getSize() == position || (this.getSize()<position && position%this.getSize()==1)) {
				auxNode = first.getNext().getNext();
			}else {
				Iterator<T> iterator = getIteratorAtFirstPosition();
				iterator.advanceToPositionOutOfBounds(position-1);
				auxNode = iterator.getActual().getNext();
			}
		}
		return auxNode.getData();
	}


}

