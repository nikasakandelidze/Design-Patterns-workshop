package Originator;

import Memento.TextMemento;

public class TextFile {
    private String text;

    public TextFile(String startingText){
        System.out.println("Created text File, with initial state: "+startingText);
        text = startingText;
    }

    public void addText(String newText){
        System.out.println("Adding text to text file, new text state is: " +text+newText);
        text+=newText;
    }

    public void setTextMemento(TextMemento memento){
        System.out.println("Restoring text file to previous state.");
        text = ((InnerTextMemento) memento).getState();
        System.out.println("Now text file state is: "+text);
    }

    public TextMemento getTextMemento(){
        return new InnerTextMemento(text);
    }

    private static class InnerTextMemento implements  TextMemento{
        private String stateSnapShot;

        public InnerTextMemento(String stateSnapShot){
            this.stateSnapShot = stateSnapShot;
        }

        public String getState(){
            return stateSnapShot;
        }
    }
}
