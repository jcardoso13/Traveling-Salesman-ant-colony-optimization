package antColony;

import java.util.Iterator;
import java.util.LinkedList;


/***********************************************************************************************
 * Esta é a classe para as formigas.Cada formiga deve ter associada a si um caminho (path), o total 
 * do custo do seu caminho.
 * Um agente mantém uma lista: - uma lista de histórico para acompanhar o caminho que cobriu 
 * até agora;
 * @author Grupo 11
 *
 **********************************************************************************************/

public class Ant {
	
	/* ===== ATRIBUTOS ===== */
	
	/*****************************************************************
	 * Lista ligada do caminho da formiga tendo em conta os custos.
	 ****************************************************************/
	private LinkedList<pathw> p;

	
	/* ===== CONSTRUTOR ===== */
	/***************************************************************
	 * Construtor cujo objetivo é criar um objeto formiga com o seu
	 * caminho a começar no nestnode -- ponto de partida.
	 * 
	 * @param nest Ponto de Partida no grafo
	 **************************************************************/
	public Ant(int nest)
	{
		pathw aux= new pathw(nest,0);
		p= new LinkedList<pathw>();
		p.add(aux);
	}
	
	
	/* ===== METODOS ==== */
	/**********************************************
	 * Getter do caminho da formiga pelo grafo
	 * já considerando os custos.
	 * @return p - path (caminho) da formiga 
	 **********************************************/
	public LinkedList<pathw> getP() {
		return p;
	}

	/********************************************
	 * Armazenamento (setter) do caminho da formiga
	 * @param p -  path (caminho) da formiga
	 ********************************************/
	public void setP(LinkedList<pathw> path) {
		p = path;
	}
	
	/*********************************************
	 * Getter do caminho da formiga pelo grafo
	 * Usado para imprimir o caminho no fim.
	 * @return n - path (caminho) da formiga
	 ********************************************/
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
	
	/**********************************************
	 * Getter do custo do caminho da formiga.
	 * 
	 * @return n - custo do caminho da formiga
	 **********************************************/
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
	
	
	/*********************************************
	 * 
	 * @return o caminho da formiga como string
	 * para ser impresso.
	 *********************************************/
	public String toString()
	{
		return p.toString();
	}
	


}
