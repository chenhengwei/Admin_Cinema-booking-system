package edu.pccu.Movie;

public class Session {
	private int session_ID;
	private int movie_no;
	private String room;
	private String show_date;
	private String show_time;
	
	public Session(int session_ID, int movie_no, String room, String show_date, String show_time) {
		super();
		this.session_ID = session_ID;
		this.movie_no = movie_no;
		this.room = room;
		this.show_date = show_date;
		this.show_time = show_time;
	}

	public int getSession_ID() {
		return session_ID;
	}

	public int getMovie_no() {
		return movie_no;
	}

	public String getRoom() {
		return room;
	}

	public String getShow_date() {
		return show_date;
	}

	public String getShow_time() {
		return show_time;
	}
}
