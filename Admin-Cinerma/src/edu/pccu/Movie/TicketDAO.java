
package edu.pccu.Movie;

import java.util.ArrayList;


public interface TicketDAO {
    //所有電影票
    public ArrayList<Ticket> getAllTickets();
    //查詢已訂電影票(前台)
    public ArrayList<Ticket> getOrderedTickets(String mail_account,String phone_password);
    //查詢已訂電影票(後台)
    public ArrayList<Ticket> getOrderedTickets(String mail_account);
    //取消客戶訂單
    public int cancel_ticket(Ticket ticket);
    //刪除客戶訂單
    public int remove_ticket(Ticket ticket);
    //新增訂單(包含更新座位)
    public int add_ticket(Ticket ticket);
    
    public int add_ticket_no(Ticket ticket);
    
}
