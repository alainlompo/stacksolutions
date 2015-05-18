package stack.commons.events;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ClientImpl implements Client {

	private List<Event> events;
	
	public ClientImpl() {
		events = new ArrayList<Event>();
	}
	
	public void addEvent(Event event) {
		if (! events.contains(event)) {
			events.add(event);
		}
		
	}

	public void eventCompleted(Integer id) {
		Event target  = findEventById(id);
		Collection<Market> eventMarket= null; 
		
		if (null != target) {
			
			if (events.contains(target)) {
				eventMarket = target.getMarket();
				events.remove(target);
				Event newEvent = new Event(id, eventMarket, true);
				events.add(newEvent);
			}
		}
		
	}

	public Event findEventById(Integer id) {
		Event target = null;
		for (Event e:events) {
			if (e.getId().equals(id)) {
				target = e;
				break;	
			}
		}
		return target;
	}
	

	public void attachMarketToEvent(Integer id, Market market) {
		
		Event target = findEventById(id);
		if (null != target) {
			Collection<Market> markets = target.getMarket();
			markets.add(market);
		}
		
	}

	public void removeMarketFromEvent(Integer id, Market market) {
		
		Event target = findEventById(id);
		if (null != target) {
			Collection<Market> markets = target.getMarket();
			if (markets.contains(market)) {
				markets.remove(market);
			}
		}
		
		
	}

}
