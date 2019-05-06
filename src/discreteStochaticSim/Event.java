package discreteStochaticSim;

import java.util.Random;

import antColony.Ant;
import antColony.HamiltonianCycle;
import antColony.OptProblem;
import graph.graph;

public abstract class Event implements InterfaceEvent {
	/* ==== ATRIBUTOS ==== */
	private double time_stamp;
	private final Ant ant;

	public static Random r = new Random();
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
	 * @param op e o problema de optmizacao a que este evento pertence
	 *****************************************************************************/
	public abstract void ExecutaEvent(OptProblem opp,graph<Integer,Integer> gr,HamiltonianCycle<Integer,Integer> hc);
	
	
	/*****************************************************************************
	 * toString metodo que substitui aquele com o mesmo nome na superclasse Object.
	 ****************************************************************************/
	public abstract String toString();
	
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

	
	/** @return a formiga **/
	public Ant getAnt()
	{
		return ant;
	}
	/** @return o tempo **/
    public double getTime() 
    {
    	return time_stamp;
    }
    /** @param tempo ira ser armazenado **/
    public void setTime(double time_stamp) 
    {
    	this.time_stamp = time_stamp;
    }



}
