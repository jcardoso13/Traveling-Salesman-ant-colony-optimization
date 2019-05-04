package antcolony;

import graph.graph;

/**********************************************************************
 *  Interface para a otimização do Problema
 * 
 * 
 * @author group 11
 * 
 *  <p>OptProblem é usado no <code>Main</code> e permite fornecer 
 *  implementações alternativas de problemas de otimização. 
 *
 *********************************************************************/

public interface OptProblem {
	
	/**
	 * Este método deve funcionar como um construtor para um problema de otimização, configurando tud
	 * que é necessário para os métodos de simulação e execução.
	 *
	 * <p> A maioria dos parâmetros é auto-explicativa, uma vez que são os mesmos no documento do projeto.
	 *  @param antcolsize é o número máximo de formigas numa colonia
	 *  @param finalinst é o tempo máximo de simulação
	 *  @param plevel é o nível de ferómonas
	 *  @param alpha
	 *  @param beta
	 *  @param delta
	 *  @param eta
	 *  @param rho
	 *  @param graph<Integer,Integer> Gr
	 *  @param nbnodes
	 *  @param nestnode
	 * 
     **/

	
	void initialize(
			int nbnodes,
			int nestnode,
			double alpha,
			double beta,
			double delta,
			double eta,
			graph<Integer,Integer> Gr,
			double rho,
			double plevel,
			int antcolsize,
			double finalinst);
	
	/**
	 * Este método é responsável por executar a simulação por si mesma
	 **/
	void simulate();
	
	/***************
	 * Este método é todo o problema em um. Ele deve abrir o arquivo especificado nos argumentos, 
	 * analisá-lo adequadamente, inicializar o problema de otimização e, em seguida, chamar o método
	 * de simulação.
	 * 
	 * @param filename é o nome do arquivo que contém o teste
	 ****************/
	public void runOptimizationProblem(String filename);
	

}
