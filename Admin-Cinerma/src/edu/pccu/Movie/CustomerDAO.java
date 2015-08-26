
package edu.pccu.Movie;

import java.util.ArrayList;


public interface CustomerDAO {
    public void add(Customer customer);
    //修改
    public void update(Customer customer);
    //刪除
    public void remove(Customer customer);
    //查詢(Email 電話)(前)
    public Movie findById(String mail_account,String phone_password);
    //查詢(Email)(前)
    public Movie findById(String mail_account);
    //所有訂單 order by 訂單編號
    public ArrayList<Customer> getAllCustomers();
    
}
