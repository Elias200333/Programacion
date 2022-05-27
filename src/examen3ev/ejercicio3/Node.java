package examen3ev.ejercicio3;

public class Node {
	private int contenido;
	private Node next;
	
	public Node() {}
	
	public Node(int contenido){
        this.contenido = contenido;
    }
	
	public Node(int contenido, Node next){
        this.contenido = contenido;
        this.next = next;
    }
	
	public int getContenido() {
		return contenido;
	}

	public void setContenido(int content) {
		this.contenido = content;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return "Content = " + contenido + " Next = " + next;
	}
}
