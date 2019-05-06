package antColony;


/**********************************************************************
 *  Interface para a otimizacao do Problema
 * 
 * 
 * @author group 11
 * 
 *  <p>OptProblem e usado no <code>Main</code> e permite fornecer 
 *  implementacoes alternativas de problemas de otimizacao. 
 *
 *********************************************************************/


public interface OptProblem {
	
	/*****************************************************************************************************
	 * Este metodo e responsavel por executar a simulacao por si mesma
	 *****************************************************************************************************/
	 void simulacao();
	 
	/******************************************************************************************************
	 * Este metodo e todo o problema num. Ele deve abrir o arquivo especificado nos argumentos, 
	 * analisa-lo adequadamente, inicializar o problema de otimizacao e, em seguida, chamar o metodo
	 * de simulacao.
	 * 
	 * @param filename e o nome do arquivo que contem o teste
	 ******************************************************************************************************/
	 public void runOptimizationProb(String filename);
	 
}
