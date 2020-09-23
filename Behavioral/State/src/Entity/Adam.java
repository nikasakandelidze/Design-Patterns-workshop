package Entity;

import State.ObserveNudityState;

/*
    Adam (as from Adam and Eve) is cocnrete implementation of Human being.
 */
public class Adam implements Human {

    private ObserveNudityState observeNudityState;

    public Adam(ObserveNudityState observeNudityState) {
        changeState(observeNudityState);
    }

    @Override
    public void observeNudity() {
        observeNudityState.representState();
    }

    public void changeState(ObserveNudityState state){
        this.observeNudityState = state;
    }

}
