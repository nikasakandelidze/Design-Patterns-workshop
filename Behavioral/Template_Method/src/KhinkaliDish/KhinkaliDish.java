package KhinkaliDish;

/*
    Very delicious Georgian dish.
 */
public abstract class KhinkaliDish {
    /*
        Declaring skeleton for making Khinkali Dish
     */
    public final void makeKhinkali() {
        addPastry();
        addMeat();
        addDetails();
        cook();
    }
    /*
        Letting users of this class to implement concrete steps
     */
    public abstract void addPastry();
    public abstract void addMeat();
    public abstract void addDetails();
    public abstract void cook();

}
