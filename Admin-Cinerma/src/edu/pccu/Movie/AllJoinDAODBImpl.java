package edu.pccu.Movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AllJoinDAODBImpl implements AllJoinDAO{
	
	final String DRIVER_NAME = "com.mysql.jdbc.Driver"; // MySQL 的名子 可以從datasheet取看
    final String CONN_STRING = "jdbc:mysql://173.194.224.58:3306/movie_ticket?"
            + "user=admin&password=admin&useUnicode=true&characterEncoding=utf-8"; // 帳號密碼
    
	@Override
	public ArrayList<AllJoin> getAllTickets() {
		try {
            Class.forName(DRIVER_NAME); // 把符合的API 全部都進來 但是會有 expection , try
            // catach 去擷取
            Connection conn = DriverManager.getConnection(CONN_STRING);
            Statement stmt = conn.createStatement();
			String query = "SELECT T.*,S.room,S.show_date,S.show_time,"
					+ "M.movie_name_chinese,M.movie_name_eng,M.version,M.movie_length "
					+ "FROM ticket_Info AS T,session AS S,movie_Info AS M "
					+ "WHERE T.session_ID = S.session_ID AND S.movie_no = M.movie_no";
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<AllJoin> alist = new ArrayList<AllJoin>();
            while (rs.next()) {
            	alist.add(new AllJoin(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),
            			rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),
            			rs.getString(11),rs.getString(12),rs.getString(13), rs.getInt(14)));
            	//alist.add(new Ticket(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7)));

            }
            return alist;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
	}

	@Override
	public ArrayList<AllJoin> getOrderedTickets(String mail_account, String phone_password) {
		try {
            Class.forName(DRIVER_NAME); // 把符合的API 全部都進來 但是會有 expection , try
            // catach 去擷取
            Connection conn = DriverManager.getConnection(CONN_STRING);
            Statement stmt = conn.createStatement();
            String query = "SELECT T.*,S.room,S.show_date,S.show_time,"
					+ "M.movie_name_chinese,M.movie_name_eng,M.version,M.movie_length "
					+ "FROM ticket_Info AS T,session AS S,movie_Info AS M "
					+ "WHERE T.session_ID = S.session_ID AND S.movie_no = M.movie_no "
            		+ "AND mail_account = '" + mail_account +
                    "' AND phone_password = '" + phone_password + "'";
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<AllJoin> alist = new ArrayList();
            while (rs.next()) {
            	alist.add(new AllJoin(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),
            			rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),
            			rs.getString(11),rs.getString(12),rs.getString(13), rs.getInt(14)));

            }
            return alist;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
	}

	@Override
	public ArrayList<AllJoin> getOrderedTickets(String mail_account) {
		try {
            Class.forName(DRIVER_NAME); // 把符合的API 全部都進來 但是會有 expection , try
            // catch 去擷取
            Connection conn = DriverManager.getConnection(CONN_STRING);
            Statement stmt = conn.createStatement();
            String query = "SELECT T.*,S.room,S.show_date,S.show_time,"
					+ "M.movie_name_chinese,M.movie_name_eng,M.version,M.movie_length "
					+ "FROM ticket_Info AS T,session AS S,movie_Info AS M "
					+ "WHERE T.session_ID = S.session_ID AND S.movie_no = M.movie_no "
            		+ "AND mail_account='" + mail_account + "'";
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<AllJoin> alist = new ArrayList<AllJoin>();
            while (rs.next()) {
            	alist.add(new AllJoin(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),
            			rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),
            			rs.getString(11),rs.getString(12),rs.getString(13), rs.getInt(14)));
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
