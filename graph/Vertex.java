package graph;

import java.util.ArrayList;

public class Vertex<T,E>{

	private T label;
	private ArrayList<Edge<T,E>> e;
	public Vertex(T label) {
		this.e= new ArrayList<Edge<T,E>>();
		this.label=label;
	}
	
	void addE(T label, E weight)
	{
		Edge<T,E> e=new Edge<T,E>(label,weight);
		this.e.add(e);
	}
	
	
	// Getter do Nome da Node, (diferente da posicao no vetor!)
	public T getLabel() {
		return  label;
	}

	
	//Getter do Array de Arestas, Para o trabalho, itera-se de 1 a N sendo N o numero de arestas
	// Para referencia, ler sobre Iteradores (ou ver o codigo de GetV em graph.java)
	public ArrayList<Edge<T, E>> getE() {
		return e;
	}

	// Retira uma Edge da Node, nao e preciso usar para o projeto
	void removeE(T label)
	{
		this.e.remove(label);
	}
	
	
	// Para Println
	public String toString() {
		return "\n Label:" + this.label + " \n Edges: \n" + this.e.toString() + "\n"; 
	}
	

	/* O seguinte codigo da hascode e equals e para o GetV, por isso ignora */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex<T,E> other = (Vertex<T,E>) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}
	
}