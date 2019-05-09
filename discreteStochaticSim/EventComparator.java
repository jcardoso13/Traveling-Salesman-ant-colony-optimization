package discreteStochaticSim;

import java.util.Comparator;
/**************************************************************
 * Comparador entre Eventos
 * 
 * @author Grupo 11
 *	<p> Classe que � usada somente para comparar Eventos baseando
 *	nos seus tempos. Quando usado com o m�todo list.sort (Comparador),
 *  ele classificar� uma lista de eventos pelo menor tempo primeiro.
 *  Ele implementa a interface do Comparador substituindo o m�todo 
 *  de compara��o.
 *************************************************************/

public class EventComparator implements Comparator<Event> {
	
	
	/********************************************************
	 * M�todo que substitui o m�todo comparador. Ele recebe dois
	 * argumentos e retorna um inteiro baseado na compara��o do 
	 * campo de tempo dos argumentos.
	 * @param event1 � o primeiro evento que queremos comparar.
	 * @param event2 � o segundo evento que queremos comparar.
	 *   
	 * @return � -1 se o primeiro tiver menor tempo, +1 se for
	 * o contr�rio e 0 se for o mesmo.
	 * 
	 ********************************************************/
	public int compare (Event event1, Event event2) {
		double time1 = event1.getTime();
		double time2 = event2.getTime();
		
		return time1 < time2 ? -1 : time1 > time2 ? +1 : 0;
	}
}

