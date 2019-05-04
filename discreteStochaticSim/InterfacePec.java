package discreteStochaticSim;

import java.util.Collection;
import java.util.Comparator;

public interface InterfacePec<T> {
	
	public int getNumElements();
	public boolean addElement(T element, Comparator<T> c);
	public T getFirstElement();
	public Collection<T> getElementList();
	public String toString();
	public String toStringOrdered();
	

}
