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

	/**
	 * Pre: ---
	 *
	 * Post: El método add recibe un Node y lo inserta en la lista
	 * situándola en la última posición.
	 *
	 * */
	
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

	/**
	 * Pre: ---
	 *
	 * Post: El método add recibe un Node y una posicion y lo
	 * inserta en la lista situándola en la posición recibida.
	 *
	 * */

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

	/**
	 * Pre: ---
	 *
	 * Post: El método delete recibe una posición y elimina el Node
	 * situado en ese lugar
	 *
	 * */

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

	/**
	 * Pre: ---
	 *
	 * Post: El método show muestra la lista de nodos con
	 * su información.
	 *
	 * */

	public void show() {
		Node p = first;
		for(int i = 0; i < size; i++) {
			System.out.println("[ " + i + " ] -> " + p.getContenido());
			p = p.getNext();
		}
	}

	/**
	 * Pre: ---
	 *
	 * Post: El método get recibe una posición y devuelve el Node
	 * situado en ese lugar.
	 *
	 * */

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

	/**
	 * Pre: ---
	 *
	 * Post: El eliminarMayor elimina el Node con el contenido int
	 * más valorado.
	 *
	 * */

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
