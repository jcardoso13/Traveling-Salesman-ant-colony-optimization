package antColony;

import java.util.LinkedList;


public class HCResults {
	
	LinkedList<Integer> path;
	int costTotal;

	public HCResults(LinkedList<Integer> p, int cT)
	{
		this.path =(LinkedList<Integer>)p.clone();
		this.costTotal =cT;
	}
	
	public String toString()
	{
		return "Path: " +path +"\n"+ "Cost:\n"+costTotal+ "\n";
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + costTotal;
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		return result;
	}

	public LinkedList<Integer> getPath() {
		return path;
	}

	public int getCostTotal() {
		return costTotal;
	}

	@Override
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
