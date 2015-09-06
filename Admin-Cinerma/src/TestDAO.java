
import edu.pccu.Movie.Ticket;
import edu.pccu.Movie.TicketDAO;
import edu.pccu.Movie.TicketDAODBImpl;
import java.util.ArrayList;




public class TestDAO {

    public static void main(String[] args) {
        TicketDAO dao = new TicketDAODBImpl();
	ArrayList<Ticket> ticket_list = null;
        ticket_list = dao.getOrderedTickets("yahoohi@gmail.com");
        for (Ticket ticket : ticket_list) {
            System.out.println(ticket);
        }
    }

}