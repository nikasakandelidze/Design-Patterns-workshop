package Restaraunt;

import KhinkaliDish.KhinkaliDish;

/*
    All Georgian Restaraunts definetly have Khinkali as a main dish,
    we add KhinkaliDish abstract class as a field so that we can vary between different subclasses of this dish.
 */
public class GeorgianRestaraunt {
    private KhinkaliDish khinkaliDish;

    public GeorgianRestaraunt(KhinkaliDish khinkaliDish) {
        this.khinkaliDish = khinkaliDish;
    }

    public void cookKhinkaliDish() {
        khinkaliDish.cook();
    }

    public void setKhinkaliDish(KhinkaliDish khinkaliDish) {
        this.khinkaliDish = khinkaliDish;
    }
}
