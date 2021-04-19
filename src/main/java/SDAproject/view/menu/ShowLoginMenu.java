package SDAproject.view.menu;

import SDAproject.repository.LoginRepo;
import SDAproject.view.viewElements.CreatingNewAccount;

import java.util.Scanner;

public class ShowLoginMenu {
    public void createLoginMenu(){
        while(true) {
            CreatingNewAccount.createNewAccHeader();

            LoginRepo loginRepo = new LoginRepo();
            ShowMainMenu showMainMenu = new ShowMainMenu();

            Scanner loginScanner = new Scanner(System.in);

            System.out.println("1.Log in into your account");
            System.out.println("2.Create a new account");

            switch (loginScanner.next()) {
                case ("1"):

                    break;
                case ("2"):
                    loginRepo.createNewAccount();
                    break;
                default:
                    System.out.println("No such choice");
            }
        }
    }
}
