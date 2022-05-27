package examen3ev.ejercicio3;

public class ListaSimple {
	private Node first;
	private int size;
	
	public ListaSimple() {
		this.first = null;
		this.size = 0;
	}
	
	public ListaSimple(Node first) {
		this.first = first;
		this.size = 1;
	}
	
	public Node getFirst() {
		return first;
	}

	public void setFirst(Node first) {
		this.first = first;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public boolean add(Node node) {
		try {
			if(size == 0) {
				first = node;
			} else {
				Node p = first;
				for(int i = 1; i < size; i++) {
					p = p.getNext();
				} p.setNext(node);
			} 
			size++;
			return true;
		} catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	public boolean add(int position, Node node) {
		try {
			if(position == 0) {
				node.setNext(first);
				first = node;
			} else if(position == size-1) {
				add(node);
			} else {
				Node p = first;
				
				for(int i = 0; i < position-1; i++) {
					p = p.getNext();
				}
				
				node.setNext(p.getNext());
				p.setNext(node);
			}
			size++;
			return true;
		} catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	public boolean delete(int position) {
		try {
			Node p = first;
			
			if(position == 0) {
				first = first.getNext();
			}else{
				for(int i = 0; i < position-1; i++) {
					p = p.getNext();
				}
				if(position == size-1) {
					p.setNext(null);
				} else {
					p.setNext(p.getNext().getNext());
				}
			}
			size--;
			return true;
		}catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}

	public void show() {
		Node p = first;
		for(int i = 0; i < size; i++) {
			System.out.println("[ " + i + " ] -> " + p.getContenido());
			p = p.getNext();
		}
	}
	
	public Node get(int position) {
		Node p = first;
		
		if(position == 0) {
			return first;
		}else{
			for(int i = 0; i < position; i++) {
				p = p.getNext();
			}
			return p;
		}
	}

	public void eliminarMayor(){
		Node p = first;
		int mayor = 0;

		for (int i = 0; i < size; i++){
			if (get(mayor).getContenido() < p.getContenido()){
				mayor = i;
			}
			p = p.getNext();
		}

		delete(mayor);
	}
}
