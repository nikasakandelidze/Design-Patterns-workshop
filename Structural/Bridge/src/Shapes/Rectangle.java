package Shapes;

import Colors.Color;

public class Rectangle implements Shape{
    private Color color;
    //Instead of Color color = new ColorBlue();
    //We are pushing this implementation detail to the outside world.
    public Rectangle(Color color){
        this.color = color;
    }

    @Override
    public void fillShape() {
        color.applyColor();
    }
}
