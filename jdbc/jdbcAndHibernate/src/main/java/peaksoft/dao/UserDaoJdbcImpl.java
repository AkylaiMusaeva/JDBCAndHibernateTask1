//package peaksoft.dao;
//
//import peaksoft.model.User;
//import peaksoft.util.Util;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserDaoJdbcImpl implements UserDao {
//
//    public UserDaoJdbcImpl() {
//
//    }
//    public void createUsersTable() {
//        String sql = "" +
//                "create table if not exists users(" +
//                "id serial primary key," +
//                "name varchar not null," +
//                "lastName varchar not null," +
//                "age smallint)";
//        try (Connection connection = Util.getConnection();
//             Statement statement = connection.createStatement()) {
//            statement.executeUpdate(sql);
//            System.out.println("Users table successfully saved!");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//    public void dropUsersTable() {
//        String sql = "drop table if exists users";
//        try (
//                Connection connection = Util.getConnection();
//                Statement statement = connection.createStatement()) {
//            statement.executeUpdate(sql);
//            System.out.println("User's table is dropped successfully!");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//    public void saveUser(String name, String lastName, byte age) {
//        String sql = "" +
//                "insert into users(name,lastName,age)" +
//                "values(?,?,?)";
//        try (Connection connection = Util.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//            preparedStatement.setString(1, name);
//            preparedStatement.setString(2, lastName);
//            preparedStatement.setByte(3, age);
//            preparedStatement.executeUpdate();
//            System.out.printf("Student with name %s is saved", name);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//    public void removeUserById(long id) {
//        String sql = "" +
//                "delete from users where id=?";
//        try (
//                Connection connection = Util.getConnection();
//                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//            preparedStatement.setLong(1,id);
//            preparedStatement.executeUpdate();
//            System.out.println("User with "+id+" is removed!");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//    public List<User> getAllUsers() {
//        List<User> users = new ArrayList<>();
//        String sql = "select * from users";
//        try (
//                Connection connection = Util.getConnection();
//                Statement statement = connection.createStatement()) {
//            ResultSet resultSet = statement.executeQuery(sql);
//            while (resultSet.next()) {
//                users.add(new User(
//                        resultSet.getLong("id"),
//                        resultSet.getString("name"),
//                        resultSet.getString("lastName"),
//                        resultSet.getByte("age")
//                ));
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return users;
//    }
//    public void cleanUsersTable() {
//        String sql = "truncate table users";
//        try (Connection connection = Util.getConnection();
//             Statement statement = connection.createStatement()) {
//            statement.executeUpdate(sql);
//            System.out.println("Table is cleaned now!");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//}
