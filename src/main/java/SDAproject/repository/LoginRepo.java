package SDAproject.repository;

import SDAproject.Exceptions.LoginAllreadyTakenException;
import SDAproject.connectionUtil.HibernateUtility;
import SDAproject.model.Login;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginRepo {

    private String nickname;


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

    private void setTakenLoginName(boolean value) {
        this.takenLoginName = value;
    }
    private void setNickname(String nickname) {
        this.nickname = nickname;
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

        setNickname(loginScanner.next());

        String SELECT_FROM_LOGIN = String.format("SELECT * FROM LOGIN WHERE nickname = '%s'", nickname);

        PreparedStatement preparedFindNickNameStatement = connection.prepareStatement(
                SELECT_FROM_LOGIN);
        ResultSet loginNameResultSet = preparedFindNickNameStatement.executeQuery();
        List<String> loginNameResultList = new ArrayList<>();

        while (loginNameResultSet.next()) {
            loginNameResultList.add(loginNameResultSet.getString("nickname"));
        }
        if (loginNameResultList.isEmpty()){
            setTakenLoginName(false);
            return nickname;
        }
        else
            throw new LoginAllreadyTakenException();
//        loginNameResultList.stream().filter(e->e.equals(nickName) ? throwNewLoginException());

    }
}
