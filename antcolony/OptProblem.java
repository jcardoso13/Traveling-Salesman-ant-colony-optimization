package antcolony;

import graph.graph;

/**********************************************************************
 *  Interface para a otimiza��o do Problema
 * 
 * 
 * @author group 11
 * 
 *  <p>OptProblem � usado no <code>Main</code> e permite fornecer 
 *  implementa��es alternativas de problemas de otimiza��o. 
 *
 *********************************************************************/

public interface OptProblem {
	
	/**
	 * Este m�todo deve funcionar como um construtor para um problema de otimiza��o, configurando tud
	 * que � necess�rio para os m�todos de simula��o e execu��o.
	 *
	 * <p> A maioria dos par�metros � auto-explicativa, uma vez que s�o os mesmos no documento do projeto.
	 *  @param antcolsize � o n�mero m�ximo de formigas numa colonia
	 *  @param finalinst � o tempo m�ximo de simula��o
	 *  @param plevel � o n�vel de fer�monas
	 *  @param alpha
	 *  @param beta
	 *  @param delta
	 *  @param eta
	 *  @param rho
	 *  @param graph<Integer,Integer> Gr
	 *  @param nbnodes
	 *  @param nestnode
	 * 
�����**/

	
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
	 * Este m�todo � respons�vel por executar a simula��o por si mesma
	 **/
	void simulate();
	
	/***************
	 * Este m�todo � todo o problema em um. Ele deve abrir o arquivo especificado nos argumentos, 
	 * analis�-lo adequadamente, inicializar o problema de otimiza��o e, em seguida, chamar o m�todo
	 * de simula��o.
	 * 
	 * @param filename � o nome do arquivo que cont�m o teste
	 ****************/
	public void runOptimizationProblem(String filename);
	

}
