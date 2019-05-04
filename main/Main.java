/***********************************************************************
 * Project: Traveling Salesman Ant Colony Optimization
 *
 * Object Oriented Programming 
 * 2o Semestre 2018/2019
 *
 * Realizado por: 			(Grupo 11)
 * 					Matilde Moreira, numero 84137
 * 					Joao Pedro Cardoso, numero 84096
 * 					Carolina Cunha, numero 
 *
 * Ultima data modificacao: 04/05/2019
 * Nome do Ficheiro: Main.java - classe usada para testar o programa
 **********************************************************************/
package main; /* package em que esta inserida a classe Main.java */

import antcolony.*;

public class Main {
	
	/****
	 * Main - metodo usado para testar o programa so precisa de um argumento
	 * de entrada que corresponde ao xml com os parametros de entrada
	 * 
	 * @author grupo 11
	 * @param args - nome do ficheiro de teste a ser usado
	 */

	public static void main(String[] args) {
		
		if (args.length != 1) {
			System.out.println("ERRO - Deve indicar o nome do ficheiro de entrada .xml!");
			System.exit(-1);
		}
	
		System.out.println(args[0]); //apagar
		

		
		/* Criacao de uma nova otimizacao do problema */
		OptProblem op = new StochasticOptProblem();

		/* Execucao do referido problema de optimizacao. A analise, inicilizacao e execucao sao feitos.*/
		op.runOptimizationProblem(args[0]);
	
	}
	
	

}
