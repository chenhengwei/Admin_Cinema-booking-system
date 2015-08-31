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
	private int T_ticket_no;
    private String mail_account;
    private String phone_password;
    private String order_date;
    private int T_session_ID;
    private int people;
    //private String customer_name;
    private String T_valid;
    private String seat_list;
    
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
	
    //ROOM_SEAT欄位
    private String R_room;
    private String R_axis;
    private String S_axis;
    private String sold;
    private String R_valid;
    private int R_ticket_no;
    
    
    //建構子
    //TICKET Join SESSION Join Movie(後台訂票管理用)
    public AllJoin(int ticket_no, String mail_account, String phone_password, String order_date,
			int t_session_ID, int people, String customer_name, String s_room, String show_date, String show_time,
			String movie_name_chinese, String movie_name_eng, String version, int movie_length) {
		super();
		this.T_ticket_no = ticket_no;
		this.mail_account = mail_account;
		this.phone_password = phone_password;
		this.order_date = order_date;
		T_session_ID = t_session_ID;
		this.people = people;
		//this.customer_name = customer_name;
		S_room = s_room;
		this.show_date = show_date;
		this.show_time = show_time;
		this.movie_name_chinese = movie_name_chinese;
		this.movie_name_eng = movie_name_eng;
		this.version = version;
		this.movie_length = movie_length;
	}
    
    //TICKET Join SESSION Join Movie Join ROOM_SEAT(後台訂票管理用)
	public AllJoin(int t_ticket_no, String mail_account, String phone_password, String order_date, int t_session_ID,
			int people, String t_valid, String seat_list, int s_movie_no, String s_room, String show_date,
			String show_time, String r_axis, String s_axis, String sold, String movie_name_chinese, String version) {
		super();
		T_ticket_no = t_ticket_no;
		this.mail_account = mail_account;
		this.phone_password = phone_password;
		this.order_date = order_date;
		T_session_ID = t_session_ID;
		this.people = people;
		T_valid = t_valid;
		this.seat_list = seat_list;
		S_movie_no = s_movie_no;
		S_room = s_room;
		this.show_date = show_date;
		this.show_time = show_time;
		R_axis = r_axis;
		S_axis = s_axis;
		this.sold = sold;
		this.movie_name_chinese = movie_name_chinese;
		this.version = version;
	}

    
    
    //GETTER & SETTER    
	public int getT_ticket_no() {
		return T_ticket_no;
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


	public String getT_valid() {
		return T_valid;
	}


	public String getSeat_list() {
		return seat_list;
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


	public String getR_room() {
		return R_room;
	}


	public String getR_axis() {
		return R_axis;
	}


	public String getS_axis() {
		return S_axis;
	}


	public String getSold() {
		return sold;
	}


	public String getR_valid() {
		return R_valid;
	}


	public int getR_ticket_no() {
		return R_ticket_no;
	}
}
