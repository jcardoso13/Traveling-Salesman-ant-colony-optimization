package discreteStochaticSim;

import java.util.Comparator;
/**************************************************************
 * Comparador entre Eventos
 * 
 * @author Grupo 11
 *	<p> Classe que e usada somente para comparar Eventos baseando
 *	nos seus tempos. Quando usado com o metodo list.sort (Comparador),
 *  ele classificara uma lista de eventos pelo menor tempo primeiro.
 *  Ele implementa a interface do Comparador substituindo o metodo 
 *  de comparacao.
 *************************************************************/

public class EventComparator implements Comparator<Event> {
	
	
	/********************************************************
	 * Metodo que substitui o metodo comparador. Ele recebe dois
	 * argumentos e retorna um inteiro baseado na comparacao do 
	 * campo de tempo dos argumentos.
	 * @param event1 e o primeiro evento que queremos comparar.
	 * @param event2 e o segundo evento que queremos comparar.
	 *   
	 * @return e -1 se o primeiro tiver menor tempo, +1 se for
	 * o contrario e 0 se for o mesmo.
	 * 
	 ********************************************************/
	public int compare (Event event1, Event event2) {
		double time1 = event1.getTime();
		double time2 = event2.getTime();
		
		return time1 < time2 ? -1 : time1 > time2 ? +1 : 0;
	}
}

