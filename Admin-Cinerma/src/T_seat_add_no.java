
import edu.pccu.Movie.*;



public class T_seat_add_no {


    public static void main(String[] args) {
        
        Ticket t = new Ticket("WWW@hotmail.com","0933231110","2014-10-10",2,3,"N","1_10,1_2,1_3");       
        TicketDAO dao = new TicketDAODBImpl();
        int f =dao.add_ticket_no(t);
        System.out.println(f);
        
//        	Ticket t = new Ticket(s1[0],s1[1],s1[3],2,Integer.valueOf(s1[4]),"Y",ttl_seat_order);       
//                 TicketDAO dao = new TicketDAODBImpl();
//                 int auto_ticket_no = dao.add_ticket(t);
        
        
            Seats s = new Seats("A","5","5","Y",f,"Y");
            SeatDAO Seat_dao = new SeatsDAODBImpl();
            int A = Seat_dao.add_Seats(s);
            System.out.println(A);
            
//            Seats ordered_s = new Seats("A",s2[i],s2[i+1],"Y",auto_ticket_no,"Y");
//            SeatDAO Seat_dao = new SeatsDAODBImpl();
//            f = Seat_dao.add_Seats_ticket_no(ordered_s);
    }
    
}
