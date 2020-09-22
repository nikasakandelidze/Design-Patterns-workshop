package KhinkaliDish;

public class FriedKhinkaliDish extends KhinkaliDish {
    @Override
    public void addPastry() {
        System.out.println("Much pastry added");
    }

    @Override
    public void addMeat() {
        System.out.println("Added meat without any greens/plants");
    }

    @Override
    public void addDetails() {
        System.out.println("Adding peper instead of salt");
    }

    @Override
    public void cook() {
        System.out.println("Frying Khinkali dish");
    }
}
