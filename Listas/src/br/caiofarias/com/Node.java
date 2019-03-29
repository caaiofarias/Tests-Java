package br.caiofarias.com;

public class Node {
	  private Node proxima;

	  private Node anterior;
	  
	  private Object elemento;

	  public Node(Node proxima, Object elemento) {
	    this.proxima = proxima;
	    this.elemento = elemento;
	  }

	  public Node(Object elemento) {
	    this.elemento = elemento;
	  }

	  public void setProxima(Node proxima) {
	    this.proxima = proxima;
	  }

	  public Node getProxima() {
	    return proxima;
	  }
	  
	  public void setAnterior(Node anterior) {
	    this.anterior = anterior;
	  }
	  
	  public Node getAnterior() {
	    return anterior;
	  }
	  
	  public Object getElemento() {
	    return elemento;
	  }
	
	public static void main(String[] args) {
		
	}
}
