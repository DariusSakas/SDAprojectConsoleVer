package SDAproject.repository;

import SDAproject.connectionUtil.HibernateUtility;
import SDAproject.model.Login;
import SDAproject.view.CreatingNewAccount;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class LoginRepo {

    Scanner loginScanner = new Scanner(System.in);

    Session session = HibernateUtility.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();

    public void createNewAccount() {

        Login newAccountLogin = new Login();
        newAccountLogin.setNickname(insertNickName());
        newAccountLogin.setPass(insertPass());

        session.save(newAccountLogin);
        transaction.commit();
    }

    private String insertPass() {
        System.out.println("Type your pass:");
        String newPass = loginScanner.next();

        return newPass;
    }

    private String insertNickName(){
        System.out.println("Type your nickname:");
        String nickName = loginScanner.next();
        boolean taken = true;

        String loginQuery = "SELECT nickname FROM LOGIN";

        if(taken)
            System.out.println("Taken, try again");
        return nickName;
    }
    private void checkIfLoginAvaible(String nickname){

    }

}
