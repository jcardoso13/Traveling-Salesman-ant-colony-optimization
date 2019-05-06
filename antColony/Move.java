package antColony;

import java.util.Iterator;

import discreteStochaticSim.Event;
import graph.*;

public class Move extends Event {

	/* ==== ATRIBUTOS ===== */
	
	/* ==== CONSTRUTORES ==== */
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
	 *  Este metodo e a redefinicao do metodo do Event geral com o mesmo nome.
	 *  
	 * @see discreteStochasticOptimProb.Event#ExecutaEvent(antColony.OptProblem) para mais 
	 * informacoes. Neste caso em particular podemos mover a formiga no evento para nodes
	 * validos. Precisamos de verificar por ciclos. Se detetarmos um caminho
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
		//System.out.println(ant);
		//System.out.println(ant.path.size() == op.getNbnodes());/* problema encontrado: o ciclo de hamiltion nunca termina */
		for(Edge<Integer,Integer> iter : gr.GetEdgeVector(ant.path.peekLast()))
		{
			if (ant.path.size() == op.getNbnodes() && iter.getLabel().equals(ant.path.peekFirst()))
			{
				hcCompleto = 1;
			}
		}
		
		if (hcCompleto == 1)
		{
			ed=gr.GetVertex(ant.path.peekLast()).getE().iterator();
			while(ed.hasNext())
			{
				Ed=ed.next();
				label=Ed.getLabel();
				if(label==op.getNestnode())
				{
					w=Ed.getWeight();
					ant.getCost().add(w);
					ant.getPath().add(op.getNestnode());
				}
				
			}
		//	System.out.println("Finished HC");
			//System.out.println("Dentro = "+ ant);
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
			else System.out.println("HELLO");
			pheromones_update = Event.expRandom(op.getPlevel()*op.getwTotal()/hcr.costTotal);
			//System.out.println(ant);
			Iterator<Integer> iter = ant.getPath().iterator();
			
			while(iter.hasNext())
			{
				aux1 = iter.next();
				if(iter.hasNext())
				{
					aux2 = iter.next();
					gr.FindE(aux1, aux2).setPheromones(gr.FindE(aux1,aux2).getPheromones()+ pheromones_update);
					gr.FindE(aux2, aux1).setPheromones(gr.FindE(aux2,aux1).getPheromones()+pheromones_update);
					op.getPec().addElement(new Evaporation(getTime()+Event.expRandom(op.getEtha()),null,op.getRho()),Event.ec);
				}
			}
			
			/* Apagou-se o caminho e o custo. Formigas voltam para o nestnode */
			ant.path.clear();
			ant.cost.clear();
			ant.path.add(op.getNestnode());
			ant.cost.add(0);
			
		}
		/* */
		tempo_percurso = Event.expRandom(op.getDelta());
		ant = hC.GetNextMove(ant);
		tempo_percurso = Event.expRandom(op.getDelta()*ant.getCost().getLast());
		
		op.getPec().addElement(new Move(getTime()+tempo_percurso,ant),Event.ec);
		
		
	}

	/*****************************************************************************
	 * toString metodo que substitui aquele com o mesmo nome na superclasse Object.
	 ****************************************************************************/
	public String toString() {
		return ("(Type:Move, AntID:,Time"
				+ this.getTime()
				+ ")");
	}


}
