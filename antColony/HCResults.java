package antColony;

import java.util.LinkedList;

/**************************************************************************
 * HCResults is the class that stores a newly found unique path
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
	 * Copies the ant's path and total cost to this instance
	 * 
	 * @param p
	 * @param cT
	 ************************************************/
	public HCResults(LinkedList<Integer> p, int cT)
	{
		if(p!=null)
		this.path =(LinkedList<Integer>)p.clone();
		else
		this.path=null;
		this.costTotal =cT;
	}
	
	/************************************************
	 * 
	 * @return 
	 ***********************************************/
	public String toString()
	{
		return "Path: " +path +"\n"+ "Cost:\n"+costTotal+ "\n";
	}
	
	
	/****************************************************
	 * 
	 * 
	 * hashCode method for equals
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
	 * Returns the path
	 * 
	 * @return
	 **************************************************/
	public LinkedList<Integer> getPath() {
		return path;
	}

	/**************************************************
	 * Returns the total cost
	 * @return
	 *
	 **************************************************/
	public int getCostTotal() {
		return costTotal;
	}

	/***************************************************
	 * 
	 * Equals method to check if it's unique or not
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
