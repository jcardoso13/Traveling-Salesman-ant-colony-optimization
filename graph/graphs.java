package graph;


import java.util.*;

class graph<T,E>{
	
	private ArrayList<Vertex<T,E>> g;
	private int n;
	
	public graph() {
		this.g = new ArrayList<Vertex<T,E>>();
		this.n=0;
	}
	
	
	// if success return true, else fail
	boolean addVertex(T label) {
	Vertex<T,E> v= new Vertex<T,E>(label);
	if (this.g.contains(v)==false)
	{
	this.g.add(v);
	return true;
	}
	return false;
	
	}
	//return true if success, else fail
	boolean removeVertex(T label) {
		Vertex<T,E> v= new Vertex<T,E>(label);
		boolean b=this.g.remove(v);
		return b;
	}
	
	boolean addE(T label1,T label2, E weight) {
		Vertex<T,E> v1= new Vertex<T,E>(label1);
		Vertex<T,E> v2= new Vertex<T,E>(label2);
		
		if (this.g.contains(v1)==true && this.g.contains(v2)==true)
		{
			int x,y;
			x=this.getV(v1);
			if (x==-1)
				return false;
			y=this.getV(v2);
			if (y==-1)
				return false;
			this.g.get(x).addE(label2,weight);
			this.g.get(y).addE(label1,weight);
			return true;
		}
		else return false;
	}
	
	boolean removeE(T label1,T label2) {
		Vertex<T,E> v1= new Vertex<T,E>(label1);
		Vertex<T,E> v2= new Vertex<T,E>(label2);
		
		if (this.g.contains(v1)==true && this.g.contains(v2)==true)
		{
			int x,y;
			x=this.getV(v1);
			if (x==-1)
				return false;
			y=this.getV(v2);
			if (y==-1)
				return false;
			
			this.g.get(x).removeE(label2);
			this.g.get(y).removeE(label1);
		}
		
	return true;	
	}
		
	
	int getV(Vertex<T,E> v)
	{
		Iterator<Vertex<T,E>> it=this.g.iterator();
		n=0;
		boolean f= this.g.get(0).equals(v);
		if (f==false)
		{
			while(it.hasNext())
			{
				n++;
				f=it.next().equals(v);
				if (f==true)
				{
				return n;
				}
			}
			return -1;
		}
		return 0;
	}
	
	// getters and setters
}



	
	

class Vertex<T,E>{

	T label;
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
	
	void removeE(T label)
	{
		this.e.remove(label);
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}
	
}

class Edge<T,E>{
	
	T label;
	E weight;
	public Edge(T label, E weight)
	{
		this.label=label;
		this.weight=weight;
	}
}

	
	
