
import Entity.Human;
import God.God;

public class Main {
    public static void main(String[] args) {
        God god = God.getGod();

        /*
            God created adam.
         */
        Human adam = god.createFirstHumanWithoutObservableNudity();

        /*
            Cannot observe nudity
         */
        adam.observeNudity();

        /*
            Then God got angry and changed this state of Adam.
         */
        god.makeHumanBeingObserveNudity(adam);

        /*
            Now adam can observe nudity.
         */
        adam.observeNudity();

    }

}
