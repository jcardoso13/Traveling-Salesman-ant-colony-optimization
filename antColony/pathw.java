package antColony;

public class pathw {
	
	Integer path;
	Integer Cost;
	
	public pathw(Integer p, Integer c)
	{
		path=p;
		Cost=c;
	}

	public Integer getPath() {
		return path;
	}

	public void setPath(Integer path) {
		this.path = path;
	}

	public Integer getCost() {
		return Cost;
	}

	public void setCost(Integer cost) {
		Cost = cost;
	}
	
	public String toString() 
	{
		return " N- " + path + " C- " + Cost;
	}	

}
