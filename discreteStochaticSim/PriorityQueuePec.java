package discreteStochaticSim;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
//import java.util.Queue;

/**********************************************************************************
 * PEC implementado com uma Priority Queue
 * 
 * @author grupo11
 * <p> Tipo generico PEC. Sendo generico do limite superior InterfaceEvent, 
 * podemos armazenar qualquer tipo de classe que implementa a interface 
 * Event no PEC. O PEC sera sempre solicitado, portanto, precisamos fornecer 
 * o comparador ao adicionar elementos. O metodo To String foi sobrescrito. 
 * 
 * @param <T> e o tipo que queremos usar no tipo parametrizado
 **********************************************************************************/

public class PriorityQueuePec<T extends InterfaceEvent> implements InterfacePec<T> {

	/* ==== ATRIBUTOS ==== */
	/** 
	 * Uma fila de prioridade ilimitada baseada em um heap de 
	 * prioridade. Os elementos da fila de prioridade são ordenados
	 * de acordo com sua ordenação natural ou por um Comparador 
	 * fornecido no tempo de construção da fila, dependendo de qual
	 * construtor está sendo utilizado. Uma fila de prioridade não
	 * permite elementos nulos. Uma fila de prioridade que depende
	 * de ordenação natural também não permite a inserção de objetos
	 * não comparáveis (isso pode resultar em ClassCastException).
	 ***/
	private PriorityQueue<T> element_queue;
	/***********************************************
	 * o numero de elementos queue na Pec
	 ***********************************************/
	private int numbElements;
	
	/* ==== CONSTRUTOR ==== */
	
	/******************************************************************************
	 * Construtor para o PEC. Nao recebe argumentos e apenas inicializara a 
	 * lista de array.
	 * @param c comparador PEC implementado
	 ******************************************************************************/
	public PriorityQueuePec(Comparator<T> c)
	{
		element_queue = new PriorityQueue<T>(c);
	}
	
	/* ==== METODOS ==== */
	
	
	/**********************************************************************************************
	 * getNumbElem --- metodo getter do numero de elementos na PEC
	 * 
	 * @return o numero de elementos na Pec
	 **********************************************************************************************/
	public int getNumbElem() 
	{
		return numbElements;
	}


	/**********************************************************************************************
	 * addElement -- metodo que adiciona o elemento na Pec. E necessario fornecer um comparador 
	 * que torne explicita a maneira como queremos classificar os elementos.
	 * @param  element e o elemento que queremos adicionar ao Pec
	 * @param c e o comparador que que queremos usar para classificar os elementos Pec
	 * @return true --- no caso de sucesso ou false-- no caso de insucesso
	 *********************************************************************************************/
	public boolean addElement(T element, Comparator<T> c) 
	{
		//element_queue.
		element_queue.add(element);
		//elEM.sort(Event.ec);
		//toStringOrdered()
		numbElements++;
		return true;
	}

	/*********************************************************************************************
	 * getElement -- metodo get do primeiro elemento da Pec. Este metodo nao so retorna o primeiro
	 * elemento como tambem o remove da lista Pec 
	 * @return o primeiro elemento da PEC que invoca o metodo 
	 *********************************************************************************************/	
	public T getFirstElement() 
	{
		return element_queue.poll();
	}

	/**********************************************************************************************
	 * getElementList -- metodo get para toda a lista de elementos, isto permite iterar sobre isso
	 * @return o elemento da lista dentro da Pec 
	 **********************************************************************************************/
	public Collection<T> getElementList() {
		return element_queue;
	}

	/**********************************************************************************************
	 * toString -- metodo que substitui aquele com o mesmo nome na superclasse Object.  
	 **********************************************************************************************/
	public String toString()
	{
		return "Pec: [" + element_queue + ", numeroElementos =" + numbElements + "]";
	}
	
	
	/**********************************************************************************************
	 * toStringOrdered -- metodo que imprime o PEC ordenada de acordo com a ordem dos elementos. 
     * @return string da PEC ordenada
	 **********************************************************************************************/
	public String toStringOrdered() 
	{
        @SuppressWarnings("unchecked")
        List<Event> els = (List<Event>) new LinkedList<T>(element_queue);
		els.sort(Event.ec);
		return ("Pec: [" + els + ", numeroElementos =" + numbElements + "]");
	}

}
