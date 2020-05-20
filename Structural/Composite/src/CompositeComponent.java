import BaseComponent.Shape;

import java.util.ArrayList;
import java.util.List;

//Notice that composite implements BaseComponent interface
//and behaves just like it.
public class CompositeComponent implements Shape {
    private List<Shape> listOfShapes = new ArrayList<>();

    @Override
    public void drawShape() {
        for(Shape childShape : listOfShapes){
            childShape.drawShape();
        }
    }

    public void addShape(Shape shapeToAdd){
        listOfShapes.add(shapeToAdd);
    }

    public void removeShape(Shape shapeToRemove){
        listOfShapes.remove(shapeToRemove);
    }

}
