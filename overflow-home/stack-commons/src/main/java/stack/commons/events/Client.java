package stack.commons.events;

public interface Client
{

    public void addEvent(Event event);

    /**
     * Update event status to completed. 
     */
    public void eventCompleted(Integer id);

    /**
     * Add market to an existing event
     */
    public void attachMarketToEvent(Integer id, Market market);

    /**
     * Remove market from an existing event
     */
    public void removeMarketFromEvent(Integer id, Market market);
}
