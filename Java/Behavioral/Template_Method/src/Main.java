import KhinkaliDish.BoiledKhinkaliDish;
import KhinkaliDish.FriedKhinkaliDish;
import Restaraunt.GeorgianRestaraunt;

public class Main {
    public static void main(String[] args) {
        /*
            Let restaraunt have boiled khinkali as a default dish.
         */
        var restaraunt = new GeorgianRestaraunt(new BoiledKhinkaliDish());

        restaraunt.cookKhinkaliDish();

        /*
            Set new implementations of cooking Khinkali
         */
        restaraunt.setKhinkaliDish(new FriedKhinkaliDish());

        /*
            Now Restaraunt has Friend Khinkali
         */
        restaraunt.cookKhinkaliDish();

    }

}
