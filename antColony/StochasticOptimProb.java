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

import discreteStochaticSim.Evaporation;
import discreteStochaticSim.Event;
import discreteStochaticSim.EventControlPrints;
import discreteStochaticSim.InterfacePec;
import discreteStochaticSim.Move;
import discreteStochaticSim.PriorityQueuePec;


/**************************************************************************************************************
 *  Classe da Otimizacao do Problema.E importante salientar que existem 4 atributos que nao sao estaticos:
 *  relacionados com o tempo, grafo, evento, formiga.
 *  
 * @author Grupo 11
 *
 *************************************************************************************************************/

public class StochasticOptimProb implements OptProblem {
	
	/* =========== ATRIBUTOS ============ */
	/** parametros armazenados sobre o problema a resolver **/
	public Parameters p;
	
	/*1.parametros relacionados com o tempo*/
	/** tempo de controlo que corresponde ao quociente entre o instante final e 20 **/
	private double ctrl_time; 
	
	/*2.parametros relacionados com evento*/
	/** numero de observacoes que irao ser imprimidas **/
	private int numControlPrint ;
	/** numero de eventos de movimento **/
	private int mevent = 0 ;
	/**numero de eventos de evaporacao **/
	private int eevent = 0;
	/** Interface relativa a PEC **/
	private InterfacePec<Event> pec;
	/** numero de Controlo para imprimir as observacoes **/
	private static int numero_controlo = 20;
	
	/*3.parametros relacionados com formiga*/
	/** Lista das Formigas  **/
	private final List<Ant> list_ants;
	/** Lista ligada dos ciclos hamiltonianos */
	public LinkedList <HCResults> hamcycle = new LinkedList<HCResults>();
	/** Ciclo hamiltoniano **/
	HamiltonianCycle<Integer,Integer> hC;
	
	/*4. parametros relacionados com o grafo*/
	/** Peso total considerando todas as arestas **/
	private int wTotal=0;
	/** Booleano de controlo dos dados obtidos pelo grafo **/
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

