
public class Iterator<T> {
	
	Node<T> node;
	Node<T> backup;
	
	public Iterator(Node<T> node) {
		this.node = node;
		this.backup = new Node<T> (this.node.getData());
		this.backup.setNext(this.node.getNext());
	}
	
	public boolean isValid() {
		return this.node.isValid();
	}
	
	public Node<T> getActual(){
		return this.node;
	}
	
	public boolean isLast(){
		return(isValid() && (this.node.getNext()) == null);		
	}
	
	
	public void advance() {
		if(!isLast()) {
			this.node = this.node.getNext();
		}
	}
	
	public void advanceToPosition(int wantedPosition) {
		if(wantedPosition>=0) {
			for(int i=0; i<wantedPosition; i++) {
				this.advance();
			}
		}else {
			throw new Error("La posicion deseada debe ser mayor o igual a 0");
		}
	}
	
	public void advanceToPositionOutOfBounds(int wantedPosition) {
		for(int i=0; i<wantedPosition; i++) {
			if(this.node == null) {
				this.node = this.backup;
			}
			this.node = node.getNext();
		}
	} 
	
}
