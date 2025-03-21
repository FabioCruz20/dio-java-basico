public class FamilyTicket extends Ticket {
    
    private int numPeople;

    public FamilyTicket(double price, String movieName, String movieLanguage, int numPeople) {
        super(
            numPeople > 3 ? price * numPeople * 0.95 : price * numPeople, 
            movieName, 
            movieLanguage
        );
        this.numPeople = numPeople;
    }
    
    public int getNumPeople() {
        return numPeople;
    }
    
    public void setNumPeople(int numPeople) {
        this.numPeople = numPeople;
    }

    @Override
    public String toString() {
        return "FamilyTicket [price="  + price 
            + ", movieName=" + movieName 
            + ", movieLanguage=" + movieLanguage 
            + ", numPeople="+ numPeople
            + "]";
    }
}
