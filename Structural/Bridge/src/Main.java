import Colors.ColorBlue;
import Colors.ColorRed;
import Shapes.Rectangle;
import Shapes.Shape;

public class Main {
    //Instead of having these new ColorRed() and new ColorBlue() implementations
    // inside of Rectangle(or other Shape's implementations) we left this choice to outer world and injected it.
    public static void main(String[] args) {
        Shape shapeFilledWithRed = new Rectangle(new ColorRed());
        Shape shapeFilledWithBlue = new Rectangle(new ColorBlue());
        shapeFilledWithBlue.fillShape();
        shapeFilledWithRed.fillShape();
    }
}
