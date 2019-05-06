package antColony;

import java.util.Iterator;

import discreteStochaticSim.Event;
import graph.Edge;
import graph.Vertex;
import graph.graph;

/************************************************************************
 * 
 * 
 * 
 * 
 * @author Grupo 11
 *
 ************************************************************************/

public class Evaporation extends Event{

	double quantidade;
	public Evaporation(double t, Ant a,double quant) 
	{
		super(t, null);
		quantidade = quant;
	}

	/**************************************************************************
	 * ExecutaEvent --
	 * 
	 * @param op 
	 * 
	 **************************************************************************/
	public void ExecutaEvent(OptProblem opp,graph<Integer,Integer> gr,HamiltonianCycle<Integer,Integer> hc) 
	{
		StochasticOptimProb op = (StochasticOptimProb) opp;
		double aux2=0;
		Edge<Integer,Integer> aux1;
		Iterator<Vertex<Integer,Integer>> iter2 = gr.getG().iterator();
		Vertex<Integer,Integer> a;
		Iterator <Edge<Integer,Integer>> iter;
		while (iter2.hasNext())
		{
			a= iter2.next();
			iter=a.getE().iterator();
			while(iter.hasNext())
			{
				aux1 = iter.next();
				aux2 = aux1.getPheromones()-quantidade;
				if (aux2 <= 0)
				{
					aux1.setPheromones(0);
					
				}
				else 
				{
					if(!aux1.getEvap())
					{
						aux1.setPheromones(aux2);
						aux1.setEvap(true);
						aux1=gr.FindE(aux1.getLabel(),a.getLabel());
						aux1.setPheromones(aux2);
						aux1.setEvap(true);
						op.getPec().addElement(new Evaporation(getTime()+Event.expRandom(op.getEtha()),null,op.getRho()),Event.ec);
					}
				}
			}			
		}
		iter2 = gr.getG().iterator();
		
		while (iter2.hasNext())
		{
			iter=iter2.next().getE().iterator();
			while(iter.hasNext())
			{
				iter.next().setEvap(false);
			}
		}
		
		//op.getPec().addElement(new Evaporation(getTime()+ expRandom(op.getEtha()),null,op.getRho()), Event.ec);
	}
	
	/*****************************************************************************
	 * toString metodo que substitui aquele com o mesmo nome na superclasse Object.
	 ****************************************************************************/
	public String toString() 
	{
		return null;
	}

}
