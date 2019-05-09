package discreteStochaticSim;

import java.util.Random;

import antColony.Ant;
import antColony.HamiltonianCycle;
import antColony.OptProblem;
import graph.graph;
/***************************************************************
 * Classe Abstrata para os Eventos
 * 
 * @author Grupo 11
 *
 *<p> Classe Abstrata para Eventos. Tem um campo para a formiga 
 *associada e outro para o tempo em que devemos executar o evento.
 *Existem 2 campos estaticos. O primeiro e um objeto aleatorio para 
 *gerar numeros aleatorios e o outro e um comparador de eventos que 
 *e usado quando queremos adicionar eventos ao PEC. Os metodos 
 *Execute Event e toString devem ser substituidos.
 ****************************************************************/
public abstract class Event implements InterfaceEvent {
	/* ==== ATRIBUTOS ==== */
	/** tempo em que devemos executar o evento **/
	protected double time_stamp;
	/** formiga em que devemos executar o evento  **/
	protected final Ant ant;
	/** numero aleatorio gerado **/
	private static Random r = new Random();
	/** comparador de eventos **/
	public static EventComparator ec = new EventComparator();

	/* ==== CONSTRUTORES ==== */
	/**************************************************************************
	 * Construtor da classe Event. Uma vez que o Event e abstrato o construtor
	 * vai ter de ser chamado pelas subclasses usano this().
	 * 
	 * @param t e o tempo do evento
	 * @param a e a formiga que queremos associar com este evento. Se ha um evento
	 * sem a formiga sabemos que o argumento a ser passado e null
	 * 
	 ****************************************************************************/
	public Event (double t, Ant a)
	{
		setTime(t);
		ant=a;
	}

	/* ==== METODOS ==== */	
	/*****************************************************************************
	 * Metodo abstrato da execucao do evento. Cada tipo de evento deve redefinir este 
	 * metodo para fazer o que deve fazer.
	 * 
	 * @param opp e o problema de optmizacao a que este evento pertence
	 * @param gr -- grafo do problema a optimizar
	 * @param hc -- ciclo hamiltoniano
	 *****************************************************************************/
	public abstract void ExecutaEvent(OptProblem opp,graph<Integer,Integer> gr,HamiltonianCycle<Integer,Integer> hc);
	
	
	/**********************************************************************************
	 * Metodo que retorna um numero aleatorio de acordo com um exponencial com media m. 
	 * Este metodo nao depende de quem o invoca, por isso e estatico e sera invocado 
	 * a partir da propria classe.
	 * 
	 * @param m e a media que queremos usar no exponencial.
	 * @return e o numero aleatorio gerado.
	 *********************************************************************************/
	public static double expRandom(double m)
	{
        double next = Event.r.nextDouble();
        return -m * Math.log(1.0 - next);		
	}

	
	/*********************************************************
	 *  Getter da Formiga associada ao evento
	 *  @return ant - uma certa formiga associada a um evento
	 ********************************************************/
	public Ant getAnt()
	{
		return ant;
	}
	/********************************************************
	 *	Getter de o tempo considerando um certo evento
	 * @return time_stamp 
	 * 
	 ********************************************************/
    public double getTime() 
    {
    	return time_stamp;
    }
    /********************************************************
     * Armazenar o tempo
     * @param ts ira ser armazenado 
     *******************************************************/
    public void setTime(double ts) 
    {
    	time_stamp = ts;
    }



}
