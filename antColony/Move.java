package antColony;

import java.util.Iterator;

import discreteStochaticSim.Event;
import graph.*;


/***********************************************************************************************
 * Movimento das formigas pelo grafo de forma a encontrar um caminho
 * 

 * @author Grupo 11
 * <p> Esta subclasse é uma extensão da classe Event abstrata e manipulará os eventos de movimento
 * das formigas. Herda o tempo e também a formiga em específico que se irá mover.
 ***********************************************************************************************/
public class Move extends Event {

	/* ==== ATRIBUTOS ===== */
	
	/* ==== CONSTRUTOR ==== */
	/***************************************************************************************
	 *  Este e o construtor. A unica coisa que faz e chamar o construtor da superclasse com
	 *  os argumentos do Evento.
	 *  
	 * @param t -- tempo do movimento
	 * @param a -- formiga associado ao evento
	 **************************************************************************************/
	public Move(double t, Ant a) 
	{
		super(t, a);
	}

	/* ==== METODOS ==== */

	/***************************************************************************************
	 * Este método é a redefinição do método do Event geral com o mesmo nome.
	 *  
	 * Neste caso em particular podemos mover a formiga no evento para nodes válidos. 
	 * Precisamos de verificar por ciclos.
	 * 
	 * 
	 * @param opp -- Problema de Optimização com os dados todos a analisar  
	 * @param gr -- grafo do problema a optimizar
	 * @param hC -- ciclo hamiltoniano
	 **************************************************************************************/
	public void ExecutaEvent(OptProblem opp,graph<Integer,Integer> gr,HamiltonianCycle<Integer,Integer> hC) 
	{
		int hcCompleto = 0, aux1=0 ,aux2=0;
		double pheromones_update,tempo_percurso=0;
		HCResults hcr;
		Integer label;
		int n=0;
		Integer w;
		Edge<Integer,Integer> Ed;
		Iterator<Edge<Integer,Integer>> ed;
		Iterator<HCResults> iterH;
		
		StochasticOptimProb op = (StochasticOptimProb) opp;
		Ant ant = this.getAnt(); 
		
		if(gr.getG().isEmpty())
			return;
		if(gr.getG().get(0).getE().isEmpty())
			return;
			
		//System.out.println(ant);
		for(Edge<Integer,Integer> iter : gr.GetEdgeVector(ant.getP().peekLast().getPath()))
		{
			if (ant.getP().size() == op.p.getNbnodes() && iter.getLabel().equals(ant.getP().peekFirst().getPath()))
			{
				hcCompleto = 1;
			}
		}
		
		if (hcCompleto == 1)
		{
			ed=gr.GetVertex(ant.getP().peekLast().getPath()).getE().iterator();
			while(ed.hasNext())
			{
				Ed=ed.next();
				label=Ed.getLabel();
				if(label==op.p.getNestnode())
				{
					w=Ed.getWeight();
					ant.getP().add(new pathw(op.p.getNestnode(),w));
				}
				
			}
			hcr = new HCResults(ant.getPath(),hC.calculate_cost(ant.getCost()));
			iterH=op.hamcycle.iterator();
			while(iterH.hasNext())
			{
			if(iterH.next().equals(hcr))
				n=1;
			}
			
			if(n==0)
			{
				op.hamcycle.add(hcr);
			}
			pheromones_update = Event.expRandom(op.p.getPlevel()*(op.getwTotal()/hcr.costTotal));
			Iterator<pathw> iter = ant.getP().iterator();
			
			while(iter.hasNext())
			{
				aux1 = iter.next().getPath();
				if(iter.hasNext())
				{
					
					aux2 = iter.next().getPath();
					if(gr.FindE(aux1,aux2).getPheromones()==0)
						op.getPec().addElement(new Evaporation(op.p.getActual_time()+Event.expRandom(op.p.getEtha()),null,op.p.getRho(),gr.FindE(aux1,aux2),gr.FindE(aux2,aux1)),Event.ec);
					
					gr.FindE(aux1, aux2).setPheromones(gr.FindE(aux1,aux2).getPheromones()+ pheromones_update);
					gr.FindE(aux2, aux1).setPheromones(gr.FindE(aux2,aux1).getPheromones()+pheromones_update);
				}
			}
			ant.getP().clear();
			ant.getP().add(new pathw(op.p.getNestnode(),0));
			
		}
		/* */
		tempo_percurso = Event.expRandom(op.p.getDelta());
		ant = hC.GetNextMove(ant);
		tempo_percurso = Event.expRandom(op.p.getDelta()*ant.getP().getLast().getCost());
		
		op.getPec().addElement(new Move(op.p.getActual_time()+tempo_percurso,ant),Event.ec);
		
		
	}

	/*****************************************************************************
	 * toString método que substitui aquele com o mesmo nome na superclasse Object.
	 ****************************************************************************/
	public String toString() {
		return ("(Type:Move,Time"+ this.getTime()+ ")");
	}


}
