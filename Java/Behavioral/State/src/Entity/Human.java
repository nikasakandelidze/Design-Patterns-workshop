package Entity;

import State.ObserveNudityState;

/*
    All human beings have abilty to either observe nudity or not observe it.
 */
public interface Human {

    void observeNudity();

    void changeState(ObserveNudityState state);

}
