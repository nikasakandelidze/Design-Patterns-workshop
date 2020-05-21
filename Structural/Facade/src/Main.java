import Facade.BookingFacade;

public class Main {
    public static void main(String[] args) {
        //Old/without facade way of booking hotel,
        //  new HotelBookerApp().book();
        //  new PlainTicketsBookerApp().book();
        //  new TaxiBookerApp().book();

        BookingFacade facade = new BookingFacade();
        facade.bookingWholeComplect();//Books hotel,plain,taxi all with one method.
    }
}
