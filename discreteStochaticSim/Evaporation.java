package discreteStochaticSim;

import antColony.Ant;
import antColony.HamiltonianCycle;
import antColony.OptProblem;
import antColony.StochasticOptimProb;
import graph.Edge;
import graph.graph;

/**********************************************************************************
 *  Evaporação das Feromonas 
 * 
 * 
 * 
 * @author Grupo 11
 *
 * <p> Esta subclasse é uma extensão da classe Event abstrata e manipulará
 * os eventos de Evaporação. Herda o tempo, mas no entanto não é necessário
 * saber o indíviduo (ant), pelo que é definido a null, para que haja evaporação das feromonas. 
 *****************************************************************************************/

public class Evaporation extends Event{

	/* ==== ATRIBUTOS ==== */
	/** quantidade de feromonas **/
	double quantidade;
	/** aresta considerando um sentido **/
	Edge<Integer,Integer> edge1;
	/** aresta considerando o sentido contrário **/
	Edge<Integer,Integer> edge2;
	
	/* ==== CONSTRUTOR ==== */
	/********************************************************************
	 * Este é o construtor. O que ele faz é chamar o construtor da super
	 * classe com os argumentos indicados. Ant é sempre null uma vez que
	 * não fazemos "target" a uma formiga em específico.
	 * 
	 * @param t - instanto em que queremos evaporar as feromonas
	 * @param a - formiga, no entanto colocámos a null
	 * @param quant - quantidade de feromonas que irá sendo atualizada
	 * @param ed1 - edge considerando um sentido 
	 * @param ed2 - edge considerando o sentido oposto 
	 *********************************************************************/
	public Evaporation(double t, Ant a,double quant,Edge<Integer,Integer> ed1,Edge<Integer,Integer>ed2) 
	{
		super(t, null);
		edge1=ed1;
		edge2=ed2;
		
		quantidade = quant;
	}
	
	/* ==== METODOS ==== */
	/**************************************************************************
	 * ExecutaEvent -- Este método é uma redefinição do método geral de evento 
	 * com o mesmo nome. Neste caso queremos ir atualizando a quantidade de
	 * feromonas nas arestas do grafo e adicionar ao pec o novo evento para a 
	 * evaporação da feromona.
	 * 
	 * @param opp -- Problema de Optimização com os dados todos a analisar  
	 * @param gr -- grafo do problema a optimizar
	 * @param hc -- ciclo hamiltoniano
	 **************************************************************************/
	
	public void ExecutaEvent(OptProblem opp,graph<Integer,Integer> gr,HamiltonianCycle<Integer,Integer> hc) 
	{
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
	
	}
	

}
