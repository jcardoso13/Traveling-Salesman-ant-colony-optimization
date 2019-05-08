package antColony;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import discreteStochaticSim.Event;
import discreteStochaticSim.InterfacePec;
import discreteStochaticSim.PriorityQueuePec;


/**************************************************************************************************************
 *  Classe da Otimizacao do Problema
 *  E importante salientar que existem 4 atributos que nao sao estaticos:relacionados com o tempo, grafo, 
 *  evento, formiga.
 *  
 * @author Grupo 11
 *
 *************************************************************************************************************/

public class StochasticOptimProb implements OptProblem {
	
	/* =========== ATRIBUTOS ============ */
	
	Parameters p;
	
	/*1.parametros relacionados com o tempo*/
	private double ctrl_time; 
	
	/*2.parametros relacionados com evento*/
	private int numControlPrint ;
	private int mevent = 0 ;
	private int eevent = 0;
	private InterfacePec<Event> pec;
	
	/*3.parametros relacionados com formiga*/
	private final List<Ant> list_ants;
	LinkedList <HCResults> hamcycle = new LinkedList<HCResults>();
	HamiltonianCycle<Integer,Integer> hC;
	
	/*4. parametros relacionados com o grafo*/
	private int wTotal=0;
	boolean b;


	/* =========== CONSTRUTOR ============ */
    /************************************************************
     * Construtor sem argumentos para o problema de otimizacao. 
     * Tudo o que faz e criar as listas vazias que serao usadas.
     ************************************************************/
	public StochasticOptimProb() 
	{
		setPec(new PriorityQueuePec<Event>(Event.ec));
		p = new Parameters();
		list_ants = new LinkedList<Ant>();
	}

	
	public void simulacao() {
		
		Event ev;
		//Event aux;
		/* ========================= SIMULACAO ===========================*/
		while (p.getActual_time()<=p.getFinalinst())
		{
			ev = this.getPec().getFirstElement(); // passa para o proximo evento do PEC
			//System.out.println(ev);
			
			if(ev != null)
			{
				p.setActual_time(ev.getTime()); // Avanco rapido ate a hora de executa-lo
				//System.out.println(actual_time);
				if (ev.getClass() == Move.class)
				{
					this.set_mevent(this.get_mevent()+1);
					//System.out.println();
					//System.out.println("mmevent = " + mevent);
					
				}
				else if (ev.getClass() == Evaporation.class)
				{
					this.set_eevent(this.get_eevent()+1);
					//System.out.println(actual_time);
					//System.out.println();
					//System.out.println("eevent = "+ eevent);
				}
				else if(ev.getClass() == EventControlPrints.class)
				{
					//System.out.println(Gr.getG().get(2));
				}
				ev.ExecutaEvent(this,p.Gr,hC);	
				
			}
			else break;


		}
		
	}

	
	public void runOptimizationProb(String filename) {
		readXML(filename);
		
		  System.out.println(p.Gr); hC = new
		  HamiltonianCycle<Integer,Integer>(p.getAlpha(),p.getBeta(),p.Gr);
		  p.setActual_time(0); ctrl_time = p.getFinalinst()/20;
		  
		  //Adiciona as impressoes do controlo de Evento ao PEC 
		  for (int i = 0; i < p.getAntcolsize(); i++) 
		  { 
			  Ant a = new Ant(p.getNestnode());
			  getList_ants().add(a); getPec().addElement(new Move(0,a),Event.ec);
		  
		  } for (int j = 0; j <= 20; j++ ) 
		  {
			  getPec().addElement(new EventControlPrints(ctrl_time*j+0.0000000001), Event.ec); 
		  }
		  this.simulacao();
		 
		//System.out.println(hamcycle);
		//System.out.println(p.Gr);

	}
	
	
	
