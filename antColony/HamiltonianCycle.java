package antColony;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import graph.*;

/*******************************************************************************
 * 
 * @author Grupo 11
 * 
 * Class that has the methods and values needed to find the path for the Ant
 *
 * @param <T>
 * @param <E>
 * 
 *******************************************************************************/
public class HamiltonianCycle<T,E> {

	/* ===== ATRIBUTOS ===== */
	/** grafo que as formigas podem percorrer **/
	graph<T,E> G;
	/** parametro relacionado com o evento: movimento da formiga**/
	double alpha;
	/** parametro relacionado com o evento: movimento da formiga**/
	double beta;

	/* ==== CONSTRUTOR ==== */
	/*********************************************************************
	 * 
	 * Initiation of the Class with the problem's data
	 * Functions as a "init"
	 * 
	 * @param Alpha
	 * @param Beta
	 * @param graph
	 * 
	 *********************************************************************/
	HamiltonianCycle(double A,double b,graph<T,E> g)
	{
		this.alpha=A;
		this.beta=b;
		this.G=g;
	}
	
	/* ==== METODOS ==== */
	

	/**********************************************************************
	 * 
	 * The algorithm that receives an Ant as a parameter and finds the next Vertex
	 * and updates it's path based on the specifications of the project
	 * Also updates the PEC with the needed Evaporation and Move events
	 * 
	 * 
	 * @param ant
	 * @return updated ant
	 *
	 **********************************************************************/
	public Ant GetNextMove(Ant ant) 
	{
		LinkedList<pathw> path = (LinkedList<pathw>) ant.getP();
		/* Lista de arestas do node corrente */
		@SuppressWarnings("unchecked")
		ArrayList<Edge<T,E>> Edges=G.GetEdgeVector((T)path.getLast().getPath()); 
		/* Array de probabilidades das arestas */
		ArrayList<Double> prob= new ArrayList<Double>();
		/* Array da disponibilidade da aresta */
		ArrayList<Vertex<T,E>> available= new ArrayList<Vertex<T,E>>();
		ArrayList<E> weight= new ArrayList<E>();
		/* Variaveis auxiliares */
		int n=0,i,j = 0;//x=0;
		double aux_double; 
		double aux_accum = 0,aux_accum2 = 0;
		boolean b;	
		Integer obj; 
		T next_label;
		int next;
		/* Iteradores */
		Iterator<Edge<T,E>> it_e= Edges.iterator();
		Iterator<pathw> it_list;
		
		if(!Edges.isEmpty()) 
		{
			/* Percorrer o vetor de arestas e verificar que as arestas ainda nao estao no path */
			while(it_e.hasNext())
			{
				Edge<T,E> auxe=it_e.next();
				Vertex<T,E> aux= new Vertex<T,E>(auxe.getLabel());
				b=ant.getPath().contains(auxe.getLabel());
				/* Se a aresta nao estiver no caminho ainda */
				if (!b)
				{
					available.add(aux);
					weight.add(auxe.getWeight());
					n++;
					/* Calcular a Probabilidade e adicionar no array de probabilidades */
					aux_double=Calc_Coef(this.alpha,this.beta,auxe.getPheromones(),auxe.getWeight());
					aux_accum+=aux_double;
					prob.add(aux_double);
				}
				j++;
			}	 
		}
		else return ant;
		/* Se exitem vertices que ainda nao foram visitados */
		if (n!=0)
		{
			/* Escolha do caminho */
			for(i=0;i<n;i++)
			{
				aux_accum2+=prob.get(i)/aux_accum;
				prob.set(i,aux_accum2);	
			}
			next=random_decision(prob,n); /* retorna a escolha tomada */
			ant.getP().add(new pathw((Integer)available.get(next).getLabel(),(Integer)weight.get(next)));
		}
		else //se nao houver caminho nao visitados
		{
			/* Calculo da probabilidade distribuida */
			double j1;
			for(i=0;i<j;i++)
			{
				j1=(double)j;
				aux_accum2+=(1/j1);
				prob.add(aux_accum2);
			}
			next=random_decision(prob,j); /* retorna a escolha tomada */
			next_label=Edges.get(next).getLabel();// para saber a identificacao do node que vem a seguir
			it_list=ant.getP().iterator();
			while(it_list.hasNext())
			{
				obj=it_list.next().path;
				if(obj.equals((Integer)next_label))
				{
					while(it_list.hasNext())
					{
					it_list.next();
					it_list.remove();
					}
					break;
				}
			}
			
		}

		return ant;
		 
		 /*If node already visited= Eliminate the path after that node! */
	}
	
	/*****************************************************************************
	 * Calc_Coef -- Calculates the edge coefficient
	 * 
	 * @param alpha
	 * @param beta
	 * @param phero
	 * @param weight
	 * @return Coefficient
	 *
	 *****************************************************************************/
	private double Calc_Coef(double alpha, double beta, double phero, E weight) 
	{
		double w;
		w=(double)(int)weight;
		return (alpha+phero)/(beta+w);
	}
	
	/********************************************************************************
	 * random_decision -- Decides the Edge to be taken based on the Probability
	 * 
	 * @param prob vector
	 * @param index (size of said vector)
	 * @return index of edge
	 * 
	 *******************************************************************************/
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
	
	/*******************************************************************************
	 * Calculates the cost of the whole path
	 * @param Weight List
	 * @return Total Weight
	 * 
	 *******************************************************************************/
	public int calculate_cost(LinkedList<Integer> weight)
	{
		Iterator<Integer> iter = weight.iterator();
		int t = 0;
		
		while(iter.hasNext())
		{
			t = t + (Integer)iter.next();
		}
		
		return t;
	}
	
}