package antColony;


/**********************************************************************
 *  Interface para a otimização do Problema
 * 
 * 
 * @author Grupo 11
 * 
 *  <p>OptProblem é usado no <code>Main</code> e permite fornecer 
 *  implementções alternativas de problemas de otimizacao. 
 *
 *********************************************************************/


public interface OptProblem {
	
	/*****************************************************************************************************
	 * Este método é responsável por executar a simulação por si mesma.
	 *****************************************************************************************************/
	 void simulacao();
	 
	/******************************************************************************************************
	 * Este método é todo o problema num.Ele deve abrir o arquivo especificado nos argumentos, 
	 * analisá-lo adequadamente, inicializar o problema de otimização e, em seguida, chamar o método
	 * de simulação.
	 * 
	 * @param filename é o nome do arquivo que contém o teste
	 ******************************************************************************************************/
	 public void runOptimizationProb(String filename);
	 
}
