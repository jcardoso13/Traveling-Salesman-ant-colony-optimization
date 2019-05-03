package graph;


public class Edge<T,E>{
	
	T label;
	E weight;
	public Edge(T label, E weight)
	{
		this.label=label;
		this.weight=weight;
	}
	
	public String toString() {
		return "\nLabel:"+ this.label + " Weight:"+ this.weight+"\n"; 
	}
}
