package graph;


public class Edge<T,E>{
	
	private T label;
	private E weight;
	private double pheromones;
	private boolean evap;
	
	
	public Edge(T label, E weight)
	{
		this.label=label;
		this.weight=weight;
		this.pheromones = 0;
		this.evap=false;
	}
	
	//Getter do Nome da Node que esta conectado a
	public T getLabel() {
		return label;
	}

	//Getter do Peso
	public E getWeight() {
		return weight;
	}

	//Para println
	public String toString() {
		return "\nLabel:"+ this.label + " Weight:"+ this.weight+"\n" + this.pheromones + "\n"; 
	}
	
	public void setPheromones(double pher)
	{
		this.pheromones = pher;
	}

	public double getPheromones()
	{
		return pheromones;
	}
	
	public boolean getEvap()
	{
		return evap;
	}
	public void setEvap(boolean b)
	{
		this.evap=b;
	}
}
