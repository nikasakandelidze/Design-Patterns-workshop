package God;

import Entity.Adam;
import Entity.Human;
import State.CanNotObserveNudity;
import State.CanObserveNudity;

/*
    God can give different people different states.
    Since god is one and only, we make this class singleton.
 */
public class God {
    private static God god = new God();

    private God(){ }

    public static God getGod(){
        return god;
    }

    /*
        Not used, Just for fun.
     */
    public void doAnythingYouWant(){ }


    public void makeHumanBeingObserveNudity(Human human){
        System.out.println("God: Making this human observe nudity.\n");
        human.changeState(new CanObserveNudity());
    }

    public void makeHumanBeingForgetNudity(Human human){
        System.out.println("God: Making this human forget nudity.\n");
        human.changeState(new CanNotObserveNudity());
    }

    public Human createFirstHumanWithoutObservableNudity(){
        System.out.println("God: Creating First Human, will call him Adam.\n");
        return new Adam(new CanNotObserveNudity());
    }

}
