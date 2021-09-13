package State;

/*
    Concrete implementation of not being able to observe nudity.
 */
public class CanNotObserveNudity implements ObserveNudityState {
    @Override
    public void representState() {
        System.out.println("What is nudity? haven't heard of it.\n");
    }
}
