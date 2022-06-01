package ir.maktab.project.util;

import java.sql.SQLException;

public class Menu {
    //menu
    public void mainMenu() throws SQLException, ClassNotFoundException {
        ApplicationContext context = new ApplicationContext();
        System.out.println("==========\nMenu\n==========");
        System.out.println("1.View Airplane Seat\n2.Reserve Seat\n3.Exit");

        int select = context.getIntScanner().nextInt();
        switch(select){
            case 1:
                context.getMenu().viewAirplaneSeatMenu();
                break;
            case 2:
                context.getMenu().chooseTypeSeatMenu();
                break;
            case 3:
                System.exit(0);
        }
    }

    public void viewAirplaneSeatMenu() throws SQLException, ClassNotFoundException {
        ApplicationContext context = new ApplicationContext();

        System.out.println("==========\nMenu/View Airplane Seat\n==========");
        context.getBusinessRepository().showBusinessSeats();
        context.getEconomyRepository().showEconomySeats();
        System.out.println("1.Choose Your seat\n2.Back");
        int select = context.getIntScanner().nextInt();
        switch (select){
            case 1:
                chooseTypeSeatMenu();
                break;
            case 2:
                mainMenu();
                break;
        }
    }

    public void chooseTypeSeatMenu() throws SQLException, ClassNotFoundException {
        ApplicationContext context = new ApplicationContext();
        System.out.println("==========\nMenu/View Airplane Seat/Choose Your seat\n==========");
        System.out.println("Choose Type:\n1.Business Class\n2.Economy\n3.Back");
        int select = context.getIntScanner().nextInt();
        switch (select){
            case 1:
                businessMenu();
                break;
            case 2:
                economyMenu();
                break;
            case 3:
                mainMenu();
                break;
        }

    }

    public void businessMenu() throws SQLException, ClassNotFoundException {
        ApplicationContext context = new ApplicationContext();
        System.out.println("==========\nMenu/View Airplane Seat/Choose Your seat/Business Class\n==========");
        context.getBusinessRepository().showBusinessSeats();
        System.out.println("Choose your Seat Situation:\n1.By the Window\n2.By the Corridor");
        int select = context.getIntScanner().nextInt();
        switch (select){
            case 1:
                context.getBusinessRepository().findWindow();
                break;
            case 2:
                context.getBusinessRepository().findCorridor();
                break;
        }

    }

    public void economyMenu() throws SQLException, ClassNotFoundException {
        ApplicationContext context = new ApplicationContext();
        System.out.println("==========\nMenu/View Airplane Seat/Choose Your seat/Economy\n==========");
        context.getEconomyRepository().showEconomySeats();
        System.out.println("Choose your Seat Situation:\n1.By the Window\n2.Middle\n3.By the Corridor");
        int select = context.getIntScanner().nextInt();
        switch (select){
            case 1:
                context.getEconomyRepository().findWindow();
                break;
            case 2:
                context.getEconomyRepository().findMiddle();
                break;
            case 3:
                context.getEconomyRepository().findCorridor();
                break;
        }

    }

    public void successfully(){
        System.out.println("Successfully Reserved!");
    }

    public void error(){
        System.out.println("This Seat already Reserved!");
    }
}