	private void readXML(String filename) 
    {
    	try
    	{
    		DocumentBuilder docBuild = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    		Document d = docBuild.parse("."+filename);
    		d.getDocumentElement().normalize();  		
    		Node root = d.getDocumentElement();
    		Element element;
    		element = (Element)root;
    		p.setFinalinst(Double.parseDouble(element.getAttribute("finalinst")));
    		System.out.println(p.getFinalinst());
    		p.setPlevel(Double.parseDouble(element.getAttribute("plevel")));
    		p.setAntcolsize(Integer.parseInt(element.getAttribute("antcolsize")));
    		
    		NodeList childNodes = root.getChildNodes();
    		NodeList nodesOfGraph = null, eventList=null;
    		Node nodeCurr,graph=null,event = null;
    		for ( int i = 0; i< childNodes.getLength(); i++)
    		{
    			nodeCurr = childNodes.item(i);
    			if (nodeCurr != null)
    			{
    				if (nodeCurr.getNodeName() == "events")
    				{
    					event = nodeCurr;
    					eventList = event.getChildNodes();
    				}
    				else if (nodeCurr.getNodeName()=="graph")
    				{
    					graph = nodeCurr;
    					nodesOfGraph = graph.getChildNodes();				
    				}
    			}
    		}
    		element = (Element)graph;
    		p.setNbnodes(Integer.parseInt(element.getAttribute("nbnodes")));
    		p.setNestnode(Integer.parseInt(element.getAttribute("nestnode")));
    		NodeList weightsNode;
    		Node node;
    		int nodeidx=0,weight,neigh=0;
    		for (int i=0; i<nodesOfGraph.getLength();i++)
    		{
    			nodeCurr = nodesOfGraph.item(i);
    			if (nodeCurr!= null && nodeCurr.getNodeType() == Node.ELEMENT_NODE)
    			{
    				weightsNode = nodeCurr.getChildNodes();
    				element = (Element)nodeCurr;
    				nodeidx = Integer.parseInt(element.getAttribute("nodeidx"));
    				

    				b = p.Gr.addVertex(nodeidx);
    				
    				for (int m=0; m <weightsNode.getLength();m++)
    				{
    					node = weightsNode.item(m);
    					if (node != null && node.getNodeType()==Node.ELEMENT_NODE)
    					{
    						element = (Element)node;
    						neigh=Integer.parseInt(element.getAttribute("targetnode"));
    						b = p.Gr.addVertex(neigh);
    						weight = Integer.parseInt(element.getTextContent());
    						b = p.Gr.addE(nodeidx, neigh, weight);
    						setwTotal(getwTotal() + weight);
    					}						
    				}
    				
    			}				
    		}
    		for (int i=0; i<eventList.getLength(); i++)
    		{
    			nodeCurr = eventList.item(i);
    			if (nodeCurr != null && nodeCurr.getNodeType() == Node.ELEMENT_NODE)
    			{
    				element = (Element)nodeCurr;
    				if (nodeCurr.getNodeName()=="move")
    				{
    					p.setMoveParam(
    							Double.parseDouble(element.getAttribute("alpha")),
    							Double.parseDouble(element.getAttribute("beta")),
    							Double.parseDouble(element.getAttribute("delta")));
    			
    				}
    				else if (nodeCurr.getNodeName()== "evaporation")
    				{
    					p.setEvapParam(
    							Double.parseDouble(element.getAttribute("eta")),
    							Double.parseDouble(element.getAttribute("rho")));
    				}
    			}
    		}
    	}
    	catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
    }

    /** @return the numControlPrint */
    public int getNumControlPrint() 
    {
        return numControlPrint;
    }
    /** @param numControlPrint armazenamento desta variavel*/
    public void setNumControlPrint(int numCP) 
    {
        numControlPrint = numCP;
    }

    /** @param mevent -- armazenado o numero de move events */
    public void set_mevent(int mev)
    {
    	mevent = mev;
    }  
    /** @return o mmevent */
    public int get_mevent()
    {
    	return mevent;
    }
    /** @param eevent -- armazenado o numero de eventos de evaporacao */
    public void set_eevent(int eev)
    {
    	eevent = eev;
    }  
    /** @return o eevent -- numero de eventos evaporacao */
    public int get_eevent()
    {
    	return eevent;
    }    
    /** @return the pec */
    public InterfacePec<Event> getPec() 
    {
        return pec;
    }
    /** @param pec the pec to set */
    public void setPec(InterfacePec<Event> p) 
    {
        pec = p;
    }
	public List<Ant> getList_ants() 
	{
		return list_ants;
	}
	public int getwTotal() 
	{
		return wTotal;
	}
	public void setwTotal(int wT) 
	{
		wTotal = wT;
	}
	
	public HCResults findOpt()
	{
	Iterator<HCResults> it= hamcycle.iterator();
	HCResults aux;
	HCResults ret= new HCResults(new LinkedList<Integer>(),0);
	int Min=999999999;
	while(it.hasNext())
	{
		aux=it.next();
		if(Min>aux.getCostTotal())
		{
			ret=aux;
			Min=aux.getCostTotal();
		}
	}
	return ret;
	}


}
