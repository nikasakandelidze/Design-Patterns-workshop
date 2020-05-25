package MVC;

import ObserversInterface.ModelListener;

public class Controller implements ModelListener {
    private Model model;
    private View view;

    public Controller(Model model,View view){
        this.model = model;
        this.view = view;
        model.registerListener(this);    //Key part of the code.Register controller as model listener.
    }

    public void changeModelState(boolean newState){
        System.out.println("Controller's changeModelState invoced.");
        model.changeModelState(newState);
    }

    @Override
    public void updateView(boolean newState) {
        System.out.println("Listener(Controller) notified! changing view");
        view.viewUpdate(newState);
    }
}
