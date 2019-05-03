package graph;


public class Edge<T,E>{
	
	private T label;
	private E weight;
	public Edge(T label, E weight)
	{
		this.label=label;
		this.weight=weight;
	}
	
	
	public T getLabel() {
		return label;
	}


	public E getWeight() {
		return weight;
	}


	public String toString() {
		return "\nLabel:"+ this.label + " Weight:"+ this.weight+"\n"; 
	}
}
