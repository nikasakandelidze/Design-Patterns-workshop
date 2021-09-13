package events;

/*
    This is the base event class.
    All specific events must extend it.
 */
public abstract class Event {
    private int eventId;
    private long eventCreationTime;
    private String eventClassName;

    public Event(int eventId, long eventCreationTime, String eventClassName) {
        this.eventId = eventId;
        this.eventCreationTime = eventCreationTime;
        this.eventClassName = eventClassName;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public long getEventCreationTime() {
        return eventCreationTime;
    }

    public void setEventCreationTime(long eventCreationTime) {
        this.eventCreationTime = eventCreationTime;
    }

    public String getEventClassName() {
        return eventClassName;
    }

    public void setEventClassName(String eventClassName) {
        this.eventClassName = eventClassName;
    }

    /*
        All subclasses / events should implement the process method.
     */
    public abstract void process();
}
