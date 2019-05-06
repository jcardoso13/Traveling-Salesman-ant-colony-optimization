package graph;

import java.util.ArrayList;

public interface GraphInterface<T,E>{
	public ArrayList<Vertex<T, E>> getG(); //Returns an Array of Nodes
	public Vertex<T,E> GetVertex(T label); // Returns a Node
	public boolean addVertex(T label); // Adds a Node
	public boolean addE(T label1,T label2, E weight); //Adds an Edge
	public ArrayList<Edge<T,E>> GetEdgeVector(T label);
}
