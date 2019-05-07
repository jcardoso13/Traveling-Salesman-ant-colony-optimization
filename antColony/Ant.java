package antColony;

import java.util.Iterator;
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
	//LinkedList<Integer> path;
	//LinkedList<Integer> cost ;
	private LinkedList<pathw> p;
	private boolean hit;
	
	/* ===== CONSTRUTOR ===== */
	public Ant(int nest)
	{
		pathw aux= new pathw(nest,0);
		//cost = new LinkedList<Integer>();
		//path = new LinkedList<Integer>();
		p= new LinkedList<pathw>();
		setHit(false);
		p.add(aux);
	}
	
	
	/* ===== METODOS ==== */
	/** @param hit -- armazena o hit **/
	public void setHit(boolean h) 
	{
		hit = h;
	}
	/** @return hit **/
	public boolean getHit()
	{
		return hit;
	}
	/** @param path -- armazena o caminho **/
	
	void setP(LinkedList<pathw> path)
	{
		p=path;
	}
	public LinkedList<pathw> getP()
	{
		return p;
	}
	
	
	public LinkedList<Integer> getPath()
	{
		Iterator<pathw> it= p.iterator();
		LinkedList<Integer> n= new LinkedList<Integer>();
		while(it.hasNext())
		{
			n.add(it.next().path);
		}
		return n;
	}
	public LinkedList<Integer> getCost()
	{
		Iterator<pathw> it= p.iterator();
		LinkedList<Integer> n= new LinkedList<Integer>();
		while(it.hasNext())
		{
			n.add(it.next().Cost);
		}
		return n;
	}
	
	public String toString()
	{
		return p.toString();
	}

}
