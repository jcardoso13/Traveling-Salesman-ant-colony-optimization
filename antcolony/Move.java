package antcolony;

import discreteStochaticSim.*;

public class Move extends Event {
	
	// Construtor
	public Move (double timeE, Ant a) {
		super(timeE,a);
	}
	
	//Método
	public void ExecEvent(OptProblem opp){
		StochasticOptProblem op = (StochasticOptProblem) opp;

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("(Type:Move, Ant ID:"
				+",Time:"
				+ this.getTime()+")");
	}
}
