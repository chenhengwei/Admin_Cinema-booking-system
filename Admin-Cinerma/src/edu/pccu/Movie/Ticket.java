
package edu.pccu.Movie;


public class Ticket {
    private int ticket_no;
    private String mail_account;
    private String phone_password;
    private String order_date;
    private int session_ID;
    private int people;
    private String valid;
    private String seat_list;
    //private String customer_name;
    
    //包含新欄位(無ticket_no)
    public Ticket(String mail_account, String phone_password, String order_date, int session_ID, int people, String valid, String seat_list) {
        this.mail_account = mail_account;
        this.phone_password = phone_password;
        this.order_date = order_date;
        this.session_ID = session_ID;
        this.people = people;
        this.valid = valid;
        this.seat_list = seat_list;
    }
    
    //建構子
    //缺新欄位(有ticket_no)
    public Ticket(int ticket_no, String mail_account, String phone_password, String order_date, int session_ID, int people, String customer_name) {
        this.ticket_no = ticket_no;
        this.mail_account = mail_account;
        this.phone_password = phone_password;
        this.order_date = order_date;
        this.session_ID = session_ID;
        this.people = people;
        //this.customer_name = customer_name;
    }
    //包含所有欄位(有ticket_no)
    public Ticket(int ticket_no, String mail_account, String phone_password, String order_date, int session_ID,
			int people, String valid, String seat_list) {
		super();
		this.ticket_no = ticket_no;
		this.mail_account = mail_account;
		this.phone_password = phone_password;
		this.order_date = order_date;
		this.session_ID = session_ID;
		this.people = people;
		this.valid = valid;
		this.seat_list = seat_list;
	}
    

	
	   

	
	
	//Getter欄位資料
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

    public int getSession_ID() {
        return session_ID;
    }

    public int getPeople() {
        return people;
    }
    
    public String getValid() {
		return valid;
	}

	public String getSeat_list() {
		return seat_list;
	}

	/*public String getCustomer_name() {
        return customer_name;
    }*/    
    
}
