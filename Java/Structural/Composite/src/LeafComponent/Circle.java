package LeafComponent;

import BaseComponent.Shape;

public class Circle implements Shape {
    @Override
    public void drawShape() {
        System.out.println("Drawing Circle.");
    }
}
