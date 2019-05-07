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
		
		if(gr.getG().isEmpty())
			return;
		if(gr.getG().get(0).getE().isEmpty())
			return;
			
		//System.out.println(ant);
		//System.out.println(ant.path.size() == op.getNbnodes());/* problema encontrado: o ciclo de hamiltion nunca termina */
		for(Edge<Integer,Integer> iter : gr.GetEdgeVector(ant.getP().peekLast().getPath()))
		{
			if (ant.getP().size() == op.getNbnodes() && iter.getLabel().equals(ant.getP().peekFirst().getPath()))
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
				if(label==op.getNestnode())
				{
					w=Ed.getWeight();
					ant.getP().add(new pathw(op.getNestnode(),w));
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
			pheromones_update = Event.expRandom(op.getPlevel()*(op.getwTotal()/hcr.costTotal));
			Iterator<pathw> iter = ant.getP().iterator();
			
			while(iter.hasNext())
			{
				aux1 = iter.next().getPath();
				if(iter.hasNext())
				{
					
					aux2 = iter.next().getPath();
					if(gr.FindE(aux1,aux2).getPheromones()==0)
						op.getPec().addElement(new Evaporation(op.getActual_time()+Event.expRandom(op.getEtha()),null,op.getRho(),gr.FindE(aux1,aux2),gr.FindE(aux2,aux1)),Event.ec);
					
					gr.FindE(aux1, aux2).setPheromones(gr.FindE(aux1,aux2).getPheromones()+ pheromones_update);
					gr.FindE(aux2, aux1).setPheromones(gr.FindE(aux2,aux1).getPheromones()+pheromones_update);
				}
			}
			ant.getP().clear();
			ant.getP().add(new pathw(op.getNestnode(),0));
			
		}
		/* */
		tempo_percurso = Event.expRandom(op.getDelta());
		ant = hC.GetNextMove(ant);
		tempo_percurso = Event.expRandom(op.getDelta()*ant.getP().getLast().getCost());
		
		op.getPec().addElement(new Move(op.getActual_time()+tempo_percurso,ant),Event.ec);
		
		
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
