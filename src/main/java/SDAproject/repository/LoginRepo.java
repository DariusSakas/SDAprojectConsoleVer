package SDAproject.repository;

import SDAproject.Exceptions.LoginAllreadyTakenException;
import SDAproject.connectionUtil.HibernateUtility;
import SDAproject.model.Login;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginRepo {

    private static final String SELECT_FROM_LOGIN = "SELECT nickname FROM LOGIN";

    private Scanner loginScanner = new Scanner(System.in);

    private Session session = HibernateUtility.getSessionFactory().openSession();
    private Transaction transaction = session.beginTransaction();
    private Connection connection;

    {
        try {
            connection = HibernateUtility.openConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private boolean takenLoginName = true;

    public void setTakenLoginName(boolean takenLoginName) {
        this.takenLoginName = takenLoginName;
    }

    public void createNewAccount() {
        Login newAccountLogin = new Login();

        do {
            try {
                newAccountLogin.setNickname(insertNickName());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        } while (takenLoginName == true);
        newAccountLogin.setPass(insertPass());

        session.save(newAccountLogin);
        transaction.commit();
    }

    private String insertPass() {
        System.out.println("Type your pass:");
        String newPass = loginScanner.next();

        return newPass;
    }

    private String insertNickName() throws LoginAllreadyTakenException, SQLException {
        System.out.println("Type your nickname:");
        String nickName = loginScanner.next();

        PreparedStatement preparedFindNickNameStatement = connection.prepareStatement(
                SELECT_FROM_LOGIN    );
        ResultSet loginNameResultSet = preparedFindNickNameStatement.executeQuery();
        List<String> loginNameResultList = new ArrayList<>();

        while (loginNameResultSet.next()) {
           loginNameResultList.add(loginNameResultSet.getString("nickname"));
        }
        loginNameResultList.stream().filter(e->e.equals(nickName)).forEach({return "a";};);
        setTakenLoginName(false);
        return nickName;
    }
//    private void checkIfLoginAvaible(){

//    }

}
