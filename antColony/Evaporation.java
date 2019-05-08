package antColony;

import discreteStochaticSim.Event;
import graph.Edge;
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
	Edge<Integer,Integer> edge1;
	Edge<Integer,Integer> edge2;
	public Evaporation(double t, Ant a,double quant,Edge<Integer,Integer> ed1,Edge<Integer,Integer>ed2) 
	{
		super(t, null);
		edge1=ed1;
		edge2=ed2;
		
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
		//Edge<Integer,Integer> edge1=(Edge<Integer,Integer>)obj;
		//Edge<Integer,Integer> ed1=(Edge<Integer,Integer>)obj2;
		StochasticOptimProb op = (StochasticOptimProb) opp;
		double aux2=0;
		
		aux2=this.edge1.getPheromones()-quantidade;
		if (aux2 <= 0)
		{
			this.edge1.setPheromones(0);
			this.edge2.setPheromones(0);	
		}
		else
		{
			this.edge1.setPheromones(aux2);
			this.edge2.setPheromones(aux2);
			op.getPec().addElement(new Evaporation(op.p.getActual_time()+Event.expRandom(op.p.getEtha()),null,op.p.getRho(),this.edge1,this.edge2),Event.ec);
			
		}
		
		
		//Edge<Integer,Integer> aux1;
		//Iterator<Vertex<Integer,Integer>> iter2 = gr.getG().iterator();
		//Vertex<Integer,Integer> a;
		//Iterator <Edge<Integer,Integer>> iter;
		/*while (iter2.hasNext())
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
						op.getPec().addElement(new Evaporation(op.getActual_time()+Event.expRandom(op.getEtha()),null,op.getRho()),Event.ec);
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
		
		*/
		
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
