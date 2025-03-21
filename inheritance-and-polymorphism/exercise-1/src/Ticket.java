public class Ticket {
    
    protected double price;

    protected String movieName;

    protected String movieLanguage;

    public Ticket(double price, String movieName, String movieLanguage) {
        this.price = price;
        this.movieName = movieName;
        this.movieLanguage = movieLanguage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieLanguage() {
        return movieLanguage;
    }

    public void setMovieLanguage(String movieLanguage) {
        this.movieLanguage = movieLanguage;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [price=" + price + ", movieName=" + movieName + ", movieLanguage=" + movieLanguage + "]";
    }
}
