

package edu.pccu.Movie;


public class Seats {
    public String room;
    public String R_a;
    public String S_a;
    public String sold;
    public String vaild;
    public int ticket_no;

    public Seats(String room, String R_a, String S_a, String sold, int ticket_no, String vaild) {
        this.room = room;
        this.R_a = R_a;
        this.S_a = S_a;
        this.sold = sold;
        this.vaild = vaild;
        this.ticket_no = ticket_no;
    }
    
    
    public Seats(String room, String R_a, String S_a, String sold, String vaild) {
        this.room = room;
        this.R_a = R_a;
        this.S_a = S_a;
        this.sold = sold;
        this.vaild = vaild;
    }

    public Seats(String R_a, String S_a) {
        this.R_a = R_a;
        this.S_a = S_a;
    }
    
        public Seats(String R_a, String S_a, String sold) {
        this.R_a = R_a;
        this.S_a = S_a;
        this.sold = sold;
    }
}
