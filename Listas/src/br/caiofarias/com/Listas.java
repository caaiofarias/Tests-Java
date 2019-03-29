package br.caiofarias.com;
/**
 * @author Caio Farias
 * Criação de uma lista encadeada dinâmica com as funções mais básicas. 
 * Recebe um nó como elemento, e faz operações de remoção,busca, e adição na lista.
 * 
 */
public class Listas {
	
	private Node primeiro= null;
	private Node ultimo = null;
	
	public boolean Isempty() {
		//verifica se a lista está vazia ou não;
		if(this.primeiro==null && this.ultimo == null) {
			return true;
		}else {
			return false;
		}
	}
	/*	
		Metódo que Insere um nó instanciado no começo da lista
		@param elemento o objeto nó a ser adicionado
	*/
	public void InsertAtBegin(Object elemento) {
		Node novo = new Node(elemento);//instancia um novo nó
		if (this.Isempty() == true){//caso a lista esteja vazia, o a referencia primeiro e ultimo apontam para o novo nó add;
			this.primeiro = this.ultimo= novo;
		}else { //caso já tenham outros elementos, o novo aponta para o antigo primeiro elemento da lista(que ainda é o primeiro")
			novo.setProxima(primeiro);
			this.primeiro = novo;//o primeiro elemento da lista agora é o novo elemento add.
		}
		
	}
	
	public void InsertAtEnd(Object elemento) {
		Node novo = new Node(elemento);//instancia um novo nó
		if(Isempty()==true) {//caso a lista esteja vazia, o "ponteiro" primeiro e ultimo apontam para o novo nó add;
			this.primeiro = this.ultimo = novo;
		}else {//caso já tenham outros elementos, o ultimo elemento aponta para o novo.
			this.ultimo.setProxima(novo);
			this.ultimo = novo;//o ultimo elemento é o novo elemento
		}
	}
	
	public Object RemoveFromBegin() {
		if(this.Isempty() == true) {//Caso a lista esteja vazia retorna null;
			return null;
		}
		Object firstnodevalue = this.primeiro.getElemento();//pego o valor do primeiro elemento
		if(this.primeiro == this.ultimo) {//se só tiver 1 elemento na lista, seta a referencia primeiro e ultimo  para null;
			this.primeiro = this.ultimo = null;
		}else {//caso tenha mais de um, a referencia primeiro aponta para o proximo do nó que vai ser removido
			this.primeiro = this.primeiro.getProxima();
		}
		return firstnodevalue;//retorna o valor deste nó
	}
	
	public Object RemoveFromEnd() {
		if (this.Isempty() == true) {//Caso a lista esteja vazia retorna null;
			return null;
		}
		Object lastnodevalue = this.ultimo.getElemento();//pego o valor do primeiro elemento para retorna-lo depois;
		if(this.primeiro == this.ultimo) {//se só tiver 1 elemento na lista, seta a referencia primeiro e ultimo  para null;
			this.primeiro = this.ultimo = null;
		}else {//tenho que percorrer a lista para achar o anterior ao ultimo nó.
			Node currentnode = this.primeiro;//pego o primeiro nó
			while(currentnode.getProxima()!=this.ultimo) {//itero até o currentNode ser igual ao ultimo elemento.
				currentnode = currentnode.getProxima();//se o elementonao for ele, pego o proximo ate achar
			}
			currentnode.setProxima(null);//saindo do while, seto o nó que vai ser o ultimo para null;
			this.ultimo = currentnode;//e o ultimo nó agora é o currentNode(nó anterior ao ultimo).
			//Sem ser referenciado, o ultimo nó que estava é excluido pelo coletor.
		}
		return lastnodevalue;//retorno o valor do Objeto.
	}
	
	public Object SearchNode(Object elemento) {
		if(this.Isempty()) {
			return null;
		}
		Node currentnode = this.primeiro;
		while(currentnode!=null) {
			if(currentnode.getElemento()==elemento) {
				return currentnode.getElemento();
			}else {
				currentnode = currentnode.getProxima();
			}
		}
		return null;
		//if (currentnode == null){
			//return null;
		//}
		//return currentnode.getElemento();
	}
	
	public String toString() {
		if(this.Isempty()) {
			return "[]";
		}
		StringBuilder builder = new StringBuilder("[");
		Node currentnode = this.primeiro;
		while(currentnode != this.ultimo) {
			builder.append(currentnode.getElemento());
			builder.append(", ");
			currentnode = currentnode.getProxima();
		}
		builder.append(currentnode.getElemento());
		builder.append("]");
		return builder.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Listas lista = new Listas();
		lista.InsertAtBegin(2);
		lista.InsertAtEnd(4);
		System.out.println(lista.toString());
		/*System.out.println(lista.SearchNode(4));
		System.out.println(lista.RemoveFromEnd());*/
		
	}

}
