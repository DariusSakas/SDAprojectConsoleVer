package SDAproject;

import HibernateTask2.util.HibernateTask2Utility;
import SDAproject.connectionUtil.HibernateUtility;
import SDAproject.showMenu.ShowLoginMenu;
import org.hibernate.Session;

public class ApplicationRun {
    public static void main(String[] args) {

        ShowLoginMenu showLoginMenu = new ShowLoginMenu();
        showLoginMenu.createLoginMenu();

    }
}
