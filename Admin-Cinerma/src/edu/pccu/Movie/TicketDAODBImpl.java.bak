/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.pccu.Movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amy
 */
public class TicketDAODBImpl implements TicketDAO{
    
    final String DRIVER_NAME = "com.mysql.jdbc.Driver"; // MySQL 的名子 可以從datasheet取看
    final String CONN_STRING = "jdbc:mysql://173.194.224.58:3306/movie_ticket?"
            + "user=admin&password=admin&useUnicode=true&characterEncoding=utf-8"; // 帳號密碼
    
    @Override
    public ArrayList<Ticket> getAllTickets() {
        try {
            Class.forName(DRIVER_NAME); // 把符合的API 全部都進來 但是會有 expection , try
            // catach 去擷取
            Connection conn = DriverManager.getConnection(CONN_STRING);
            Statement stmt = conn.createStatement();
            String query = "Select * from ticket_Info where valid = 'Y'";
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<Ticket> alist = new ArrayList();
            while (rs.next()) {
                /*alist.add(new Ticket(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7)));*/            	
				alist.add(new Ticket(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6),
						rs.getString(7), rs.getString(8)));
            }
            return alist;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TicketDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Ticket> getOrderedTickets(String mail_account, String phone_password) {
        try {
            Class.forName(DRIVER_NAME); // 把符合的API 全部都進來 但是會有 expection , try
            // catach 去擷取
            Connection conn = DriverManager.getConnection(CONN_STRING);
            Statement stmt = conn.createStatement();
            String query = "Select * from ticket_Info WHERE valid = 'Y' "
            		+ "AND mail_account = '" + mail_account +
                    "' AND phone_password = '" + phone_password + "'";
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<Ticket> alist = new ArrayList();
            while (rs.next()) {
                alist.add(new Ticket(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6),
						rs.getString(7), rs.getString(8)));

            }
            return alist;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TicketDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Ticket> getOrderedTickets(String mail_account) {
        try {
            Class.forName(DRIVER_NAME); // 把符合的API 全部都進來 但是會有 expection , try
            // catach 去擷取
            Connection conn = DriverManager.getConnection(CONN_STRING);
            Statement stmt = conn.createStatement();
            String query = "Select * from ticket_Info WHERE valid = 'Y'"
            		+ " AND mail_account='" + mail_account + "'";
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<Ticket> alist = new ArrayList();
            while (rs.next()) {
                alist.add(new Ticket(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6),
						rs.getString(7), rs.getString(8)));

            }
            return alist;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TicketDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

	@Override
	public int cancel_ticket(Ticket ticket) {
		int count = 0;
    	try {
            Class.forName(DRIVER_NAME);  // 把符合的API 全部都進來 但是會有 expection , try catach 去擷取
            Connection conn = DriverManager.getConnection(CONN_STRING);
            String query = "update ticket_Info set valid = ? WHERE ticket_no = ? AND valid = ?";
            PreparedStatement ppstemt = conn.prepareStatement(query);
            ppstemt.setString(1, "N");
            ppstemt.setInt(2, ticket.getTicket_no());
            ppstemt.setString(3, "Y");
            count = ppstemt.executeUpdate();
            ppstemt.cancel();
            conn.close();
            return count;
    	} catch (ClassNotFoundException ex) {
            Logger.getLogger(TicketDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
		return -1;
	}
    
    @Override
    public int remove_ticket(Ticket ticket) {
        int count = 0;
    	try {
            Class.forName(DRIVER_NAME);  // 把符合的API 全部都進來 但是會有 expection , try catach 去擷取
            Connection conn = DriverManager.getConnection(CONN_STRING);
            String query = "Delete from ticket_Info where ticket_no = ?";
            PreparedStatement ppstemt = conn.prepareStatement(query);
            //ppstemt.setInt(1, student.student_Id);
            ppstemt.setInt(1, ticket.getTicket_no());
            count = ppstemt.executeUpdate();
            ppstemt.cancel();
            conn.close();
            return count;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TicketDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
		return -1;
    }

	@Override
	public int add_ticket(Ticket ticket) {

            int count = 0;    
          try {
            Class.forName(DRIVER_NAME);  // 把符合的API 全部都進來 但是會有 expection , try catach 去擷取
            Connection conn = DriverManager.getConnection(CONN_STRING);
            String query = "Insert into ticket_Info "
                         + "(mail_account,phone_password,order_date,"
                         + "session_ID,people,valid,seat_list)"
            		 +" VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ppstemt = conn.prepareStatement(query);

            //ppstemt.setInt(1, customer.get_C_ticket_no());
            ppstemt.setString(1, ticket.getMail_account());
            ppstemt.setString(2, ticket.getPhone_password());
            ppstemt.setString(3, ticket.getOrder_date());
            ppstemt.setInt(4, ticket.getSession_ID());
            ppstemt.setInt(5, ticket.getPeople());
            ppstemt.setString(6, ticket.getValid());
            ppstemt.setString(7, ticket.getSeat_list());
        
            ppstemt.executeUpdate();
            count = ppstemt.executeUpdate();
            ppstemt.cancel();
            conn.close();           
            
            return count;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        }      
               
        return -1;
                
	}    

    @Override
    public int add_ticket_no(Ticket ticket) {
        
 
          try {
            Class.forName(DRIVER_NAME);  // 把符合的API 全部都進來 但是會有 expection , try catach 去擷取
            Connection conn = DriverManager.getConnection(CONN_STRING);
            String query = "Insert into ticket_Info "
                         + "(mail_account,phone_password,order_date,"
                         + "session_ID,people,valid,seat_list)"
            		 +" VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ppstemt = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);

            //ppstemt.setInt(1, customer.get_C_ticket_no());
            ppstemt.setString(1, ticket.getMail_account());
            ppstemt.setString(2, ticket.getPhone_password());
            ppstemt.setString(3, ticket.getOrder_date());
            ppstemt.setInt(4, ticket.getSession_ID());
            ppstemt.setInt(5, ticket.getPeople());
            ppstemt.setString(6, ticket.getValid());
            ppstemt.setString(7, ticket.getSeat_list());
            ppstemt.executeUpdate();
            ResultSet rs = ppstemt.getGeneratedKeys();
            rs.next();
            int auto_id = rs.getInt(1);
            rs.close();
            ppstemt.cancel();
            conn.close();           
            
            return auto_id;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        }      
               
        return -1;
                
    
    
    
    }
}
