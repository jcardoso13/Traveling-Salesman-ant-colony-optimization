package discreteStochaticSim;

import java.util.Comparator;

public class EventComparator implements Comparator<Event> {
	
	public int compare (Event event1, Event event2) {
		double time1 = event1.getTime();
		double time2 = event2.getTime();
		
		return time1 < time2 ? -1 : time1 > time2 ? +1 : 0;
	}
}
