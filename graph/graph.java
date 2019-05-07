package graph;


import java.util.*;

public class graph<T,E> implements GraphInterface<T,E>{
	
	private ArrayList<Vertex<T,E>> g;
	
	
	//Getter do Vetor de Nodes
	public ArrayList<Vertex<T, E>> getG() {
		return g;
	}

	//Getter do Node na posicao -Position- do vetor
	public Vertex<T,E> GetVertex(T label) {
		int x;
		Vertex<T,E> v1= new Vertex<T,E>(label);
		x= this.getV(v1);
		return g.get(x);
	}
	
	public ArrayList<Edge<T,E>>GetEdgeVector(T label){
		int x;
		Vertex<T,E> v1= new Vertex<T,E>(label);
		x= this.getV(v1);
		return g.get(x).getE();
		
	}

	// Cria o grafo com um List Array Vazio
	public graph() {
		this.g = new ArrayList<Vertex<T,E>>();
	}
	
	
	// if success return true, else fail
	// Adiciona um vertice ao grafo com lista de adjacencias vazia
	
	public boolean addVertex(T label) {
		Vertex<T,E> v= new Vertex<T,E>(label);
		if (this.g.contains(v)==false) // se o grafo ainda nao tiver este Node
		{
			this.g.add(v);
			return true;
		}
		else {
			return false;
		}
	}
	//return true if success, else fail
	//Retira um vertice do grafo, nao e preciso para o nosso proj
	
	public boolean removeVertex(T label) {
		Vertex<T,E> v= new Vertex<T,E>(label);
		boolean b=this.g.remove(v);
		return b;
	}
	
	
	/* Adiciona uma Aresta entre 2 nodes */
	public boolean addE(T label1,T label2, E weight) {
		Vertex<T,E> v1= new Vertex<T,E>(label1);
		Vertex<T,E> v2= new Vertex<T,E>(label2);
		
		if (this.g.contains(v1)==true && this.g.contains(v2)==true) //Se os dois Nodes existirem no grafo
		{
			int x,y;
			x=this.getV(v1); //Buscar a posicao no vetor
			if (x==-1)
				return false;
			y=this.getV(v2); 
			if (y==-1)
				return false;
			this.g.get(x).addE(label2,weight); //Adicionar Aresta
			this.g.get(y).addE(label1,weight); //Adicionar Aresta
			return true;
		}
		else return false;
	}
	
	
	/* Remove uma Aresta entre dois Nodes*/
	public boolean removeE(T label1,T label2) {
		Vertex<T,E> v1= new Vertex<T,E>(label1);
		Vertex<T,E> v2= new Vertex<T,E>(label2);
		
		if (this.g.contains(v1)==true && this.g.contains(v2)==true)
		{
			int x,y;
			x=this.getV(v1);
			if (x==-1)
				return false;
			y=this.getV(v2);
			if (y==-1)
				return false;
			
			this.g.get(x).removeE(label2);
			this.g.get(y).removeE(label1);
		}
		
	return true;	
	}
		
	
	
	/*Com apenas um Label, encontra o Node e retorna a sua posicao no Vetor */
	int getV(Vertex<T,E> v)
	{
		Iterator<Vertex<T,E>> it=this.g.iterator();
		int n=0;
		boolean f= this.g.get(0).equals(v); // Se a posicao 0 do vetor e igual ao input
											// Retorna 0, se nao continua a procurar
		if (f==false)
		{
			while(it.hasNext()) //Iterador, se nao for o ultimo membro da Lista
			{
				f=it.next().equals(v); // Sao iguais?
				if (f==true)
				{
				return n; // Se sim, retorna a sua posicao
				}
				n++; //Se nao, Continuar a procurar
			}
			return -1; //Nao existe essa Node no Grafo
		}
		return 0; 
	}
	
	/* Para Println do grafo */
	public String toString() {
		return this.g.toString(); 
	}
	/***
	 * 
	 * @param label1
	 * @param label2
	 * @return
	 */
	public Edge<T,E> FindE(T label1,T label2)
	{
		Vertex<T,E> v1= new Vertex<T,E>(label1);
		Vertex<T,E> v2= new Vertex<T,E>(label2);
		Iterator<Edge<T,E>> e;
		Edge<T,E> ed;
		Edge<T,E> error= (Edge<T, E>) new Edge<Integer,Integer>(0,0);
		Vertex<T,E> v3;
		int x;
		if (this.g.contains(v1)==true && this.g.contains(v2)==true)
		{
			x=this.getV(v1);
			v3=this.g.get(x);
			e=v3.getE().iterator();
			while(e.hasNext())
			{
				ed=e.next();
				if (ed.getLabel().equals(v2.getLabel()))
				{
					return ed;
				}
			}
		}
		return error;
	}
}
	
	
