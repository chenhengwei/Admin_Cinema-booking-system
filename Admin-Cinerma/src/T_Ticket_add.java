

import edu.pccu.Movie.*;


public class T_Ticket_add  {


    public static void main(String[] args) {
       //(mail_account,phone_password,order_date,session_ID,people,valid,seat_list)
        Ticket t = new Ticket("WWW@hotmail.com","0933231110","2014-10-10",2,3,"N","1_10,1_2,1_3");       
        TicketDAO dao = new TicketDAODBImpl();
        dao.add_ticket(t);
        
    }
    
}
