package antColony;

import graph.graph;

/*********************************************************
 * Nesta classe � poss�vel encontrar os par�metros que s�o
 * extra�dos do ficheiro .xml para posterior resolu��o do 
 * problema de optimiza��o.
 * 
 * 
 * @author Grupo 11
 *
 *********************************************************/

class Parameters {
	
	/*1.parametros relacionados com o tempo*/
	/** Instante Final com que a simula��o termina **/
	private double finalinst;
	/** Instante Atual **/
	private double actual_time;

	/*2.parametros relacionados com evento*/
	/** Par�metro relacionado com o evento de movimento das formigas **/
	private double alpha;
	/** Par�metro relacionado com o evento de movimento das formigas **/
	private double beta;
	/** Par�metro relacionado com o evento de movimento das formigas **/
	private double delta;
	/** Par�metro relacionado com o evento da evapora��o das feromonas **/
	private double eta;
	/** Par�metro relacionado com o evento da evapora��o das feromonas **/
	private double rho;

	/*3.parametros relacionados com formiga*/
	/** N�vel das Feromonas **/
	private double plevel;
	/** Dimens�o da Col�nia das Formigas **/
	private int antcolsize;
	
	/*4. parametros relacionados com o grafo*/
	/** Grafo do problema a otimizar  **/
	graph<Integer,Integer> Gr = new graph<Integer,Integer>();
	/** N�mero de N�s no grafo a implementar **/
	private int nbnodes;
	/** N� inicial, isto �, aquele que as formigas consideram como ponto de partida **/
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
	 * @param finalTime - armazenar o par�metro
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
	 * Setter dos Par�metros do Movimento
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
     * Setter dos par�metros de evapora��o das feromonas
     * @param e -- eta
     * @param r -- r�
     ********************************************************/
    public void setEvapParam(double e, double r) 
    {
    	eta=e;
    	rho=r;
    }
    /********************************************************
     * Getter do Eta
     * @return eta - parametro relacionado com o evapora��o
     *******************************************************/
    public double getEtha() 
    {
    	return eta;
    }
    /********************************************************
     * Getter do Ro
     * @return rho - parametro relacionado com a evapora��o
     *******************************************************/
    public double getRho() 
    {
    	return rho;
    }
    
    /********************************************************
     * Getter do n�vel de feromonas 
     * @return plevel - parametro relacionado com o n�vel das 
     * feromonas
     *******************************************************/
    public double getPlevel() 
	{
		return plevel;
	}
    /********************************************************
     * Armzenamento do n�vel das feromonas
     * @param pL -- n�vel das feromonas
     * 
     ********************************************************/
	public void setPlevel(double pL) 
	{
		plevel = pL;
	}
    /********************************************************
     * Getter da dimens�o da col�nia de formigas
     * @return antcolsize - dimens�o da col�nia de formigas
     *******************************************************/
	public int getAntcolsize() 
	{
		return antcolsize;
	}
	/******************************************************
	 * Armazenamento da dimens�o da col�nia de formigas
	 * @param antsize -- dimens�o da col�nia de formigas
	 ******************************************************/
	public void setAntcolsize(int antsize)
	{
		antcolsize = antsize;
	}
	
	
    /********************************************************
     * Getter do n�mero de n�s no grafo 
     * @return nbnodes - n�mero total de n�s do grafo
     *******************************************************/
    public int getNbnodes() 
    {
		return nbnodes;
	}
    /************************************************************
     * Armazenamento do n�mero total de n�s
     * @param totalnode -- armazena o n�mero total de n�s 
     ***********************************************************/
	public void setNbnodes(int totalnode) 
	{
		nbnodes = totalnode;
	}
	/**********************************************************
	 * Getter do n� inicial que as formigas ir�o come�ar para 
	 * criar o caminho
	 * @return nestnode -- n� inicial para come�ar o path
	 **********************************************************/
	public int getNestnode() 
	{
		return nestnode;
	}
	/*********************************************************** 
	 * Armazenamento do n� inicial 
	 * @param nnode --- armazena o nestnode 
	 **********************************************************/
	public void setNestnode(int nnode) 
	{
		nestnode = nnode;
	}

	
}
