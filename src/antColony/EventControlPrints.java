package antColony;

import discreteStochaticSim.*;
import graph.graph;

/************************************************************************************
 *  Controlo dos Prints do Evento
 * 
 * @author Grupo 11
 * 
 * 	<p> Esta subclasse e uma extensao da classe Event abstrata e manipulara os eventos
 *  Control Print. Nao possui campos em si, mas herda o tempo e o individuo da superclasse.
 *  Individual e definido como nulo e o tempo e definido como um multiplo do tempo total 
 *  dividido por 20. Ele precisa sobrescrever os metodos Execute Event e toString.
 *
 ***********************************************************************************/


public class EventControlPrints extends Event {
	/* ==== ATRIBUTOS ==== */
	
	/* ==== CONSTRUTORES ==== */	
	/*********************************************************************************************
	 *  Este e o construtor. O que ele faz e chamar o construtor da super classe com 
	 *  os argumentos indicados. Ant e sempre null uma vez que nao fazemos "target"
	 *  a uma formiga em especifico.
	 *  
	 * @param time e o instante em que queremos imprimir a informacao de controlo
	 **********************************************************************************************/
	public EventControlPrints(double time) {
		super(time, null);
	}

	/* ==== METODOS ==== */
	/*********************************************************************************************
	 * Este metodo e uma redefinicao do metodo geral de evento com o mesmo nome.	 
	 * 
	 * @see discreteStochasticSim.Event#ExecutaEvent(antColony.OptProblem) para mais informacao.
	 * Neste caso em particular, temos que imprimir as informacoes de controle solicitadas no 
	 * enunciado do projeto.
	 * 
	 **********************************************************************************************/
	public void ExecutaEvent(OptProblem opP,graph<Integer,Integer> gr,HamiltonianCycle<Integer,Integer> hC) 
	{
        String formato1 = "%-35s %-16f\n";
        String formato2 = "%-35s %-17d\n";

		StochasticOptimProb op = (StochasticOptimProb) opP;
		
		int numControl = op.getNumControlPrint();
		
		op.setNumControlPrint(op.getNumControlPrint()+1);
        System.out.println("Observation " + numControl + ":");
        System.out.println("\t\t");
        System.out.printf(formato1,"Present Instant: ",op.getActual_time());
        System.out.println("\t\t");
		System.out.printf(formato2, "Number of move events: ",op.get_mevent());
        System.out.println("\t\t");
        System.out.printf(formato2, "Number of evaporation events: ",op.get_eevent());
        System.out.println("\t\t");
        System.out.print("Hamiltonian cycle: ");
        /**
         * falta o caminho ....
         */
        System.out.println();
	}

	/**********************************************************************************************
	 * toString -- metodo que substitui aquele com o mesmo nome na superclasse Object.  
	 * Uma vez que esta classa extende a superclasse que e abstracta e tem toString como metodo
	 * implica que esta redefinicao e obrigatoria
	 **********************************************************************************************/
	public String toString() {
		return ("(Type:ControlPrint" + ",Time:" + this.getTime() + " & No ant)");
	}

}
