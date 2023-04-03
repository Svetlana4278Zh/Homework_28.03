package task1;

import java.sql.*;

public class Application {
    public static void main(String[] args) throws SQLException {
        final String user = "postgres";
        final String password = "15974911";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (final Connection connection =
                     DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM employee WHERE id = (?)")) {

            statement.setInt(1,4);
            final ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int idOfEmployee = resultSet.getInt("id");
                String firstNameOfEmployee = resultSet.getString("first_name");
                String lastNameOfEmployee = resultSet.getString("last_name");
                String genderOfEmployee = resultSet.getString("gender");
                int ageOfEmployee = resultSet.getInt("age");
                int cityIdOfEmployee = resultSet.getInt("city_id");
                System.out.println("ID сотрудника: " + idOfEmployee);
                System.out.println("Имя: " + firstNameOfEmployee + " " + lastNameOfEmployee);
                System.out.println("Пол: " + genderOfEmployee);
                System.out.println("Возраст: " + ageOfEmployee);
                System.out.println("ID города: " + cityIdOfEmployee);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }
    }
}
