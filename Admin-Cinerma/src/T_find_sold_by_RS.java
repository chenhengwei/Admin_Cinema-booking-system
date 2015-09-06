
import edu.pccu.Movie.*;

public class T_find_sold_by_RS {

    public static void main(String[] args) {
        SeatDAO saet_dao = new SeatsDAODBImpl();
        String R = "2";
        String S = "1";
        String s = saet_dao.find_Seat_by_RS(R, S);
        System.out.println(s);

        
        String[] arr_R = R.split(",");
	String[] arr_S = S.split(",");
    }

}
