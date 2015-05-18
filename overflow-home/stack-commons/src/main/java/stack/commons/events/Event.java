package stack.commons.events;

import java.util.Collection;

public class Event {

    private final Integer id;
    private final Collection<Market> market;
    private final Boolean completed;
 

    public Collection<Market> getMarket() {
		return market;
	}

	public Event(Integer id,
            Collection<Market> market, Boolean completed) {
        this.id = id;
        this.market = market;
        this.completed = completed;
    }

    public Integer getId() {
        return id;
    }

    public Boolean getCompleted() {
        return completed;
    }
}
