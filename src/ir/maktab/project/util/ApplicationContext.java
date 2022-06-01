package ir.maktab.project.util;

import ir.maktab.project.Repository.BusinessRepository;
import ir.maktab.project.Repository.EconomyRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class ApplicationContext {
    private EconomyRepository economyRepository = null;
    private BusinessRepository businessRepository = null;
    private DatabaseUtil databaseUtil = null;
    private DatabaseInitializer databaseInitializer = null;
    private Scanner intScanner = null;
    private Scanner stringScanner = null;
    private Menu menu = null;

    public ApplicationContext() throws SQLException, ClassNotFoundException {
        this.databaseUtil = new DatabaseUtil();
        this.databaseInitializer = new DatabaseInitializer(this.databaseUtil.getConnection());
    }

    public Menu getMenu() {
        this.menu = new Menu();
        return menu;
    }

    public DatabaseInitializer getDatabaseInitializer() {
        return databaseInitializer;
    }

    public DatabaseUtil getDatabaseUtil() {
        return databaseUtil;
    }

    public Scanner getIntScanner() {
        if (intScanner == null)
            this.intScanner = new Scanner(System.in);
        return intScanner;
    }

    public Scanner getStringScanner() {
        if (stringScanner == null)
            this.stringScanner = new Scanner(System.in);
        return stringScanner;
    }

    public EconomyRepository getEconomyRepository() {
        if(economyRepository == null)
            this.economyRepository = new EconomyRepository(databaseUtil.getConnection());
        return economyRepository;
    }

    public BusinessRepository getBusinessRepository() {
        if(businessRepository == null)
            this.businessRepository = new BusinessRepository(databaseUtil.getConnection());
        return businessRepository;
    }
}

