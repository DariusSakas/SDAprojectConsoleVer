package SDAproject.showMenu;

import SDAproject.view.Header;

public class ShowMainMenu {
    private void showMenu(){
        System.out.print("\033[H\033[2J");
        System.out.flush();

        Header.createHeader();
        System.out.println("1. List all products");
        System.out.println("2. List all products");
        System.out.println("1. List all products");


    }
}
