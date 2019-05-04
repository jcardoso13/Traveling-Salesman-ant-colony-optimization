package discreteStochaticSim;

import java.util.Random;

import antcolony.*;

public abstract class Event implements InterfaceEvent {
	
	//Atributos
	private final Ant ant;
	private double time;
	public static Random r = new Random();
	public static EventComparator ec = new EventComparator();
	
	//Construtores
	public Event (double t, Ant a){
		setTime(t);
		ant = a;
	}
	
	
	//Métodos
	public abstract void ExecEvent(OptProblem op);
	public abstract String toString();
	
    public static double expRandom(double m) {
        double next = Event.r.nextDouble();
        return -m * Math.log(1.0 - next);
    }
    
    /* CHANGEEEEEE */
    public Ant getAnt() {
    	return ant;
    }
    
    public double getTime() {
    	return time;
    }
    
    public void setTime(double time) {
    	this.time = time;
    }
}
