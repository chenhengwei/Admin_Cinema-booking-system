package edu.pccu.Movie;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerDAODBImpl implements MovieDAO {

    final String DRIVER_NAME = "com.mysql.jdbc.Driver"; // MySQL 的名子 可以從datasheet取看
    final String CONN_STRING = "jdbc:mysql://173.194.224.58:3306/movie_ticket?"
            + "user=admin&password=admin&useUnicode=true&characterEncoding=utf-8"; // 帳號密碼

    @Override
    public void add_Movie(Movie movie) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
        public int add1(Movie movie)  {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public void update_Movie(Movie movie) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove_Movie(Movie movie) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Movie findById_name_c(String movie_name_chinese) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Movie findById_movie_no(int movie_no) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Movie> getAllMovies() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   @Override
    public ArrayList<Movie> findByName(String movie_name_chinese) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    @Override
    public void add_Customer(Customer customer) {
        try {
            Class.forName(DRIVER_NAME);  // 把符合的API 全部都進來 但是會有 expection , try catach 去擷取
            Connection conn = DriverManager.getConnection(CONN_STRING);
            String query = "Insert into ticket_Info "
                    + "(mail_account, phone_password, order_date, "
                    + "session_ID, people, customer_name) "
                    + "values(?,?,?,?,?,?)";
            PreparedStatement ppstemt = conn.prepareStatement(query);

            //ppstemt.setInt(1, customer.get_C_ticket_no());
            ppstemt.setString(1, customer.get_C_mail_account());
            ppstemt.setString(2, customer.get_C_phone_password());
            ppstemt.setString(3, customer.get_C_order_date());
            ppstemt.setInt(4, customer.get_C_session_ID());
            ppstemt.setInt(5, customer.get_C_people());
            ppstemt.setString(6, customer.get_C_customer_name());

            ppstemt.executeUpdate();
            ppstemt.cancel();
            conn.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update_Customer(Customer customer) {

        try {
            Class.forName(DRIVER_NAME);  // 把符合的API 全部都進來 但是會有 expection , try catach 去擷取
            Connection conn = DriverManager.getConnection(CONN_STRING);

            String query = "Update ticket_Info set "
                    + "mail_account = ?, phone_password = ?, order_date = ?, "
                    + "session_ID = ?, people = ?, customer_name = ? "
                    + "where ticket_no = ?";

//            String query = "Update ticket_Info set "
//                    + "movie_name_chinese = ?, movie_name_eng = ?, release_date = ?, "
//                    + "version = ?,movie_length = ?, actor = ?, director = ?, picture_url = ? "
//                    + "where movie_no = ?";
            //String query_find = "Update movie_Info set students_name = ?, students_phone = ? where students_id = ?";
            PreparedStatement ppstemt = conn.prepareStatement(query);
            //ppstemt.setInt(1, customer.get_C_ticket_no());
            ppstemt.setString(1, customer.get_C_mail_account());
            ppstemt.setString(2, customer.get_C_phone_password());
            ppstemt.setString(3, customer.get_C_order_date());
            ppstemt.setInt(4, customer.get_C_session_ID());
            ppstemt.setInt(5, customer.get_C_people());
            ppstemt.setString(6, customer.get_C_customer_name());
            ppstemt.setInt(7, customer.get_C_ticket_no());

            ppstemt.executeUpdate();
            ppstemt.cancel();
            conn.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void remove_Customer(Customer customer) {
        try {
            Class.forName(DRIVER_NAME);  // 把符合的API 全部都進來 但是會有 expection , try catach 去擷取
            Connection conn = DriverManager.getConnection(CONN_STRING);
            String query_find = "Delete from ticket_Info where ticket_no = ?";
            PreparedStatement ppstemt = conn.prepareStatement(query_find);
            //ppstemt.setInt(1, student.student_Id);
            ppstemt.setInt(1, customer.get_C_ticket_no());
            ppstemt.executeUpdate();
            ppstemt.cancel();
            conn.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Customer findById_C_Mail_PhoneP(String mail_account, String phone_password) {
        try {
            Class.forName(DRIVER_NAME);  // 把符合的API 全部都進來 但是會有 expection , try catach 去擷取
            Connection conn = DriverManager.getConnection(CONN_STRING);
            String query = "Select * from ticket_Info where mail_account = ? and phone_password = ?";
            PreparedStatement ppstemt = conn.prepareStatement(query);
            ppstemt.setString(1, mail_account);
            ppstemt.setString(2, phone_password);

            ResultSet rs = ppstemt.executeQuery();
            if (rs.next()) {
                Customer c = new Customer(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7));
                return c;
            } else {
                return null;
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public Customer findById_C_Mail(String mail_account) {
        try {
            Class.forName(DRIVER_NAME);  // 把符合的API 全部都進來 但是會有 expection , try catach 去擷取
            Connection conn = DriverManager.getConnection(CONN_STRING);
            String query = "Select * from ticket_Info where mail_account = ?";
            PreparedStatement ppstemt = conn.prepareStatement(query);
            ppstemt.setString(1, mail_account);

            ResultSet rs = ppstemt.executeQuery();
            if (rs.next()) {
                Customer c = new Customer(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7));
                return c;
            } else {
                return null;
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public ArrayList<Customer> getAllCustomers() {
        try {

            Class.forName(DRIVER_NAME);  // 把符合的API 全部都進來 但是會有 expection , try catach 去擷取
            Connection conn = DriverManager.getConnection(CONN_STRING);
            Statement stmt = conn.createStatement();
            String query = "Select * from ticket_Info";
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<Customer> alist = new ArrayList();
            while (rs.next()) {
                alist.add(new Customer(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7)));

            }
            return alist;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

}
