import CareTaker.CareTaker;
import Originator.TextFile;

public class Main {
    public static void main(String[] args) {
        CareTaker careTaker = new CareTaker();
        TextFile textFile = new TextFile("Hello world!");
        careTaker.addTextMemento(textFile.getTextMemento());
        textFile.addText(" Nah, Goodbye world!");
        careTaker.addTextMemento(textFile.getTextMemento());
        //Restore textFile to previous state("Hello world!")
        textFile.setTextMemento(careTaker.getSnapShotAt(0));//Restores to "Hello world"
    }
}
