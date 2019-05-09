package graph;

import java.util.ArrayList;
/****************************************************************
 * 
 * @author Grupo 11
 *
 * @param <T>
 * @param <E>
 * 
 ***************************************************************/
public interface GraphInterface<T,E>{
	/***********************************************************
	 * 
	 * @return Array de Nodes
	 **********************************************************/
	public ArrayList<Vertex<T, E>> getG(); 
	/**********************************************************
	 * 
	 * @param label
	 * @return um node
	 *********************************************************/
	public Vertex<T,E> GetVertex(T label);
	/*********************************************************
	 * 
	 * @param label -- adiciona um node
	 * @return
	 ********************************************************/
	public boolean addVertex(T label);
	/********************************************************
	 * Adiciona uma aresta considerando dois nodes e o peso
	 * entre si.
	 * @param label1 -- node
	 * @param label2 -- node vizinho
	 * @param weight -- peso entre o node e o vizinho
	 * 
	 * @return um array de Edge
	 *******************************************************/
	public boolean addE(T label1,T label2, E weight); 
	public ArrayList<Edge<T,E>> GetEdgeVector(T label);
}
