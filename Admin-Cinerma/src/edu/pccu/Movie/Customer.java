package edu.pccu.Movie;

public class Customer {

//    private int ticket_no;
//    private int customer_ID;
//    private int people;
//    private int session_ID;
//    private String order_date;
//    private String customer_name;
//    private String mail_account;
//    private String phone_password;
    private int ticket_no; //1
    private String mail_account;//2
    private String phone_password;//3
    private String order_date;//4
    private int session_ID;//5
    private int people;//6
    private String customer_name;//7
    private String valid;
    private String seat_list;

    public Customer(int ticket_no, String mail_account, String phone_password, String order_date, int session_ID, int people, String customer_name) {
        this.ticket_no = ticket_no;
        this.mail_account = mail_account;
        this.phone_password = phone_password;
        this.order_date = order_date;
        this.session_ID = session_ID;
        this.people = people;
        this.customer_name = customer_name;
    }

    public Customer(String mail_account, String phone_password, String order_date, int session_ID, int people, String valid, String seat_list) {
        this.mail_account = mail_account;
        this.phone_password = phone_password;
        this.order_date = order_date;
        this.session_ID = session_ID;
        this.people = people;
        this.valid = valid;
        this.seat_list = seat_list;
    }

    public Integer get_C_ticket_no() {
        return ticket_no;
    }

    public String get_C_mail_account() {
        return mail_account;
    }

    public String get_C_phone_password() {
        return phone_password;
    }

    public String get_C_order_date() {
        return order_date;
    }

    public Integer get_C_session_ID() {
        return session_ID;
    }

    public Integer get_C_people() {
        return people;
    }

    public String get_C_customer_name() {
        return customer_name;
    }

    public String getValid() {
        return valid;
    }

    public String getSeat_list() {
        return seat_list;
    }

}
