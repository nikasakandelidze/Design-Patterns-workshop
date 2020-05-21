package SubSystemComponents;

public class TaxiBookerApp implements Bookable {
    @Override
    public void book() {
        System.out.println("Booking Taxi ride.");
    }
}
