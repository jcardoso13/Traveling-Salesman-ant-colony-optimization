package discreteStochaticSim;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/***
 * PEC implementado com uma Priority Queue
 * 
 * @author grupo11
 * <p> Tipo gen�rico PEC. Sendo gen�rico do limite superior IEvent, 
 * podemos armazenar qualquer tipo de classe que implementa a interface 
 * Event no PEC. O PEC ser� sempre solicitado, portanto, precisamos fornecer 
 * o comparador ao adicionar elementos. O m�todo To String foi sobrescrito. 
 * 
 * @ Param <T> � o tipo que queremos usar no tipo parametrizado
 ***/

public class PriorityQueuePec<T extends InterfaceEvent> implements InterfacePec<T>{
	
	// Atributos
	private Queue<T> element_queue;
	private int num_elements;
	
	// Construtores
	/***
	 * Construtor para o PEC. N�o recebe argumentos e apenas inicializar� a 
	 * lista de matrizes.
	 * @param c comparador PEC implementado
	 ***/
	public PriorityQueuePec (Comparator<T>c) {
		element_queue = new PriorityQueue<T>(c);
	}
	
	//M�todos
	
	public int getNumElements() {
		return num_elements;
	}
	
	public boolean addElement(T element, Comparator<T> c) {
		element_queue.add(element);
		num_elements++;
		return true;
	}
	
	public T getFirstElement() {
		return element_queue.poll();
	}
	
	public Queue<T> getElementList(){
		return element_queue;
	}
	
    public String toString() {
        return "Pec: [" + element_queue + ", numEl=" + num_elements + "]";
    }
    
    public String toStringOrdered() {
        @SuppressWarnings("unchecked")
        List<Event> els = (List<Event>) new LinkedList<T>(element_queue);
        els.sort(Event.ec);

        return ("Pec: [" + els + ", numEl=" + num_elements + "]");
    }

}
