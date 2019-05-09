package discreteStochaticSim;

import java.util.Comparator;
/**************************************************************
 * Comparador entre Eventos
 * 
 * @author Grupo 11
 *	<p> Classe que é usada somente para comparar Eventos baseando
 *	nos seus tempos. Quando usado com o método list.sort (Comparador),
 *  ele classificará uma lista de eventos pelo menor tempo primeiro.
 *  Ele implementa a interface do Comparador substituindo o método 
 *  de comparação.
 *************************************************************/

public class EventComparator implements Comparator<Event> {
	
	
	/********************************************************
	 * Método que substitui o método comparador. Ele recebe dois
	 * argumentos e retorna um inteiro baseado na comparação do 
	 * campo de tempo dos argumentos.
	 * @param event1 é o primeiro evento que queremos comparar.
	 * @param event2 é o segundo evento que queremos comparar.
	 *   
	 * @return é -1 se o primeiro tiver menor tempo, +1 se for
	 * o contrário e 0 se for o mesmo.
	 * 
	 ********************************************************/
	public int compare (Event event1, Event event2) {
		double time1 = event1.getTime();
		double time2 = event2.getTime();
		
		return time1 < time2 ? -1 : time1 > time2 ? +1 : 0;
	}
}

