package antColony;

import java.util.LinkedList;


/***********************************************************************************************
 * Esta e a classe para as formigas
 * 
 * Cada formiga deve ter associada a si um caminho (path), o total do custo do seu caminho 
 * e um booleano designado por hit para indicar se cada formiga atingiu a meta.
 * Um agente mantem uma listas: - uma lista de historico para acompanhar o caminho que cobriu 
 * ate agora;
 * @author Grupo 11
 *
 **********************************************************************************************/

public class Ant {
	
	/* ===== ATRIBUTOS ===== */
	LinkedList<Integer> path;
	LinkedList<Integer> cost ;
	private boolean hit;
	
	/* ===== CONSTRUTOR ===== */
	public Ant(int nest)
	{
		cost = new LinkedList<Integer>();
		path = new LinkedList<Integer>();
		setHit(false);
		path.add(nest); 
		cost.add(0);
	}
	
	
	/* ===== METODOS ==== */
	/** @param hit -- armazena o hit **/
	public void setHit(boolean hit) 
	{
		this.hit = hit;
	}
	/** @return hit **/
	public boolean isHit()
	{
		return hit;
	}
	/** @param path -- armazena o caminho **/
	public void setPath(LinkedList<Integer> path)
	{
		this.path = path;
	}
	/** @return the path **/
	public LinkedList<Integer> getPath()
	{
		return path;
	}
	/** @return the cost */
	public LinkedList<Integer> getCost() 
	{
		return cost;
	}	
	/** @param cost -- armazena o custo do caminho **/
	public void setCost(LinkedList<Integer> cost) 
	{
		this.cost = cost;
	}


}
