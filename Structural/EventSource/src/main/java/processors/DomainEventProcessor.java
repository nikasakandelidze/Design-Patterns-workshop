package processors;

import events.Event;
import persistenceStorage.JsonFileJournal;

/**
 *  Processor of events.
 *      Can process(event process + event persist) passed event.
 *      Can recover from persistent Storage all event steps and end up with same final state.
 */
public class DomainEventProcessor {
    private final JsonFileJournal processorJournal = new JsonFileJournal();

    public void process(Event event) {
        event.process();
        processorJournal.write(event);
    }

    /*
        Reset state
     */
    public void reset() {
        processorJournal.reset();
    }

    /*
        Recover all events that were persisted
        and re-process all of them to get to the exact state
     */
    public void recover() {
        Event event;
        while ((event = processorJournal.readNext()) != null) {
            event.process();
        }
    }
}
