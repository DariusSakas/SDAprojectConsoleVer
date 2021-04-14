package SDAproject.showMenu;

import SDAproject.repository.LoginRepo;
import SDAproject.view.Footer;
import SDAproject.view.Header;

import java.util.Scanner;

public class ShowLoginMenu {
    public void createLoginMenu(){
        Header.createHeader();

        LoginRepo loginRepo = new LoginRepo();
        ShowMainMenu showMainMenu = new ShowMainMenu();

        Scanner loginScanner = new Scanner(System.in);

        System.out.println("1.Log in into your account");
        System.out.println("2.Create a new account");
        System.out.println("Press any button to exit.");

        switch (loginScanner.next()){
            case("1"):
                loginRepo.createNewAccount();

        }

        Footer.createFooter();
    }
}
