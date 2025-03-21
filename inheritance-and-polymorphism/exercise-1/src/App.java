public class App {

    public static void main(String[] args) throws Exception {
        
        Ticket ticket1 = new Ticket(40.0, "Movie 1", "Portuguese");
        Ticket ticket2 = new HalfPriceTicket(40.0, "Movie 1", "Portuguese");
        Ticket ticket3 = new FamilyTicket(40.0, "Movie 1", "Portuguese", 3);
        Ticket ticket4 = new FamilyTicket(40.0, "Movie 1", "Portuguese", 4);

        System.out.println(ticket1);
        System.out.println(ticket2);
        System.out.println(ticket3);
        System.out.println(ticket4);
    }
}
