package database;

import java.sql.*;
import java.time.LocalDate;

public class BirthdayData {

    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement pSRegistration;
    private static PreparedStatement pSChangeData;
    private static PreparedStatement pSGetBirthdayByNameAndSurname;

    private static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:birthday");
        statement = connection.createStatement();
        System.out.println("База подключена!");
    }

    private static void disconnect() throws SQLException {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createDB() throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS [birthday-users] (\n" +
                "    id       INTEGER PRIMARY KEY AUTOINCREMENT\n" +
                "    NOT NULL,\n" +
                "    surname  STRING  NOT NULL,\n" +
                "    name     STRING  NOT NULL,\n" +
                "    birthday DATE\n" +
                ");");
    }

    private static PreparedStatement pSRegistration() throws SQLException {
        pSRegistration = connection.prepareStatement("INSERT INTO 'birthday-users' (surname, name, birthday) VALUES (?, ?, ?)");
        return pSRegistration;
    }

    public static boolean registration(String surname, String name, Date birthday) throws SQLException {
        pSRegistration = pSRegistration();
        pSRegistration.setString(1, surname);
        pSRegistration.setString(2, name);
        pSRegistration.setDate(3, Date.valueOf(String.valueOf(birthday)));
        pSRegistration.executeUpdate();
        return true;
    }

    private static PreparedStatement pSChangeData() throws SQLException {
        pSChangeData = connection.prepareStatement("UPDATE 'birthday-users' SET (surname, name, birthday) VALUES (?, ?, ?)");
        return pSChangeData;
    }

    private static boolean pSChangeData(String surname, String name, LocalDate birthday) throws SQLException {
        pSChangeData = pSRegistration();
        pSChangeData.setString(1, surname);
        pSChangeData.setString(2, name);
        pSChangeData.setDate(3, Date.valueOf(birthday));
        pSChangeData.executeUpdate();
        return true;
    }

    private static PreparedStatement pSGetBirthdayByNameAndSurname() throws SQLException {
        pSGetBirthdayByNameAndSurname = connection.prepareStatement("SELECT birthday FROM 'birthday'  WHERE  surname = ? AND name = ?; ");
        return pSGetBirthdayByNameAndSurname;
    }

    public static String getBirthdayByNameAndSurname (String surname, String name) throws SQLException {
       LocalDate birthday = null;
        pSGetBirthdayByNameAndSurname.setString(2, surname);
        pSGetBirthdayByNameAndSurname.setString(3, name);
        ResultSet resultSet = pSGetBirthdayByNameAndSurname.executeQuery();
        if (resultSet.next()) {
            birthday = resultSet.getDate("birthday").toLocalDate();
        }
        return String.valueOf(birthday);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       BirthdayData.connect();

       BirthdayData.registration("Иванов", "Иван", Date.valueOf("1970-02-12"));

       BirthdayData.disconnect();
    }
}

