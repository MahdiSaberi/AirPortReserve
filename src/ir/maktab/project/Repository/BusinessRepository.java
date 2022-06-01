package ir.maktab.project.Repository;

import ir.maktab.project.domain.Business;
import ir.maktab.project.util.ApplicationContext;
import ir.maktab.project.util.DatabaseUtil;
import ir.maktab.project.util.Menu;

import java.sql.*;
import java.util.ArrayList;

public class BusinessRepository {
    private Connection connection;
    private Business business;

    public BusinessRepository(Connection connection) {
        this.connection = connection;
    }

    public void showBusinessSeats() throws SQLException, ClassNotFoundException {
        System.out.println("Business Class:");

        DatabaseUtil databaseUtil = new DatabaseUtil();
        String query = "SELECT * FROM airport_db.business_class_table where id = ?";

        PreparedStatement preparedStatement = databaseUtil.getConnection().prepareStatement(query);
        int counter = 0;
        for(int row = 1; row <= 15;row++){
            preparedStatement.setInt(1,row);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){

                for(int i = 2;i <=5;i++){
                    counter++;
                    if(row*4 - 3==counter)
                        System.out.print("|");
                    System.out.print(resultSet.getString(i));

                    if(row*4==counter)
                        System.out.print("|");

                    if(i==3)
                        System.out.print("||");

                    if(i==5)
                        System.out.println();
                }

            }
        }

    }

    public void findWindow() throws SQLException, ClassNotFoundException {
        Menu menu = new Menu();
        DatabaseUtil databaseUtil = new DatabaseUtil();
        String query = "SELECT * FROM airport_db.business_class_table where id = ?";
        PreparedStatement preparedStatement = databaseUtil.getConnection().prepareStatement(query);

        ArrayList<String> seats = new ArrayList<>();

        for(int row = 1; row <= 15;row++){
            preparedStatement.setInt(1,row);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                for(int i = 1;i <=5;i++)
                    seats.add(resultSet.getString(i));
            }
        }

        boolean reserved = false;
        for(int i = 1;i <=24;i=i+5){
            if(seats.get(i).equals("O")){
                seats.set(i,"X");
                menu.successfully();
                reserved = true;
                break;
            }
        }

        if(!reserved){
            for(int i = 4;i<=24;i=i+5){
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
        setValuesInBusinessTable(seats);
    }

    public void findCorridor() throws SQLException, ClassNotFoundException {
        Menu menu = new Menu();
        DatabaseUtil databaseUtil = new DatabaseUtil();
        String query = "SELECT * FROM airport_db.business_class_table where id = ?";
        PreparedStatement preparedStatement = databaseUtil.getConnection().prepareStatement(query);

        ArrayList<String> seats = new ArrayList<>();

        for(int row = 1; row <= 15;row++){
            preparedStatement.setInt(1,row);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                for(int i = 1;i <=5;i++)
                    seats.add(resultSet.getString(i));
            }
        }

        boolean reserved = false;

        for(int i = 2;i <=24;i=i+5){
            if(seats.get(i).equals("O")){
                seats.set(i,"X");
                menu.successfully();
                reserved = true;
                break;
            }
        }

        if(!reserved){
            for(int i = 3;i<=24;i=i+5){
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
        setValuesInBusinessTable(seats);
    }

    public void setValuesInBusinessTable(ArrayList<String> seats) throws SQLException, ClassNotFoundException {
        String dropQuery = "TRUNCATE airport_db.business_class_table";
        Statement statement = connection.createStatement();
        statement.executeUpdate(dropQuery);

        for(int i = 0;i <=20;i = i + 5){
            String query =
                    "INSERT INTO airport_db.business_class_table (id, A, B, C, D) " +
                    "VALUES (?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,seats.get(i));
            preparedStatement.setString(2,seats.get(i+1));
            preparedStatement.setString(3,seats.get(i+2));
            preparedStatement.setString(4,seats.get(i+3));
            preparedStatement.setString(5,seats.get(i+4));
            preparedStatement.executeUpdate();
        }


    }
}
