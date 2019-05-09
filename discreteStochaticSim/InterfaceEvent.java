package discreteStochaticSim;

import antColony.HamiltonianCycle;
import antColony.OptProblem;
import graph.graph;

/**
 * Interface para a classe dos eventos 
 *  
 * @author Grupo 11
 * 
 * <p>InterfaceEvent e usado em <code>PEC</code> e mais especificadamente em <code>PriorityQueue</code>
 *
 */


public interface InterfaceEvent{
	
	/***************************************************************************************
	 * Este m�todo � a redefini��o do m�todo do Event geral com o mesmo nome.
	 *  
	 * 
	 * @param opp -- Problema de Optimiza��o com os dados todos a analisar  
	 * @param gr -- grafo do problema a optimizar
	 * @param hc -- ciclo hamiltoniano
	 **************************************************************************************/
	public abstract void ExecutaEvent(OptProblem opp,graph<Integer,Integer> gr,HamiltonianCycle<Integer,Integer> hc);

}
