package SubSystemComponents;

public class HotelBookerApp implements Bookable{

    @Override
    public void book() {
        System.out.println("Booking Hotel.");
    }
}
