package antColony;

import graph.graph;

/*********************************************************
 * Nesta classe e possivel encontrar os parametros que sao
 * extraidos do ficheiro .xml para posterior resolucao do 
 * problema de optimizacao.
 * 
 * 
 * @author Grupo 11
 *
 *********************************************************/

public class Parameters {
	
	/*1.parametros relacionados com o tempo*/
	/** Instante Final com que a simulacao termina **/
	private double finalinst;
	/** Instante Atual **/
	private double actual_time;

	/*2.parametros relacionados com evento*/
	/** Parametro relacionado com o evento de movimento das formigas **/
	private double alpha;
	/** Parametro relacionado com o evento de movimento das formigas **/
	private double beta;
	/** Parametro relacionado com o evento de movimento das formigas **/
	private double delta;
	/** Parametro relacionado com o evento da evaporacao das feromonas **/
	private double eta;
	/** Parametro relacionado com o evento da evaporacao das feromonas **/
	private double rho;

	/*3.parametros relacionados com formiga*/
	/** Nivel das Feromonas **/
	private double plevel;
	/** Dimensao da Colonia das Formigas **/
	private int antcolsize;
	
	/*4. parametros relacionados com o grafo*/
	/** Grafo do problema a otimizar  **/
	graph<Integer,Integer> Gr = new graph<Integer,Integer>();
	/** Numero de Nos no grafo a implementar **/
	private int nbnodes;
	/** No inicial, isto e, aquele que as formigas consideram como ponto de partida **/
	private int nestnode;

	
	
	
	/*****************************************************
	 * Getter do Instante Final
	 * @return the finalinst
	 *****************************************************/
	public double getFinalinst() {
		return finalinst;
	}

	/******************************************************
	 * Setter do Instante Final
	 * @param finalTime - armazenar o parametro
	 ******************************************************/
	public void setFinalinst(double finalTime) {
		finalinst = finalTime;
	}

    /******************************************************
     * Getter do Instante Atual
     * @return o actual_time 
     *****************************************************/
    public double getActual_time() 
    {
        return actual_time;
    }
    /****************************************************
     * Armazenamento do instante Atual 
     * @param aT -- tempo atual 
     ****************************************************/
    public void setActual_time(double aT) 
    {
        actual_time = aT;
    }
	/*****************************************************
	 * Setter dos Parametros do Movimento
	 * @param a -- alpha
	 * @param b -- beta
	 * @param d -- delta
	 ****************************************************/
    public void setMoveParam(double a, double b,double d) 
    {
    	alpha = a;
    	beta = b;
    	delta=d;
    }
    /********************************************************
     * Getter do Alfa
     * @return alpha - parametro relacionado com o movimento
     *******************************************************/
    public double getAlpha() 
    {
    	return alpha;
    }

    /********************************************************
     * Getter do Beta
     * @return beta - parametro relacionado com o movimento
     *******************************************************/
    public double getBeta() 
    {
    	return beta;
    }  
    /********************************************************
     * Getter do Delta
     * @return delta - parametro relacionado com o movimento
     *******************************************************/
    public double getDelta() 
    {
    	return delta;
    }   
    /********************************************************
     * Setter dos parametros de evaporacao das feromonas
     * @param e -- eta
     * @param r -- ro
     ********************************************************/
    public void setEvapParam(double e, double r) 
    {
    	eta=e;
    	rho=r;
    }
    /********************************************************
     * Getter do Eta
     * @return eta - parametro relacionado com o evaporacao
     *******************************************************/
    public double getEtha() 
    {
    	return eta;
    }
    /********************************************************
     * Getter do Ro
     * @return rho - parametro relacionado com a evaporacao
     *******************************************************/
    public double getRho() 
    {
    	return rho;
    }
    
    /********************************************************
     * Getter do nivel de feromonas 
     * @return plevel - parametro relacionado com o nivel das 
     * feromonas
     *******************************************************/
    public double getPlevel() 
	{
		return plevel;
	}
    /********************************************************
     * Armzenamento do nivel das feromonas
     * @param pL -- nivel das feromonas
     * 
     ********************************************************/
	public void setPlevel(double pL) 
	{
		plevel = pL;
	}
    /********************************************************
     * Getter da dimensao da colonia de formigas
     * @return antcolsize - dimensao da colonia de formigas
     *******************************************************/
	public int getAntcolsize() 
	{
		return antcolsize;
	}
	/******************************************************
	 * Armazenamento da dimensao da colonia de formigas
	 * @param antsize -- dimensao da colonia de formigas
	 ******************************************************/
	public void setAntcolsize(int antsize)
	{
		antcolsize = antsize;
	}
	
	
    /********************************************************
     * Getter do numero de nos no grafo 
     * @return nbnodes - numero total de nos do grafo
     *******************************************************/
    public int getNbnodes() 
    {
		return nbnodes;
	}
    /************************************************************
     * Armazenamento do numero total de nos
     * @param totalnode -- armazena o numero total de nos 
     ***********************************************************/
	public void setNbnodes(int totalnode) 
	{
		nbnodes = totalnode;
	}
	/**********************************************************
	 * Getter do no inicial que as formigas irao comecar para 
	 * criar o caminho
	 * @return nestnode -- no inicial para comecar o path
	 **********************************************************/
	public int getNestnode() 
	{
		return nestnode;
	}
	/*********************************************************** 
	 * Armazenamento do no inicial 
	 * @param nnode --- armazena o nestnode 
	 **********************************************************/
	public void setNestnode(int nnode) 
	{
		nestnode = nnode;
	}

	
}
