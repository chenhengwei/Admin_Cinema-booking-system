

package edu.pccu.Movie;

import java.util.ArrayList;

public interface SeatDAO  {
    //所有電影票
    public ArrayList<Seats> getAllSeats();
    //查詢已訂電影票(前台)
    public  ArrayList<Seats> OrderedSeats();
    //查詢已訂電影票(後台)
    public ArrayList<Seats> remove_OrderedSeats(Seats seats);
    //刪除客戶訂單
    public int remove_Seats(Seats seats);
    
    public int add_Seats(Seats seats);
    
    public String find_Seat_by_RS(String R_a,String S_a);
}