package discreteStochaticSim;

import antColony.Ant;
import antColony.HamiltonianCycle;
import antColony.OptProblem;
import antColony.StochasticOptimProb;
import graph.Edge;
import graph.graph;

/**********************************************************************************
 *  Evapora��o das Feromonas 
 * 
 * 
 * 
 * @author Grupo 11
 *
 * <p> Esta subclasse � uma extens�o da classe Event abstrata e manipular�
 * os eventos de Evapora��o. Herda o tempo, mas no entanto n�o � necess�rio
 * saber o ind�viduo (ant), pelo que � definido a null, para que haja evapora��o das feromonas. 
 *****************************************************************************************/

public class Evaporation extends Event{

	/* ==== ATRIBUTOS ==== */
	/** quantidade de feromonas **/
	double quantidade;
	/** aresta considerando um sentido **/
	Edge<Integer,Integer> edge1;
	/** aresta considerando o sentido contr�rio **/
	Edge<Integer,Integer> edge2;
	
	/* ==== CONSTRUTOR ==== */
	/********************************************************************
	 * Este � o construtor. O que ele faz � chamar o construtor da super
	 * classe com os argumentos indicados. Ant � sempre null uma vez que
	 * n�o fazemos "target" a uma formiga em espec�fico.
	 * 
	 * @param t - instanto em que queremos evaporar as feromonas
	 * @param a - formiga, no entanto coloc�mos a null
	 * @param quant - quantidade de feromonas que ir� sendo atualizada
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
	 * ExecutaEvent -- Este m�todo � uma redefini��o do m�todo geral de evento 
	 * com o mesmo nome. Neste caso queremos ir atualizando a quantidade de
	 * feromonas nas arestas do grafo e adicionar ao pec o novo evento para a 
	 * evapora��o da feromona.
	 * 
	 * @param opp -- Problema de Optimiza��o com os dados todos a analisar  
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
