package antColony;

import java.util.LinkedList;

/**************************************************************************
 * 
 * 
 * 
 * 
 * @author Grupo 11
 *
 *************************************************************************/

public class HCResults {
	
	/** **/
	LinkedList<Integer> path;
	/** **/
	public int costTotal;

	@SuppressWarnings("unchecked")
	/*************************************************
	 * 
	 * 
	 * 
	 * @param p
	 * @param cT
	 ************************************************/
	public HCResults(LinkedList<Integer> p, int cT)
	{
		this.path =(LinkedList<Integer>)p.clone();
		this.costTotal =cT;
	}
	
	/************************************************
	 * @return 
	 ***********************************************/
	public String toString()
	{
		return "Path: " +path +"\n"+ "Cost:\n"+costTotal+ "\n";
	}
	
	
	/****************************************************
	 * 
	 * 
	 * 
	 * 
	 ***************************************************/
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + costTotal;
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		return result;
	}

	/**************************************************
	 * 
	 * 
	 * 
	 * @return
	 **************************************************/
	public LinkedList<Integer> getPath() {
		return path;
	}

	/**************************************************
	 * @return
	 *
	 **************************************************/
	public int getCostTotal() {
		return costTotal;
	}

	/***************************************************
	 * 
	 * 
	 * 
	 **************************************************/
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HCResults other = (HCResults) obj;
		if (costTotal != other.costTotal)
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		return true;
	}
	
	
	
}
