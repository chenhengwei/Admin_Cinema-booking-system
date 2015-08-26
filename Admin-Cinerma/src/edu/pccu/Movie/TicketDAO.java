
package edu.pccu.Movie;

import java.util.ArrayList;


public interface TicketDAO {
    //所有電影票
    public ArrayList<Ticket> getAllTickets();
    //已訂電影票
    public ArrayList<Ticket> getOrderedTickets();

}
