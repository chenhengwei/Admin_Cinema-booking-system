/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.pccu.Movie;

/**
 *
 * @author Amy
 */
public class AllJoin {
	//TICKET欄位
	private int ticket_no;
    private String mail_account;
    private String phone_password;
    private String order_date;
    private int T_session_ID;
    private int people;
    private String customer_name;
    
    //SESSION欄位
    private int S_session_ID;
    private int S_movie_no;
    private String S_room;
    private String show_date;
    private String show_time;
    
	//MOVIE欄位
    private int M_movie_no;
    private String movie_name_chinese;
    private String movie_name_eng;
    private String release_date;
    private String version;
    private int movie_length;
    private String actor;
    private String director;
    private String picture_url;
	
    
    //建構子
    //TICKET Join SESSION Join Movie(後台訂票管理用)
    public AllJoin(int ticket_no, String mail_account, String phone_password, String order_date,
			int t_session_ID, int people, String customer_name, String s_room, String show_date, String show_time,
			String movie_name_chinese, String movie_name_eng, String version, int movie_length) {
		super();
		this.ticket_no = ticket_no;
		this.mail_account = mail_account;
		this.phone_password = phone_password;
		this.order_date = order_date;
		T_session_ID = t_session_ID;
		this.people = people;
		this.customer_name = customer_name;
		S_room = s_room;
		this.show_date = show_date;
		this.show_time = show_time;
		this.movie_name_chinese = movie_name_chinese;
		this.movie_name_eng = movie_name_eng;
		this.version = version;
		this.movie_length = movie_length;
	}
    
    //GETTER & SETTER
    public int getTicket_no() {
		return ticket_no;
	}
	public String getMail_account() {
		return mail_account;
	}
	public String getPhone_password() {
		return phone_password;
	}
	public String getOrder_date() {
		return order_date;
	}
	public int getT_session_ID() {
		return T_session_ID;
	}
	public int getPeople() {
		return people;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public int getS_session_ID() {
		return S_session_ID;
	}
	public int getS_movie_no() {
		return S_movie_no;
	}
	public String getS_room() {
		return S_room;
	}
	public String getShow_date() {
		return show_date;
	}
	public String getShow_time() {
		return show_time;
	}
	public int getM_movie_no() {
		return M_movie_no;
	}
	public String getMovie_name_chinese() {
		return movie_name_chinese;
	}
	public String getMovie_name_eng() {
		return movie_name_eng;
	}
	public String getRelease_date() {
		return release_date;
	}
	public String getVersion() {
		return version;
	}
	public int getMovie_length() {
		return movie_length;
	}
	public String getActor() {
		return actor;
	}
	public String getDirector() {
		return director;
	}
	public String getPicture_url() {
		return picture_url;
	}
}
