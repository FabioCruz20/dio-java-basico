public class HalfPriceTicket extends Ticket {
    
    public HalfPriceTicket(double price, String movieName, String movieLanguage) {
        super(price * 0.5, movieName, movieLanguage);
    }
}
