package edu.pccu.Movie;

import java.util.ArrayList;

public interface AllJoinDAO {
	//所有電影票
    public ArrayList<AllJoin> getAllTickets();
    //查詢已訂電影票(前台)
    public ArrayList<AllJoin> getOrderedTickets(String mail_account,String phone_password);
    //查詢已訂電影票(後台)
    public ArrayList<AllJoin> getOrderedTickets(String mail_account);
    //取得使用者指定時間內的場次
    public ArrayList<Session> getSession(int movie_no,String show_date);
}
