
package edu.pccu.Movie;

import java.util.ArrayList;

public interface MovieDAO {
    //Movie
    
    //新增
    public void add_Movie(Movie movie);
    //新增(華郁)
    public int add1(Movie movie);
    //修改
    public void update_Movie(Movie movie);
    //修改(華郁)
    public int update_Movie2(Movie movie);
    //刪除
    public void remove_Movie(Movie movie);
    //刪除(華郁)
    public int remove_Movie2(Movie movie);
    //查詢(電影中文名稱) (前後台)
    public Movie findById_name_c(String movie_name_chinese);
    //查詢(編號)
    public Movie findById_movie_no(int movie_no);
    //所有電影
    public ArrayList<Movie> getAllMovies();
    //符合名的電影(華郁)
    public ArrayList<Movie> findByName(String movie_name_chinese);
    
    //Customer
    
    //新增訂票人
    public void add_Customer(Customer customer);
    //修改
    public void update_Customer(Customer customer);
    //刪除
    public void remove_Customer(Customer customer);
    //查詢(Email 電話)(前)
    public Customer findById_C_Mail_PhoneP(String mail_account,String phone_password);
    //查詢(Email)(前)
    public Customer findById_C_Mail(String mail_account);
    //所有訂單 order by 訂單編號
    public ArrayList<Customer> getAllCustomers();
    
}

