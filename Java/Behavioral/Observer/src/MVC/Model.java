package MVC;

import ObserversInterface.ModelListener;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private boolean state;
    private List<ModelListener> listenersList = new ArrayList<>();

    public Model(boolean initialState){
        this.state = initialState;
    }

    public void changeModelState(boolean newState){
        this.state = newState;
        System.out.println("Model's new state set successfully.");
        notifyListenersOfStateChange();
    }

    public void registerListener(ModelListener listener){
        listenersList.add(listener);
    }

    public void notifyListenersOfStateChange(){
        System.out.println("Notifying model listeners(Controller) about state change.");
        listenersList.forEach(e->e.updateView(state));
    }
}
