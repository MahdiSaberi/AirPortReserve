package ir.maktab.project.util;

import java.sql.*;

public class DatabaseInitializer {
    private Connection connection;

    public DatabaseInitializer(Connection connection) {
        this.connection = connection;
    }
    public void init() throws SQLException {
        initSchema();
        initBusinessClassTable();
        insertIntoBusinessClassTable();
        initEconomyTable();
        insertIntoEconomyTable();
    }

    public void initSchema() throws SQLException {
        String query = "CREATE SCHEMA IF NOT EXISTS airport_db";
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public void initBusinessClassTable() throws SQLException {

        String query = "CREATE TABLE IF NOT EXISTS airport_db.business_class_table " +
                "(" +
                "id INT NOT NULL, " +
                "`A` VARCHAR(45) NULL, " +
                "`B` VARCHAR(45) NULL, " +
                "`C` VARCHAR(45) NULL, " +
                "`D` VARCHAR(45) NULL, " +
                "PRIMARY KEY (id));";
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);

    }

    public void insertIntoBusinessClassTable() throws SQLException {
        String dropQuery = "TRUNCATE airport_db.business_class_table";
        Statement statement = connection.createStatement();
        statement.executeUpdate(dropQuery);

        String query = "INSERT INTO airport_db.business_class_table (id, A, B, C, D) VALUES ('1', 'O', 'O', 'O', 'O');";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
        query = "INSERT INTO airport_db.business_class_table (id, A, B, C, D) VALUES ('2', 'O', 'O', 'O', 'O');";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
        query = "INSERT INTO airport_db.business_class_table (id, A, B, C, D) VALUES ('3', 'O', 'O', 'O', 'O');";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
        query = "INSERT INTO airport_db.business_class_table (id, A, B, C, D) VALUES ('4', 'O', 'O', 'O', 'O');";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
        query = "INSERT INTO airport_db.business_class_table (id, A, B, C, D) VALUES ('5', 'O', 'O', 'O', 'O');";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
    }

    public void initEconomyTable() throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS airport_db.economy_table ( " +
                "id INT NULL, " +
                "`A` VARCHAR(45) NULL, " +
                "`B` VARCHAR(45) NULL, " +
                "`C` VARCHAR(45) NULL, " +
                "`D` VARCHAR(45) NULL, " +
                "`E` VARCHAR(45) NULL, " +
                "`F` VARCHAR(45) NULL, " +
                "PRIMARY KEY (id))";
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public void insertIntoEconomyTable() throws SQLException {
        String dropQuery = "TRUNCATE airport_db.economy_table";
        Statement statement = connection.createStatement();
        statement.executeUpdate(dropQuery);

        String query = "INSERT INTO airport_db.economy_table (id, A, B, C, D, E, F) VALUES ('1', 'O', 'O', 'O', 'O','O','O');";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
        query = "INSERT INTO airport_db.economy_table (id, A, B, C, D, E, F) VALUES ('2', 'O', 'O', 'O', 'O','O','O');";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
        query = "INSERT INTO airport_db.economy_table (id, A, B, C, D, E, F) VALUES ('3', 'O', 'O', 'O', 'O','O','O');";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
        query = "INSERT INTO airport_db.economy_table (id, A, B, C, D, E, F) VALUES ('4', 'O', 'O', 'O', 'O','O','O');";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
        query = "INSERT INTO airport_db.economy_table (id, A, B, C, D, E, F) VALUES ('5', 'O', 'O', 'O', 'O','O','O');";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
        query = "INSERT INTO airport_db.economy_table (id, A, B, C, D, E, F) VALUES ('6', 'O', 'O', 'O', 'O','O','O');";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
        query = "INSERT INTO airport_db.economy_table (id, A, B, C, D, E, F) VALUES ('7', 'O', 'O', 'O', 'O','O','O');";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
        query = "INSERT INTO airport_db.economy_table (id, A, B, C, D, E, F) VALUES ('8', 'O', 'O', 'O', 'O','O','O');";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
        query = "INSERT INTO airport_db.economy_table (id, A, B, C, D, E, F) VALUES ('9', 'O', 'O', 'O', 'O','O','O');";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
        query = "INSERT INTO airport_db.economy_table (id, A, B, C, D, E, F) VALUES ('10', 'O', 'O', 'O', 'O','O','O');";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
        query = "INSERT INTO airport_db.economy_table (id, A, B, C, D, E, F) VALUES ('11', 'O', 'O', 'O', 'O','O','O');";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
        query = "INSERT INTO airport_db.economy_table (id, A, B, C, D, E, F) VALUES ('12', 'O', 'O', 'O', 'O','O','O');";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
        query = "INSERT INTO airport_db.economy_table (id, A, B, C, D, E, F) VALUES ('13', 'O', 'O', 'O', 'O','O','O');";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
        query = "INSERT INTO airport_db.economy_table (id, A, B, C, D, E, F) VALUES ('14', 'O', 'O', 'O', 'O','O','O');";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
        query = "INSERT INTO airport_db.economy_table (id, A, B, C, D, E, F) VALUES ('15', 'O', 'O', 'O', 'O','O','O');";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
    }
}
