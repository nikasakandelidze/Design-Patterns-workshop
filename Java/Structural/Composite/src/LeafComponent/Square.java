package LeafComponent;

import BaseComponent.Shape;

public class Square implements Shape {
    @Override
    public void drawShape() {
        System.out.println("Drawing Square.");
    }
}
