package ir.maktab.project;

import ir.maktab.project.util.ApplicationContext;

import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ApplicationContext context = new ApplicationContext();
        //context.getDatabaseInitializer().init();
        //context.getEconomyRepository().findCorridor();
        while (true)
            context.getMenu().mainMenu();
    }
}
