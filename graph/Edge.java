package graph;


public class Edge<T,E>{
	
	private T label;
	private E weight;
	public Edge(T label, E weight)
	{
		this.label=label;
		this.weight=weight;
	}
	
	//Getter do Nome da Node que está conectado a
	public T getLabel() {
		return label;
	}

	//Getter do Peso
	public E getWeight() {
		return weight;
	}

	//Para println
	public String toString() {
		return "\nLabel:"+ this.label + " Weight:"+ this.weight+"\n"; 
	}
}
