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
	
	public abstract void ExecutaEvent(OptProblem opp,graph<Integer,Integer> gr,HamiltonianCycle<Integer,Integer> hc);

}
