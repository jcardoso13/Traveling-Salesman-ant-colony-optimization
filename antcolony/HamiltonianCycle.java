package antcolony;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import graph.*;


public class HamiltonianCycle<T,E> {

	//ArrayList<Vertex<T,E>> path;
	graph<T,E> G;
	double alpha;
	double beta;
	double delta;
	
	
	
	public HamiltonianCycle(double A,double b,double d,graph<T,E> g)
	{
		//this.path= new ArrayList<Vertex<T,E>>();
		this.alpha=A;
		this.beta=b;
		this.delta=d;
		this.G=g;
	}
	
	public LinkedList<T> GetNextMove(LinkedList<T> path) 
	{
		
		ArrayList<Edge<T,E>> Edges=G.GetEdgeVector(path.getLast());
		ArrayList<Double> prob= new ArrayList<Double>();
		ArrayList<Vertex<T,E>> available= new ArrayList<Vertex<T,E>>();
		double aux_double;
		double aux_accum,aux_accum2=0;
		boolean b;	
		T obj;
		T next_label;
		int next;
		Iterator<Edge<T,E>> it_e= Edges.iterator();
		Iterator<T> it_list;
		int n=0,i,j = 0;
		aux_accum=0;
		if(!Edges.isEmpty()) {
			while(it_e.hasNext())
			{
				Edge<T,E> auxe=it_e.next();
				Vertex<T,E> aux= new Vertex<T,E>(auxe.getLabel());
				b=path.contains(aux);
				if (!b)
				{
					available.add(aux);
					n++;
					aux_double=Calc_Coef(this.alpha,this.beta,auxe.getPheromones(),auxe.getWeight());
					aux_accum+=aux_double;
					prob.add(aux_double);
				}
				j++;
			}
		 
		}
		if (n!=0)
		{
			for(i=0;i<n;i++)
			{
			aux_accum2+=prob.get(i)/aux_accum;
			prob.set(i,aux_accum2);	
			}
			next=random_decision(prob,n);
			path.add(available.get(next).getLabel());
		}
		else
		{
			for(i=0;i<j;i++)
			{
			aux_accum2+=(double)(1/j);
			prob.add(aux_accum2);
			}
			next=random_decision(prob,j);
			next_label=Edges.get(next).getLabel();
			it_list=path.iterator();
			while(it_list.hasNext())
			{
				obj=it_list.next();
				if(obj.equals(next_label));
				{
					while(it_list.hasNext())
					{
					path.remove(it_list.next());
					}
					break;
				}
			}
			
		}
		
		return path;
		 
		 //If node already visited= Eliminate the path after that node!
	}
	
	private double Calc_Coef(double alpha, double beta, double phero, E weight) 
	{
		int w;
		w=(int)weight;
		return (alpha+phero)/(beta+w);
	}
	
	private int random_decision(ArrayList<Double> prob,int index)
	{
		double in_prob;
		in_prob=Math.random();
		int i;
		for(i=0;i<index;i++)
		{
			if(in_prob<=prob.get(i))
			{
				return i;
			}
		}
		return index-1;
	}
	
	
}
