
import edu.pccu.Movie.*;



public class T_Ticket_no {

 
    public static void main(String[] args) {
        
        
        Ticket t = new Ticket("WWW@hotmail.com","0933231110","2014-10-10",2,3,"N","1_10,1_2,1_3");       
        TicketDAO dao = new TicketDAODBImpl();
        int f =dao.add_ticket_no(t);
        System.out.println(f);
    }
    
}
