package antColony;

import graph.graph;

/*********************************************************
 * Nesta classe é possível encontrar os parâmetros que são
 * extraídos do ficheiro .xml para posterior resolução do 
 * problema de optimização.
 * 
 * 
 * @author Grupo 11
 *
 *********************************************************/

class Parameters {
	
	/*1.parametros relacionados com o tempo*/
	/** Instante Final com que a simulação termina **/
	private double finalinst;
	/** Instante Atual **/
	private double actual_time;

	/*2.parametros relacionados com evento*/
	/** Parâmetro relacionado com o evento de movimento das formigas **/
	private double alpha;
	/** Parâmetro relacionado com o evento de movimento das formigas **/
	private double beta;
	/** Parâmetro relacionado com o evento de movimento das formigas **/
	private double delta;
	/** Parâmetro relacionado com o evento da evaporação das feromonas **/
	private double eta;
	/** Parâmetro relacionado com o evento da evaporação das feromonas **/
	private double rho;

	/*3.parametros relacionados com formiga*/
	/** Nível das Feromonas **/
	private double plevel;
	/** Dimensão da Colónia das Formigas **/
	private int antcolsize;
	
	/*4. parametros relacionados com o grafo*/
	/** Grafo do problema a otimizar  **/
	graph<Integer,Integer> Gr = new graph<Integer,Integer>();
	/** Número de Nós no grafo a implementar **/
	private int nbnodes;
	/** Nó inicial, isto é, aquele que as formigas consideram como ponto de partida **/
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
	 * @param finalTime - armazenar o parâmetro
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
	 * Setter dos Parâmetros do Movimento
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
     * Setter dos parâmetros de evaporação das feromonas
     * @param e -- eta
     * @param r -- ró
     ********************************************************/
    public void setEvapParam(double e, double r) 
    {
    	eta=e;
    	rho=r;
    }
    /********************************************************
     * Getter do Eta
     * @return eta - parametro relacionado com o evaporação
     *******************************************************/
    public double getEtha() 
    {
    	return eta;
    }
    /********************************************************
     * Getter do Ro
     * @return rho - parametro relacionado com a evaporação
     *******************************************************/
    public double getRho() 
    {
    	return rho;
    }
    
    /********************************************************
     * Getter do nível de feromonas 
     * @return plevel - parametro relacionado com o nível das 
     * feromonas
     *******************************************************/
    public double getPlevel() 
	{
		return plevel;
	}
    /********************************************************
     * Armzenamento do nível das feromonas
     * @param pL -- nível das feromonas
     * 
     ********************************************************/
	public void setPlevel(double pL) 
	{
		plevel = pL;
	}
    /********************************************************
     * Getter da dimensão da colónia de formigas
     * @return antcolsize - dimensão da colónia de formigas
     *******************************************************/
	public int getAntcolsize() 
	{
		return antcolsize;
	}
	/******************************************************
	 * Armazenamento da dimensão da colónia de formigas
	 * @param antsize -- dimensão da colónia de formigas
	 ******************************************************/
	public void setAntcolsize(int antsize)
	{
		antcolsize = antsize;
	}
	
	
    /********************************************************
     * Getter do número de nós no grafo 
     * @return nbnodes - número total de nós do grafo
     *******************************************************/
    public int getNbnodes() 
    {
		return nbnodes;
	}
    /************************************************************
     * Armazenamento do número total de nós
     * @param totalnode -- armazena o número total de nós 
     ***********************************************************/
	public void setNbnodes(int totalnode) 
	{
		nbnodes = totalnode;
	}
	/**********************************************************
	 * Getter do nó inicial que as formigas irão começar para 
	 * criar o caminho
	 * @return nestnode -- nó inicial para começar o path
	 **********************************************************/
	public int getNestnode() 
	{
		return nestnode;
	}
	/*********************************************************** 
	 * Armazenamento do nó inicial 
	 * @param nnode --- armazena o nestnode 
	 **********************************************************/
	public void setNestnode(int nnode) 
	{
		nestnode = nnode;
	}

	
}
