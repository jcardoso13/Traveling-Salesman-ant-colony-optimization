package graph;


public class Edge<T,E>{
	
	private T label;
	private E weight;
	private double pheromones;
	
	
	public Edge(T label, E weight)
	{
		this.label=label;
		this.weight=weight;
		this.pheromones = 0;
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
	
	public void setPheromones(double pher)
	{
		this.pheromones = pher;
	}

	public double getPheromones()
	{
		return pheromones;
	}
}
