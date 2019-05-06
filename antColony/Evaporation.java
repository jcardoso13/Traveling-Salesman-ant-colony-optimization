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
		Iterator <Edge<Integer,Integer>> iter;
		while (iter2.hasNext())
		{
			iter = iter2.next().getE().iterator();
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
					aux1.setPheromones(aux2);
					op.getPec().addElement(new Evaporation(getTime()+Event.expRandom(op.getEtha()),null,op.getRho()),Event.ec);
				}
			}			
		}

		op.getPec().addElement(new Evaporation(getTime()+ expRandom(op.getEtha()),null,op.getRho()), ec);
	}
	
	/*****************************************************************************
	 * toString metodo que substitui aquele com o mesmo nome na superclasse Object.
	 ****************************************************************************/
	public String toString() 
	{
		return null;
	}

}
