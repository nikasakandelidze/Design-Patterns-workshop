package State;

/*
    Concrete implementation of being able to observe nudity.
 */
public class CanObserveNudity implements ObserveNudityState{
    @Override
    public void representState() {
        System.out.println("Oh my god, you are nude. what's wrong with you.\n");
    }
}
