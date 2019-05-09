package antColony;


/**********************************************************************
 *  Interface para a otimiza��o do Problema
 * 
 * 
 * @author Grupo 11
 * 
 *  <p>OptProblem � usado no <code>Main</code> e permite fornecer 
 *  implement��es alternativas de problemas de otimizacao. 
 *
 *********************************************************************/


public interface OptProblem {
	
	/*****************************************************************************************************
	 * Este m�todo � respons�vel por executar a simula��o por si mesma.
	 *****************************************************************************************************/
	 void simulacao();
	 
	/******************************************************************************************************
	 * Este m�todo � todo o problema num.Ele deve abrir o arquivo especificado nos argumentos, 
	 * analis�-lo adequadamente, inicializar o problema de otimiza��o e, em seguida, chamar o m�todo
	 * de simula��o.
	 * 
	 * @param filename � o nome do arquivo que cont�m o teste
	 ******************************************************************************************************/
	 public void runOptimizationProb(String filename);
	 
}
