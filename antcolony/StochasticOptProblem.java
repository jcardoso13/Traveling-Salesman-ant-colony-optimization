package antcolony;

import java.util.*;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import discreteStochaticSim.Event;
import discreteStochaticSim.InterfacePec;
import discreteStochaticSim.PriorityQueuePec;
import graph.*;

/***********************
 * 
 * 
 * @author grupo 11
 *
 **********************/

public class StochasticOptProblem implements OptProblem {

	//ATRIBUTOS
	
	/* campos relacionados com o tempo */
	private double actualTime;
	private double maxTime;
	private double finalinst;
	
	/* campos relacionados com o evento */
	private int obsnum=0;
	private int mevents=0; // number of move events
	private int eevents=0; // number of evaporation events
	private double alpha,beta,delta;
	private double rho,eta;
	private InterfacePec<Event> pec;
	
	/* campos relacionados com o grafo */
	private graph<Integer,Integer> Gr = new graph<Integer,Integer>();
	private int nestnode;
	private int nbnodes;
	boolean b;
	/* campos relacionados com as formigas */
	private final List<Ant> list_ants;
	private int antcolsize;
	private double plevel;
    /**
     * Construtor sem argumentos para o problema de otimização. 
     * Tudo o que faz é criar as listas vazias que serão usadas.
     **/
	public StochasticOptProblem() {
		setPec(new PriorityQueuePec<Event>(Event.ec));
		list_ants = new LinkedList<Ant>();
	}

	public StochasticOptProblem(
			int max_ants,
			int max_time,
			double a,
			double b,
			double d,
			double r,
			double e,
			double pLev) {
		this();
		setActual_time(0);
		maxTime = max_time;
		antcolsize=max_ants;
		setMoveParam(a,b,d);
		setEvapParam(r,e);
		
	}
	
	
	
	public void initialize(int nbnodes, int nestnode, double alpha, double beta, double delta, double eta,
			graph<Integer, Integer> Gr, double rho, double plevel, int antcolsize, double finalinst) {
		
		setActual_time(0);
		
	}

	public void simulate() {
		Event ev;
		
		
		
	}

	
	public void runOptimizationProblem(String filename) {
		readXMl(filename);
		System.out.println(Gr);
	}	
	
	
	
    private void readXMl(String filename) {
    	
    	try
    	{
    		DocumentBuilder docBuild = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    		Document d = docBuild.parse("."+filename);
    		d.getDocumentElement().normalize();
    		
    		Node root = d.getDocumentElement();
    		Element element;
    		element = (Element)root;
    		finalinst = Double.parseDouble(element.getAttribute("finalinst"));
			plevel = Double.parseDouble(element.getAttribute("plevel"));
			antcolsize = Integer.parseInt(element.getAttribute("antcolsize"));
			
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
			nbnodes = Integer.parseInt(element.getAttribute("nbnodes"));
			nestnode = Integer.parseInt(element.getAttribute("nestnode"))-1;
			
			NodeList weightsNode;
			Node node;
			int nodeidx=0,weight,neigh=0;
			/* Construction of the graph*/
			for (int i=0; i<nodesOfGraph.getLength();i++)
			{
				nodeCurr = nodesOfGraph.item(i);
				if (nodeCurr!= null && nodeCurr.getNodeType() == Node.ELEMENT_NODE)
				{
					weightsNode = nodeCurr.getChildNodes();
					element = (Element)nodeCurr;
					nodeidx = Integer.parseInt(element.getAttribute("nodeidx"));
					b = Gr.addVertex(nodeidx);
					
					for (int m=0; m <weightsNode.getLength();m++)
					{
						node = weightsNode.item(m);
						if (node != null && node.getNodeType()==Node.ELEMENT_NODE)
						{
							element = (Element)node;
							neigh=Integer.parseInt(element.getAttribute("targetnode"));
							b = Gr.addVertex(neigh);
							weight = Integer.parseInt(element.getTextContent());
							b = Gr.addE(nodeidx, neigh, weight);
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
						setMoveParam(
								Double.parseDouble(element.getAttribute("alpha")),
								Double.parseDouble(element.getAttribute("beta")),
								Double.parseDouble(element.getAttribute("delta")));
				
					}
					else if (nodeCurr.getNodeName()== "evaporation")
					{
						setEvapParam(
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

	public void setActual_time(double actual_time) {
        this.actualTime = actual_time;
    }
    
    public double getActual_time() {
    	return this.actualTime ;
    }
    
    public void setMoveParam(double alfa, double bet,double del) {
    	this.alpha = alfa;
    	this.beta = bet;
    	this.delta=del;
    }
    public double getAlpha() {
    	return alpha;
    }
    public double getBeta() {
    	return beta;
    }  
    public double getDelta() {
    	return delta;
    }         
    public void setEvapParam(double et, double ro) {
    	this.eta=et;
    	this.rho=ro;
    }
    
    public double getEtha() {
    	return eta;
    }
    public double getRho() {
    	return rho;
    }  
    
    public void setGraph(graph<Integer,Integer> gr) {
    	this.Gr=gr;
    }
    public graph<Integer,Integer> getGraph() {
    	return Gr;
    }
    
    public InterfacePec<Event> getPec(){
    	return pec;
    }
    
    public void setPec(InterfacePec<Event> pec) {
    	this.pec = pec;
    }
    
    public void setPheromonesLevel(double pLevel)
    {
    	this.plevel = pLevel;
    }
}
