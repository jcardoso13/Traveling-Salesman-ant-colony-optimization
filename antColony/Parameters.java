package antColony;

import graph.graph;

public class Parameters {
	
	/*1.parametros relacionados com o tempo*/
	private double finalinst;
	private double actual_time;

	/*2.parametros relacionados com evento*/
	private double alpha;
	private double beta;
	private double delta;
	private double eta;
	private double rho;

	/*3.parametros relacionados com formiga*/
	private double plevel;
	private int antcolsize;//total;
	
	/*4. parametros relacionados com o grafo*/
	public graph<Integer,Integer> Gr = new graph<Integer,Integer>();
	private int nbnodes;
	private int nestnode;

	
	
	
	/**
	 * @return the finalinst
	 */
	public double getFinalinst() {
		return finalinst;
	}

	/**
	 * @param finalinst the finalinst to set
	 */
	public void setFinalinst(double finalTime) {
		finalinst = finalTime;
	}

    /** @return o actual_time */
    public double getActual_time() 
    {
        return actual_time;
    }
    /** @param actual_time -- armazenamento do tempo atual */
    public void setActual_time(double aT) 
    {
        actual_time = aT;
    }
	
    public void setMoveParam(double a, double b,double d) 
    {
    	alpha = a;
    	beta = b;
    	delta=d;
    }
    public double getAlpha() 
    {
    	return alpha;
    }
    public double getBeta() 
    {
    	return beta;
    }  
    public double getDelta() 
    {
    	return delta;
    }   
    public void setEvapParam(double e, double r) 
    {
    	eta=e;
    	rho=r;
    }
    public double getEtha() 
    {
    	return eta;
    }
    public double getRho() 
    {
    	return rho;
    }
    
    
    public double getPlevel() 
	{
		return plevel;
	}
	public void setPlevel(double pL) 
	{
		plevel = pL;
	}
	public int getAntcolsize() 
	{
		return antcolsize;
	}
	public void setAntcolsize(int antsize)
	{
		antcolsize = antsize;
	}
	
	
	/** @return o numero total de nos*/
    public int getNbnodes() 
    {
		return nbnodes;
	}
    /** @param nbnodes -- armazena o numero total de nos **/
	public void setNbnodes(int totalnode) 
	{
		nbnodes = totalnode;
	}
	/** @return o nestnode  **/
	public int getNestnode() 
	{
		return nestnode;
	}
	/** @param nnode --- armazena o nestnode **/
	public void setNestnode(int nnode) 
	{
		nestnode = nnode;
	}

	
}
