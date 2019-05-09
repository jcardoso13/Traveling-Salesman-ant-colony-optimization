/***********************************************************************
 * Project: Traveling Salesman Ant Colony Optimization
 *
 * Object Oriented Programming 
 * 2o Semestre 2018/2019
 *
 * Realizado por: 			(Grupo 11)
 * 					Matilde Moreira, numero 84137
 * 					Joao Pedro Cardoso, numero 84096
 * 					Carolina Cunha, numero 79656
 *
 * Ultima data modificacao: 06/05/2019
 * Nome do Ficheiro: Main.java - classe usada para testar o programa
 **********************************************************************/
package main;


import antColony.OptProblem;
import antColony.StochasticOptimProb;

public class Main {

	/*************************************************************************
	 * Main - metodo usado para testar o programa so precisa de um argumento
	 * de entrada que corresponde ao xml com os parametros de entrada
	 * 
	 * @author Grupo 11
	 * @param args - nome do ficheiro de teste a ser usado
	 *************************************************************************/
	public static void main(String[] args) 
	{
		
		/* 1 - Verifica se foi indicado algum argumento (i.e. ficheiro .xml) para alem da invocacao do programa */
		if (args.length != 1) {
			System.out.println("ERRO - Deve indicar o nome do ficheiro de entrada .xml!");
			System.exit(-1);
		}
		
	
		/* 2 - Criacao de uma nova otimizacao do problema  */
		OptProblem opt = new StochasticOptimProb();
		
		/* 3 - Execucao do referido problema de otimizacao. A analise, inicializacao e execucao sao feitos */
		opt.runOptimizationProb(args[0]);
	
	
	}

}
