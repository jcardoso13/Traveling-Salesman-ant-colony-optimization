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
	
	
	
	public T getLabel() {
		return  label;
	}

	public ArrayList<Edge<T, E>> getE() {
		return e;
	}

	void removeE(T label)
	{
		this.e.remove(label);
	}
	
	public String toString() {
		return "\n Label:" + this.label + " \n Edges: \n" + this.e.toString() + "\n"; 
	}
	

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