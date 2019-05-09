package antColony;

import discreteStochaticSim.*;
import graph.graph;

/************************************************************************************
 *  Controlo dos Prints do Evento
 * 
 * @author Grupo 11
 * 
 * 	<p> Esta subclasse e uma extensão da classe Event abstrata e manipulara os eventos
 *  Control Print. Nao possui campos em si, mas herda o tempo e o individuo da superclasse.
 *  Individual e definido como nulo e o tempo e definido como um multiplo do tempo total 
 *  dividido por 20. Ele precisa sobrescrever os metodos Execute Event e toString.
 *
 ***********************************************************************************/


public class EventControlPrints extends Event {
	/* ==== ATRIBUTOS ==== */
	
	/* ==== CONSTRUTORES ==== */	
	/*********************************************************************************************
	 *  Este é o construtor.O que ele faz é chamar o construtor da super classe com 
	 *  os argumentos indicados. Ant é sempre null uma vez que não fazemos "target"
	 *  a uma formiga em especifico.
	 *  
	 * @param time é o instante em que queremos imprimir a informação de controlo.
	 **********************************************************************************************/
	EventControlPrints(double time) {
		super(time, null);
	}

	/* ==== METODOS ==== */
	/*********************************************************************************************
	 * Este método é uma redefinição do método geral de evento com o mesmo nome.	 
	 * 
	 * Neste caso em particular, temos que imprimir as informações de controle solicitadas no 
	 * enunciado do projeto.
	 * 
	 * @param opP -- Problema de Optimização com os dados todos a analisar  
	 * @param gr -- grafo do problema a optimizar
	 * @param hC -- ciclo hamiltoniano
	 **********************************************************************************************/
	public void ExecutaEvent(OptProblem opP,graph<Integer,Integer> gr,HamiltonianCycle<Integer,Integer> hC) 
	{
        String formato1 = "%-35s %-16f\n";
        String formato2 = "%-35s %-17d\n";
        HCResults opt;

		StochasticOptimProb op = (StochasticOptimProb) opP;
		
		int numControl = op.getNumControlPrint();
		
		op.setNumControlPrint(op.getNumControlPrint()+1);
        System.out.println("Observation " + numControl + ":");
        System.out.println("\t\t");
        System.out.printf(formato1,"Present Instant: ",op.p.getActual_time());
        System.out.println("\t\t");
		System.out.printf(formato2, "Number of move events: ",op.get_mevent());
        System.out.println("\t\t");
        System.out.printf(formato2, "Number of evaporation events: ",op.get_eevent());
        System.out.println("\t\t");
        opt=op.findOpt();
        if(!opt.getPath().isEmpty())
        System.out.print("Hamiltonian cycle: " + opt);
        System.out.println();
	}

}
