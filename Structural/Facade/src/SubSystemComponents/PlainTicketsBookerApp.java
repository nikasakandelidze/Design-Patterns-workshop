package SubSystemComponents;

public class PlainTicketsBookerApp implements Bookable {

    @Override
    public void book() {
        System.out.println("Booking Plain Tickets.");
    }
}
