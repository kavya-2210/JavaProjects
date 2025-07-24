abstract class Movie{
    protected String movieId;
    protected String title;
    protected double ticketPrice;
    protected int numberOfTickets;
    Movie(String movieId,String title,double ticketPrice,int numberOfTickets){
        this.movieId=movieId;
        this.title=title;
        this.ticketPrice=ticketPrice;
        this.numberOfTickets=numberOfTickets;
    }
    public void displayDetails(){
        System.out.println("Movie Record");
        System.out.println("ID "+movieId);
        System.out.println("Title "+title);
        System.out.println("Ticket Price "+ticketPrice);
        System.out.println("Number of Tickets "+numberOfTickets);
        if(numberOfTickets>6){
            System.out.println("Booking Failed: Cannot book more than 6 tickets");
        } else{
            System.out.println("Total Price "+calaculatePrice());
        }
        System.out.println();
    }
    public abstract double calaculatePrice();
} 
class TeluguMovie extends Movie{
    TeluguMovie(String movieId,String title,double ticketPrice,int numberOfTickets){
        super(movieId,title,ticketPrice,numberOfTickets);
    }
    @Override
    public double calaculatePrice(){
        double basePrice=ticketPrice*numberOfTickets;
        double gst=basePrice*0.05;
        return basePrice+gst;
    }
}
class HindiMovie extends Movie{
    HindiMovie(String movieId,String title,double ticketPrice,int numberOfTickets){
        super(movieId,title,ticketPrice,numberOfTickets);
    }
    @Override
    public double calaculatePrice(){
        double basePrice=ticketPrice*numberOfTickets;
        double discount=basePrice*0.10;
        double discountedPrice=basePrice-discount;
        double gst=discountedPrice*0.05;
        return discountedPrice+gst;
    }
}   
class EnglishMovie extends Movie{
    EnglishMovie(String movieId,String title,double ticketPrice,int numberOfTickets){
        super(movieId,title,ticketPrice,numberOfTickets);
    }
    @Override
    public double calaculatePrice(){
        double basePrice=ticketPrice*numberOfTickets;
        double extra3dCharge=50*numberOfTickets;
        double total=basePrice+extra3dCharge;
        double gst=total*0.05;
        return total+gst;
    }
}
public class MovieTicketBooking{
    public static void main(String[] args){
        Movie telugu = new TeluguMovie("M101", "RRR", 150.0, 3);
        Movie hindi = new HindiMovie("M102", "Pathaan", 200.0, 2);
        Movie english = new EnglishMovie("M103", "Avatar", 250.0, 7); 
        Movie[] movies = { telugu, hindi, english };
        for (Movie movie : movies) {
            movie.displayDetails();
        }
    }
}