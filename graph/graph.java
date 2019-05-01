package graph;


import java.util.*;

public class graph<T,E>{
	
	private ArrayList<Vertex<T,E>> g;
	
	public graph() {
		this.g = new ArrayList<Vertex<T,E>>();
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
		int n=0;
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
	
	
