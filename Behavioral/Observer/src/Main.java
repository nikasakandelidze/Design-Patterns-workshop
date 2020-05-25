import MVC.Controller;
import MVC.Model;
import MVC.View;

public class Main {
    //Typical mvc pattern, controller ---(listens to)--->Model
    public static void main(String[] args) {
        Model model = new Model(true);
        View view = new View();
        Controller controller = new Controller(model,view);
        controller.changeModelState(false);
    }
}
