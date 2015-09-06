
import edu.pccu.Movie.*;

public class T_find_C_Mail {

    public static void main(String[] args) {
        MovieDAO dao = new CustomerDAODBImpl();
        String C_mail_account= "wesley@gmail.com";
        String C_phone_password = "0933231110";
        
        Customer c = dao.findById_C_Mail(C_mail_account);
        System.out.println(
                  "訂單編號: " + c.get_C_ticket_no()
                + "\nMail Account: " + c.get_C_mail_account()
                + "\n電話(Password): " + c.get_C_phone_password()
                + "\n訂單日期: " + c.get_C_order_date()
                + "\nSession ID: " + c.get_C_session_ID()
                + "\n訂票數量: " + c.get_C_people()
                + "\n訂單人: " + c.get_C_customer_name()
        );
    }

}
