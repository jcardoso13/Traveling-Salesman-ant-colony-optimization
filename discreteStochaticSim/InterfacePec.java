package discreteStochaticSim;

import java.util.Collection;
import java.util.Comparator;

/********************************************************************************************
 * Iterface relativa a PEC. Se e necessario o uso de PEC com uma diferente implementaca
 * (como por exemplo: HashSet or algo parecido) pode ser feito implementando esta interface
 * 
 * @author Grupo 11
 *
 * @param <T> e um tipo generico para elementos da PEC
 ********************************************************************************************/

public interface InterfacePec<T> {
	
	/* ==== METODOS ==== */
	
	/**********************************************************************************************
	 * getNumbElem --- metodo getter do numero de elementos na PEC
	 * 
	 * @return o numero de elementos na Pec
	 **********************************************************************************************/
	public int getNumbElem();
	
	/**********************************************************************************************
	 * addElement -- metodo que adiciona o elemento na Pec. E necessario fornecer um comparador 
	 * que torne explicita a maneira como queremos classificar os elementos.
	 * @param  element e o elemento que queremos adicionar ao Pec
	 * @param c e o comparador que que queremos usar para classificar os elementos Pec
	 * @return true --- no caso de sucesso ou false-- no caso de insucesso
	 *********************************************************************************************/
	public boolean addElement(T element,Comparator<T> c);
	/*********************************************************************************************
	 * getElement -- metodo get do primeiro elemento da Pec. Este metodo nao so retorna o primeiro
	 * elemento como tambem o remove da lista Pec 
	 * @return o primeiro elemento da PEC que invoca o metodo 
	 *********************************************************************************************/
	public T getFirstElement();
	/**********************************************************************************************
	 * getElementList -- metodo get para toda a lista de elementos, isto permite iterar sobre isso
	 * @return o elemento da lista dentro da Pec 
	 **********************************************************************************************/
	public Collection<T> getElementList();
	/**********************************************************************************************
	 * toString -- metodo que substitui aquele com o mesmo nome na superclasse Object.  
	 **********************************************************************************************/
    public String toString();
	/**********************************************************************************************
	 * toStringOrdered -- metodo que imprime o PEC ordenada de acordo com a ordem dos elementos. 
	 * @return string da PEC ordenada 
	 **********************************************************************************************/
    public String toStringOrdered(); 

}
