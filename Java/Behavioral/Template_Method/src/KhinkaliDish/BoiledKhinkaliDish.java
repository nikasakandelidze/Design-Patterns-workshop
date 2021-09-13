package KhinkaliDish;

public class BoiledKhinkaliDish extends KhinkaliDish {
    @Override
    public void addPastry() {
        System.out.println("Much pastry added");
    }

    @Override
    public void addMeat() {
        System.out.println("Meat with many greens/plants added");
    }

    @Override
    public void addDetails() {
        System.out.println("Adding too much salt");
    }

    @Override
    public void cook() {
        System.out.println("Boiling Khinkali");
    }
}
