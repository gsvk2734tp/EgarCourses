package ru.example.egar.jdbc;

import java.sql.*;

public class Main {
    private static final String url = "jdbc:postgresql://localhost/egar?user=postgres&password=postgres";

    public static void main(String[] args) {
        /* Statement */
        try (Connection connection = DriverManager.getConnection(url)) {
            Statement statement = connection.createStatement();
            statement.execute("delete from roles");
            statement.execute("delete from products");
            statement.execute("delete from delivery_types");
            statement.execute("insert into roles values (1, 'User'), (2, 'Admin')");
            ResultSet rs = statement.executeQuery("select * from roles");
            System.out.println("Statement DELETE, INSERT, SELECT, UPDATE");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " : " + rs.getString("role"));
            }
            statement.execute("update roles SET role = 'SUPER_ADMIN' WHERE id = 2");
            ResultSet rs2 = statement.executeQuery("select * from roles");
            while (rs2.next()) {
                System.out.println(rs2.getInt("id") + " : " + rs2.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /* PreparedStatement */
        try (Connection connection = DriverManager.getConnection(url)) {
            PreparedStatement statement = connection.prepareStatement("insert into products(id, name) values (?,?)");
            statement.setInt(1, 1);
            statement.setString(2, "MAX");
            statement.executeUpdate();
            statement = connection.prepareStatement("select * from products where id = ?");
            statement.setInt(1, 1);
            ResultSet rs = statement.executeQuery();
            System.out.println("PreparedStatement INSERT, SELECT");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " : " + rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /* CallableStatement */
        try (Connection connection = DriverManager.getConnection(url)) {
            String callableSQL = "{call upper(?)}";
            CallableStatement callableStatement = connection.prepareCall(callableSQL);
            callableStatement.setString(1, "lowercase to uppercase");
            callableStatement.registerOutParameter(1, java.sql.Types.VARCHAR);

            callableStatement.execute();

            String s = callableStatement.getString(1);
            System.out.println("CallableStatement example");
            System.out.println(s);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
