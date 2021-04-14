package SDAproject.repository;

import SDAproject.connectionUtil.HibernateUtility;
import SDAproject.model.Login;
import SDAproject.view.CreatingNewAccount;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class LoginRepo {
    Scanner loginScanner = new Scanner(System.in);

    public void createNewAccount() {

        Session session = HibernateUtility.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Login newAccountLogin = new Login();
        newAccountLogin.setNickname(insertNickName());
        newAccountLogin.setPass(insertPass());


        session.save(newAccountLogin);
        transaction.commit();
    }

    private String insertPass() {
        CreatingNewAccount.createNewAccHeader();
        System.out.println("Type your pass:");
        String newPass = loginScanner.next();

        return newPass;
    }

    private String insertNickName(){
        CreatingNewAccount.createNewAccHeader();
        System.out.println("Type your nickname:");
        String nickName = loginScanner.next();

        return nickName;
    }

}
