package Facade;

import SubSystemComponents.Bookable;
import SubSystemComponents.HotelBookerApp;
import SubSystemComponents.PlainTicketsBookerApp;
import SubSystemComponents.TaxiBookerApp;

public class BookingFacade {
    private Bookable hotel;
    private Bookable plainTicket;
    private Bookable taxiRide;

    public BookingFacade(){
        hotel = new HotelBookerApp();
        plainTicket = new PlainTicketsBookerApp();
        taxiRide = new TaxiBookerApp();
    }

    public void bookingWholeComplect(){
        hotel.book();
        plainTicket.book();
        taxiRide.book();
    }
}
