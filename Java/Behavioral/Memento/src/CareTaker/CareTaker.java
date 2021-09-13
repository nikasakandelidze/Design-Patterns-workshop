package CareTaker;

import Memento.TextMemento;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    private List<TextMemento> snapShots = new ArrayList<>();

    public void addTextMemento(TextMemento newSnapShot){
        snapShots.add(newSnapShot);
    }

    public TextMemento getSnapShotAt(int index){
        return snapShots.get(index);
    }
}