	/* ========= METODOS ============= */
	/************************************************************
	 * Metodo que simula o movimento das formigas pelo grafo para
	 * encontrar o ciclo hamiltoniano e regressam ao no inicial.
	 * E voltam a percorrer novamente o grafo para encontrar um novo 
	 * ciclo hamiltoniano, tudo isto tendo em conta a evaporacao das
	 * feromonas nas arestas.
	 ***********************************************************/
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
				//if (ev.getClass() == Move.class)
				if(ev instanceof Move)
				{
					this.set_mevent(this.get_mevent()+1);
					//System.out.println();
					//System.out.println("mmevent = " + mevent);
					
				}
				//else if (ev.getClass() == Evaporation.class)
<<<<<<< HEAD
				else if(ev instanceof Evaporation)
=======
				else if( ev instanceof Evaporation)
>>>>>>> master
				{
					this.set_eevent(this.get_eevent()+1);
					//System.out.println(actual_time);
					//System.out.println();
					//System.out.println("eevent = "+ eevent);
				}
				//else if(ev.getClass() == EventControlPrints.class)
				else if(ev instanceof EventControlPrints)
				{
					//DEBUG CODE
					//System.out.println(Gr.getG().get(2));
				}
				ev.ExecutaEvent(this,p.Gr,hC);	
				
			}
			else break;


		}
		
	}
	
	/******************************************************************************************************
	 * Este metodo e todo o problema num.Ele deve abrir o arquivo especificado nos argumentos, 
	 * analisa-lo adequadamente, inicializar o problema de otimizacao e, em seguida, chamar o metodo
	 * de simulacao.
	 * 
	 * @param filename e o nome do arquivo que contem o teste.
	 ******************************************************************************************************/
	public void runOptimizationProb(String filename) {
		readXML(filename);
		hC = new HamiltonianCycle<Integer,Integer>(p.getAlpha(),p.getBeta(),p.Gr);
		p.setActual_time(0); ctrl_time = p.getFinalinst()/numero_controlo;
		  
		//Adiciona as impressoes do controlo de Evento ao PEC 
		for (int i = 0; i < p.getAntcolsize(); i++) 
		{ 
			Ant a = new Ant(p.getNestnode());
			getList_ants().add(a); getPec().addElement(new Move(0,a),Event.ec);
		  
		} 
		
		for (int j = 0; j <= numero_controlo; j++ ) 
		{
			getPec().addElement(new EventControlPrints(ctrl_time*j+0.0000000001), Event.ec); 
		}
		this.simulacao();
<<<<<<< HEAD
		 
		//System.out.println(hamcycle);
		//System.out.println(p.Gr);
=======
>>>>>>> master

	}
	
	
	/****************************************************************
	 * Metodo para leitura de um ficheiro XML recorrendo Document Object Model
	 * que cria uma arvore que representa todo o documento.
	 * 
	 * @param filename -- ficheiro de teste, test_i, com i =1,...5
	 * 
	 ****************************************************************/
	 
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
    		p.setPlevel(Double.parseDouble(element.getAttribute("plevel")));
    		p.setAntcolsize(Integer.parseInt(element.getAttribute("antcolsize")));
    		
    		if (p.getFinalinst()<0)
    		{
    			throw(new Exception("Parametro invalido FinalInst"));
    		}
    		
    		if (p.getAntcolsize()<0)
    		{
    			throw(new Exception("Parametro invalido da dimensao da colonia de formigas"));
    		}
    		
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
    		
    		if (p.getNbnodes()<0 || p.getNestnode()<0)
    		{
    			throw(new Exception("Parametros Invalidos do Grafo "));
    		}
    		
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
    				
    				if (nodeidx < 0)
    				{
    	    			throw(new Exception("Parametros Invalidos do xml"));
    				}

    				b = p.Gr.addVertex(nodeidx);
    				
    				for (int m=0; m <weightsNode.getLength();m++)
    				{
    					node = weightsNode.item(m);
    					if (node != null && node.getNodeType()==Node.ELEMENT_NODE)
    					{
    						element = (Element)node;
    						neigh=Integer.parseInt(element.getAttribute("targetnode"));
    						if (neigh <0)
    						{
    			    			throw(new Exception("Parametros Invalidos do xml"));
    						}
    						b = p.Gr.addVertex(neigh);
    						weight = Integer.parseInt(element.getTextContent());
    						if (weight<0)
    						{
    			    			throw(new Exception("Parametros Invalidos do xml"));
    						}
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
    		    		if (p.getAlpha()<0 || p.getBeta()<0 || p.getDelta()<0)
    		    		{
    		    			throw(new Exception("Parametro do Movimento invalido !"));
    		    		}
    			
    				}
    				else if (nodeCurr.getNodeName()== "evaporation")
    				{
    					p.setEvapParam(
    							Double.parseDouble(element.getAttribute("eta")),
    							Double.parseDouble(element.getAttribute("rho")));
    					if (p.getRho()<0 || p.getEtha()<0)
    					{
    						throw(new Exception("Parametro da Evaporacao invalido!"));
    					}
    				}
    			}
    		}
    		

    	}
    	catch(Exception ex)
    	{
    		System.out.println("Simulador ira encerrar ....");
    		ex.printStackTrace();
    		System.exit(1);
    	}
    }

	/***********************************************************
	 * 
	 * @return
	 * 
	 **********************************************************/
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
	
    /****************************************************************************
     * Getter do numero de observacoes que irao ser imprimidas
     * @return numControlPrint - numero de observacoes que irao ser imprimidas
     **************************************************************************/
    public int getNumControlPrint() 
    {
        return numControlPrint;
    }
    /***************************************************************
     * Armazenamento do numero de observacoes que estao a ser imprimidas
     * @param numCP - numero de observacoes impressas
     **************************************************************/
    public void setNumControlPrint(int numCP) 
    {
        numControlPrint = numCP;
    }

    /***************************************************************
     * Armazenamento do numero de eventos move
     *  @param mev -- numero de move events 
     **************************************************************/
    public void set_mevent(int mev)
    {
    	mevent = mev;
    }  
    /**************************************************************
     * Getter do numero de eventos move
     * 
     * @return mmevent  -- numero de move events
     **************************************************************/
    public int get_mevent()
    {
    	return mevent;
    }
    /**************************************************************
     * Armazeno do numero de eventos de evaporacao 
     * @param eev -- numero de eventos de evaporacao 
     *************************************************************/
    public void set_eevent(int eev)
    {
    	eevent = eev;
    }  
    /************************************************************
     *  Getter do numero de eventos evaporacao
     *  @return o eevent -- numero de eventos evaporacao
     ***********************************************************/
    public int get_eevent()
    {
    	return eevent;
    }    
    /***********************************************************
     * Getter of pending event container
     * @return pec - pending event container
     ***********************************************************/
    public InterfacePec<Event> getPec() 
    {
        return pec;
    }
    /***********************************************************
     * Setter of pending event container
     * @param p -- pending event container
     ***********************************************************/
    public void setPec(InterfacePec<Event> p) 
    {
        pec = p;
    }
    
    /**********************************************************
     * Getter da Lista de Formigas existentes
     * @return list_ants - lista de formigas existentes no problema
     *********************************************************/
	public List<Ant> getList_ants() 
	{
		return list_ants;
	}
	/*********************************************************
	 * Getter do peso total tendo em conta todas as arestas
	 * 
	 * @return wTotal - peso total do grafo para posteriores
	 * 					calculos
	 *********************************************************/
	public int getwTotal() 
	{
		return wTotal;
	}
	/*********************************************************
	 * Armazenamento do peso total considerando todas as arestas
	 * @param wT - peso total do grafo para posteriores calculos
	 ********************************************************/
	public void setwTotal(int wT) 
	{
		wTotal = wT;
	}
	


}
