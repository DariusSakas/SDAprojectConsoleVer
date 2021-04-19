package SDAproject;

import HibernateTask2.util.HibernateTask2Utility;
import SDAproject.view.menu.ShowLoginMenu;

public class ApplicationRun {
    public static void main(String[] args) {

        ShowLoginMenu showLoginMenu = new ShowLoginMenu();
        showLoginMenu.createLoginMenu();

    }
}
