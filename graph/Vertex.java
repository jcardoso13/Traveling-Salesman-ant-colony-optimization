package graph;

import java.util.ArrayList;

/***********************************************************
 * 
 * @author Grupo 11
 *
 * @param <T>
 * @param <E>
 * 
 ***********************************************************/
public class Vertex<T,E>{

	/* ==== ATRIBUTOS ==== */
	/** **/
	private T label;
	/** **/
	private ArrayList<Edge<T,E>> e;
	
	/* ==== CONSTRUTOR ==== */
	/********************************************************
	 * 
	 * @param label
	 ********************************************************/
	public Vertex(T label) {
		this.e= new ArrayList<Edge<T,E>>();
		this.label=label;
	}
	
	/* ==== METODOS ==== */
	/********************************************************
	 * 
	 * @param label
	 * @param weight
	 ********************************************************/
	void addE(T label, E weight)
	{
		Edge<T,E> e=new Edge<T,E>(label,weight);
		this.e.add(e);
	}
	
	
	// Getter do Nome da Node, (diferente da posicao no vetor!)
	/***********************************************************
	 * Getter do Nome da Node
	 * NOTA= Nao e o mesmo que a posicao no vetor!)
	 * @return
	 ***********************************************************/
	public T getLabel() {
		return  label;
	}

	
	/***********************************************************
	 * Getter do Array de Arestas, Para o trabalho, itera-se de 1 a N
	 * sendo N o numero de arestas
	 * Para referencia, ler sobre Iteradores (ou ver o codigo de GetV 
	 * em graph.java)
	 * 
	 * @return
	 **********************************************************/
	public ArrayList<Edge<T, E>> getE() {
		return e;
	}

	/*********************************************************
	 * Retira uma Edge da Node, nao e preciso usar para o projeto
	 * 
	 * @param label
	 *********************************************************/
	void removeE(T label)
	{
		this.e.remove(label);
	}
	
	
	// Para Println
	/*********************************************************
	 * 
	 ********************************************************/
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