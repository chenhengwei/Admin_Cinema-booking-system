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

public class MovieDAODBImpl implements MovieDAO {

    final String DRIVER_NAME = "com.mysql.jdbc.Driver"; // MySQL 的名子 可以從datasheet取看
    final String CONN_STRING = "jdbc:mysql://173.194.224.58:3306/movie_ticket?"
            + "user=admin&password=admin&useUnicode=true&characterEncoding=utf-8"; // 帳號密碼

    @Override
    public void add_Movie(Movie movie) {
        try {
            Class.forName(DRIVER_NAME);  // 把符合的API 全部都進來 但是會有 expection , try catach 去擷取
            Connection conn = DriverManager.getConnection(CONN_STRING);
            String query = "Insert into movie_Info "
                    + "(movie_name_chinese, movie_name_eng, release_date, version, "
                    + "movie_length, actor, director, picture_url) "
                    + "values(?,?,?,?,?,?,?,?)";
            PreparedStatement ppstemt = conn.prepareStatement(query);
            //ppst//emt.setInt(1, student.student_Id);
            //ppstemt.setInt(1, movie.get_m_no());
            ppstemt.setString(1, movie.get_m_name_c());
            ppstemt.setString(2, movie.get_m_name_e());
            ppstemt.setString(3, movie.get_release_date());
            ppstemt.setString(4, movie.get_version());
            ppstemt.setInt(5, movie.get_m_length());
            ppstemt.setString(6, movie.get_actor());
            ppstemt.setString(7, movie.get_director());
            ppstemt.setString(8, movie.get_picture_url());

            ppstemt.executeUpdate();
            ppstemt.cancel();
            conn.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

//          try {
//            Class.forName(DRIVER_NAME);  // 把符合的API 全部都進來 但是會有 expection , try catach 去擷取
//            Connection conn = DriverManager.getConnection(CONN_STRING);
//            String query = "Insert into movie_Info "
//                    + "(movie_no, movie_name_chinese, movie_name_eng, release_date, version, "
//                    + "movie_length, actor, director, picture_url) "
//                    + "values(?,?,?,?,?,?,?,?,?)";
//            PreparedStatement ppstemt = conn.prepareStatement(query);
//            //ppst//emt.setInt(1, student.student_Id);
//            ppstemt.setInt(1, movie.get_m_no());
//            ppstemt.setString(2, movie.get_m_name_c());
//            ppstemt.setString(3, movie.get_m_name_e());
//            ppstemt.setString(4, movie.get_release_date());
//            ppstemt.setString(5, movie.get_version());
//            ppstemt.setInt(6, movie.get_m_length());
//            ppstemt.setString(7, movie.get_actor());
//            ppstemt.setString(8, movie.get_director());
//            ppstemt.setString(9, movie.get_picture_url());
//            
//            ppstemt.executeUpdate();
//            ppstemt.cancel();
//            conn.close();
//
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(MovieDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(MovieDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    //華郁
    @Override
    public int add1(Movie movie) {
        int count = 0;
        try {
            Class.forName(DRIVER_NAME);  // 把符合的API 全部都進來 但是會有 expection , try catach 去擷取
            Connection conn = DriverManager.getConnection(CONN_STRING);
            String query = "Insert into movie_Info "
                    + "(movie_name_chinese, movie_name_eng, release_date, version, "
                    + "movie_length, actor, director, picture_url) "
                    + "values(?,?,?,?,?,?,?,?)";
            PreparedStatement ppstemt = conn.prepareStatement(query);
            //ppst//emt.setInt(1, student.student_Id);
            //ppstemt.setInt(1, movie.get_m_no());
            ppstemt.setString(1, movie.get_m_name_c());
            ppstemt.setString(2, movie.get_m_name_e());
            ppstemt.setString(3, movie.get_release_date());
            ppstemt.setString(4, movie.get_version());
            ppstemt.setInt(5, movie.get_m_length());
            ppstemt.setString(6, movie.get_actor());
            ppstemt.setString(7, movie.get_director());
            ppstemt.setString(8, movie.get_picture_url());
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
    public void update_Movie(Movie movie) {

        try {
            Class.forName(DRIVER_NAME);  // 把符合的API 全部都進來 但是會有 expection , try catach 去擷取
            Connection conn = DriverManager.getConnection(CONN_STRING);
            String query = "Update movie_Info set "
                    + "movie_name_chinese = ?, movie_name_eng = ?, release_date = ?, "
                    + "version = ?,movie_length = ?, actor = ?, director = ?, picture_url = ? "
                    + "where movie_no = ?";

            //String query_find = "Update movie_Info set students_name = ?, students_phone = ? where students_id = ?";
            PreparedStatement ppstemt = conn.prepareStatement(query);
            //ppstemt.setInt(1, student.student_Id);
            ppstemt.setString(1, movie.get_m_name_c());
            ppstemt.setString(2, movie.get_m_name_e());
            ppstemt.setString(3, movie.get_release_date());
            ppstemt.setString(4, movie.get_version());
            ppstemt.setInt(5, movie.get_m_length());
            ppstemt.setString(6, movie.get_actor());
            ppstemt.setString(7, movie.get_director());
            ppstemt.setString(8, movie.get_picture_url());
            ppstemt.setInt(9, movie.get_m_no());
            ppstemt.executeUpdate();
            ppstemt.cancel();
            conn.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //華郁    
    @Override
	public int update_Movie2(Movie movie) {
    	int count = 0;
    	try {
            Class.forName(DRIVER_NAME);  // 把符合的API 全部都進來 但是會有 expection , try catach 去擷取
            Connection conn = DriverManager.getConnection(CONN_STRING);
            String query = "Update movie_Info set "
                    + "movie_name_chinese = ?, movie_name_eng = ?, release_date = ?, "
                    + "version = ?,movie_length = ?, actor = ?, director = ?, picture_url = ? "
                    + "where movie_no = ?";

            //String query_find = "Update movie_Info set students_name = ?, students_phone = ? where students_id = ?";
            PreparedStatement ppstemt = conn.prepareStatement(query);
            //ppstemt.setInt(1, student.student_Id);
            ppstemt.setString(1, movie.get_m_name_c());
            ppstemt.setString(2, movie.get_m_name_e());
            ppstemt.setString(3, movie.get_release_date());
            ppstemt.setString(4, movie.get_version());
            ppstemt.setInt(5, movie.get_m_length());
            ppstemt.setString(6, movie.get_actor());
            ppstemt.setString(7, movie.get_director());
            ppstemt.setString(8, movie.get_picture_url());
            ppstemt.setInt(9, movie.get_m_no());
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
    public void remove_Movie(Movie movie) {
        try {
            Class.forName(DRIVER_NAME);  // 把符合的API 全部都進來 但是會有 expection , try catach 去擷取
            Connection conn = DriverManager.getConnection(CONN_STRING);
            String query_find = "Delete from movie_Info where movie_no = ?";
            PreparedStatement ppstemt = conn.prepareStatement(query_find);
            //ppstemt.setInt(1, student.student_Id);
            ppstemt.setInt(1, movie.get_m_no());
            ppstemt.executeUpdate();
            ppstemt.cancel();
            conn.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //華郁
    @Override
	public int remove_Movie2(Movie movie) {
    	int count = 0;
    	try {
            Class.forName(DRIVER_NAME);  // 把符合的API 全部都進來 但是會有 expection , try catach 去擷取
            Connection conn = DriverManager.getConnection(CONN_STRING);
            String query_find = "Delete from movie_Info where movie_no = ?";
            PreparedStatement ppstemt = conn.prepareStatement(query_find);
            //ppstemt.setInt(1, student.student_Id);
            ppstemt.setInt(1, movie.get_m_no());
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
    public Movie findById_name_c(String movie_name_chinese) {
        try {
            Class.forName(DRIVER_NAME);  // 把符合的API 全部都進來 但是會有 expection , try catach 去擷取
            Connection conn = DriverManager.getConnection(CONN_STRING);
            String query = "Select * from movie_Info where movie_name_chinese = ?";
            PreparedStatement ppstemt = conn.prepareStatement(query);
            ppstemt.setString(1, movie_name_chinese);
            ResultSet rs = ppstemt.executeQuery();
            if (rs.next()) {
                Movie m = new Movie(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9));
                return m;
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
    public Movie findById_movie_no(int movie_no) {
        try {
            Class.forName(DRIVER_NAME);  // 把符合的API 全部都進來 但是會有 expection , try catach 去擷取
            Connection conn = DriverManager.getConnection(CONN_STRING);
            String query = "Select * from movie_Info where movie_no = ?";
            PreparedStatement ppstemt = conn.prepareStatement(query);
            ppstemt.setInt(1, movie_no);
            ResultSet rs = ppstemt.executeQuery();
            if (rs.next()) {
                Movie m = new Movie(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9));
                return m;
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
    public ArrayList<Movie> getAllMovies() {
        try {

            Class.forName(DRIVER_NAME);  // 把符合的API 全部都進來 但是會有 expection , try catach 去擷取
            Connection conn = DriverManager.getConnection(CONN_STRING);
            Statement stmt = conn.createStatement();
            String query = "Select * from movie_Info";
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<Movie> alist = new ArrayList();
            while (rs.next()) {
                alist.add(new Movie(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)));

            }
            return alist;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAODBImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    //華郁
    @Override // 後台需要
	public ArrayList<Movie> findByName(String movie_name_chinese) {
		try {
			Class.forName(DRIVER_NAME); // 把符合的API 全部都進來 但是會有 expection , try
										// catach 去擷取
			Connection conn = DriverManager.getConnection(CONN_STRING);
			/*PreparedStatement pstmt = conn
					.prepareStatement("Select * from movie_Info WHERE movie_name_chinese LIKE '%?%' ");			
			pstmt.setString(1, movie_name_chinese);*/
			Statement stmt = conn.createStatement();
			String query = "Select * from movie_Info WHERE movie_name_chinese LIKE '%" + movie_name_chinese +"%'";
			ResultSet rs = stmt.executeQuery(query);
			ArrayList<Movie> alist = new ArrayList();
			while (rs.next()) {
				alist.add(new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9)));

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
    public void add_Customer(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update_Customer(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove_Customer(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer findById_C_Mail_PhoneP(String mail_account, String phone_password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer findById_C_Mail(String mail_account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Customer> getAllCustomers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
	
}
