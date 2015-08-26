package edu.pccu.Movie;

import java.sql.Date;

public class Movie {

    private int movie_no; //1
    private String movie_name_chinese;//2
    private String movie_name_eng;//3
    private String release_date;//4
    private String version;//5
    private int movie_length;//6
    private String actor;//7
    private String director;//8
    private String picture_url;//9

    public Movie(int movie_no, String movie_name_chinese, String movie_name_eng, String release_date, String version, int movie_length, String actor, String director, String picture_url) {
        this.movie_no = movie_no;
        this.movie_name_chinese = movie_name_chinese;
        this.movie_name_eng = movie_name_eng;
        this.release_date = release_date;
        this.version = version;
        this.movie_length = movie_length;
        this.actor = actor;
        this.director = director;
        this.picture_url = picture_url;
    }

    public Movie(String movie_name_chinese, String movie_name_eng, String release_date, String version,
            int movie_length, String actor, String director, String picture_url) {
        super();
        this.movie_name_chinese = movie_name_chinese;
        this.movie_name_eng = movie_name_eng;
        this.release_date = release_date;
        this.version = version;
        this.movie_length = movie_length;
        this.actor = actor;
        this.director = director;
        this.picture_url = picture_url;
    }

    public Integer get_m_no() {
        return movie_no;
    }

    public String get_m_name_c() {
        return movie_name_chinese;
    }

    public String get_m_name_e() {
        return movie_name_eng;
    }

    public String get_release_date() {
        return release_date;
    }

    public String get_version() {
        return version;
    }

    public Integer get_m_length() {
        return movie_length;
    }

    public String get_actor() {
        return actor;
    }

    public String get_director() {
        return director;
    }

    public String get_picture_url() {
        return picture_url;
    }

}
