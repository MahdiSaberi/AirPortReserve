package ir.maktab.project.Repository;

import ir.maktab.project.domain.Economy;
import ir.maktab.project.util.DatabaseUtil;
import ir.maktab.project.util.Menu;

import java.sql.*;
import java.util.ArrayList;

public class EconomyRepository {
    private Connection connection;
    private Economy economy;

    public EconomyRepository(){}

    public EconomyRepository(Connection connection){
        this.connection = connection;
    }

    public void showEconomySeats() throws SQLException, ClassNotFoundException {
        System.out.println("Economy Class:");
        DatabaseUtil databaseUtil = new DatabaseUtil();
        String query = "SELECT * FROM airport_db.economy_table where id = ?";
        query = "SELECT * FROM airport_db.economy_table where id = ?";

        PreparedStatement preparedStatement = databaseUtil.getConnection().prepareStatement(query);
        int counter = 0;
        for(int row = 1; row <= 15;row++){
            preparedStatement.setInt(1,row);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){

                for(int i = 2;i <=7;i++){
                    counter++;
                    if(row*6 - 5==counter)
                        System.out.print("|");
                    System.out.print(resultSet.getString(i));

                    if(row*6==counter)
                        System.out.print("|");

                    if(i==4)
                        System.out.print("||");
                    if(i==7)
                        System.out.println();
                }

            }

        }

    }
    public void findCorridor() throws SQLException, ClassNotFoundException {
        Menu menu = new Menu();
        DatabaseUtil databaseUtil = new DatabaseUtil();
        String query = "SELECT * FROM airport_db.economy_table where id = ?";
        PreparedStatement preparedStatement = databaseUtil.getConnection().prepareStatement(query);
        ArrayList<String> seats = new ArrayList<>();

        for(int row = 1; row <= 15;row++){
            preparedStatement.setInt(1,row);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                for(int i = 1;i <=7;i++)
                    seats.add(resultSet.getString(i));
            }
        }

        boolean reserved = false;

        for(int i = 3;i <=104;i=i+7){
            if(seats.get(i).equals("O")){
                seats.set(i,"X");
                menu.successfully();
                reserved = true;
                break;
            }
        }

        if(!reserved){
            for(int i = 4;i<=104;i=i+7){
                if(seats.get(i).equals("O")){
                    seats.set(i,"X");
                    menu.successfully();
                    reserved = true;
                    break;
                }
            }
        }

        if(!reserved)
            menu.error();
        //System.out.println(seats);
        setValuesInEconomyTable(seats);
    }

    public void findWindow() throws SQLException, ClassNotFoundException {
        Menu menu = new Menu();
        DatabaseUtil databaseUtil = new DatabaseUtil();
        String query = "SELECT * FROM airport_db.economy_table where id = ?";
        PreparedStatement preparedStatement = databaseUtil.getConnection().prepareStatement(query);
        ArrayList<String> seats = new ArrayList<>();

        for(int row = 1; row <= 15;row++){
            preparedStatement.setInt(1,row);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                for(int i = 1;i <=7;i++)
                    seats.add(resultSet.getString(i));
            }
        }

        boolean reserved = false;
        for(int i = 1;i <=104;i=i+7){
            if(seats.get(i).equals("O")){
                seats.set(i,"X");
                menu.successfully();
                reserved = true;
                break;
            }
        }

        if(!reserved){
            for(int i = 6;i<=104;i=i+7){
                if(seats.get(i).equals("O")){
                    seats.set(i,"X");
                    menu.successfully();
                    reserved = true;
                    break;
                }
            }
        }
        if(!reserved)
            menu.error();
        setValuesInEconomyTable(seats);
    }

    public void findMiddle() throws SQLException, ClassNotFoundException {
        Menu menu = new Menu();
        DatabaseUtil databaseUtil = new DatabaseUtil();
        String query = "SELECT * FROM airport_db.economy_table where id = ?";
        PreparedStatement preparedStatement = databaseUtil.getConnection().prepareStatement(query);
        ArrayList<String> seats = new ArrayList<>();

        for(int row = 1; row <= 15;row++){
            preparedStatement.setInt(1,row);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                for(int i = 1;i <=7;i++)
                    seats.add(resultSet.getString(i));
            }
        }

        boolean reserved = false;

        for(int i = 2;i <=104;i=i+7){
            if(seats.get(i).equals("O")){
                seats.set(i,"X");
                menu.successfully();
                reserved = true;
                break;
            }
        }

        if(!reserved){
            for(int i = 5;i<=104;i=i+7){
                if(seats.get(i).equals("O")){
                    seats.set(i,"X");
                    menu.successfully();
                    reserved = true;
                    break;
                }
            }
        }
        if(!reserved)
            menu.error();
        setValuesInEconomyTable(seats);
    }

    public void setValuesInEconomyTable(ArrayList<String> seats) throws SQLException, ClassNotFoundException {
        String dropQuery = "TRUNCATE airport_db.economy_table";
        Statement statement = connection.createStatement();
        statement.executeUpdate(dropQuery);

        for(int i = 0;i <=90;i = i + 7){
            String query =
                    "INSERT INTO airport_db.economy_table (id, A, B, C, D, E, F) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,seats.get(i));
            preparedStatement.setString(2,seats.get(i+1));
            preparedStatement.setString(3,seats.get(i+2));
            preparedStatement.setString(4,seats.get(i+3));
            preparedStatement.setString(5,seats.get(i+4));
            preparedStatement.setString(6,seats.get(i+5));
            preparedStatement.setString(7,seats.get(i+6));
            preparedStatement.executeUpdate();
        }
    }
}
