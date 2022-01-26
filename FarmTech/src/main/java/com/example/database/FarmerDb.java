package com.example.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;


import com.example.model.*;


public class FarmerDb {

    Db dbc = new Db();
//    Farmer user = new Farmer();

    private static final String CREATE_USER_SQL = "INSERT INTO farmtech.farmer (uname, name, email, phone,city,password, gender, dob, balance) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String FARMER_BY_ID = "select * from farmtech.farmer where uname = ?";
    private static final String CHECK = "select * from farmtech.farmer where uname = ? and dob = ?";
    private static final String SELECT_ALL_USER = "select * from farmtech.farmer";
    private static final String DELETE_MY_ACCOUNT = "delete from farmtech.farmer where uname = ?;";
    private static final String UPDATE_FARMER_SQL = "update farmtech.farmer set name = ?, email = ?, phone = ?, city= ?, password = ?, gender= ?, dob = ? where uname = ?;";
    private static final String UPDATE_PASSWORD_SQL = "update farmtech.farmer set password = ? where uname = ?;";
    private static final String SEARCH_USER = "select * from farmtech.farmer where name LIKE ? ESCAPE '!' or email LIKE ? ESCAPE '!' or phone LIKE ? ESCAPE '!' or city LIKE ? ESCAPE '!' or gender LIKE ? ESCAPE '!' or dob LIKE ? ESCAPE '!' or balance LIKE ? ESCAPE '!'";

    public FarmerDb() {
    }

    public boolean insert(Farmer users) {
        System.out.println(CREATE_USER_SQL);

        try (Connection connection = dbc.getConnection();
             PreparedStatement ps = connection.prepareStatement(CREATE_USER_SQL)) {
            ps.setString(1, users.getUname());
            ps.setString(2, users.getName());
            ps.setString(3, users.getEmail());
            ps.setString(4, users.getPhone());
            ps.setString(5, users.getCity());
            ps.setString(6, users.getPassword());
            ps.setString(7, users.getGender());
            ps.setString(8, users.getDob());
            ps.setString(9, users.getBalance());

//            System.out.println(preparedStatement);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Farmer profile(String username) {
        Farmer user = null;

        try (Connection connection = dbc.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FARMER_BY_ID)) {
            preparedStatement.setString(1, username);

            ResultSet rs = preparedStatement.executeQuery();


            if (rs.next()) {
                int id = rs.getInt("id");
                String uname = rs.getString("uname");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String city = rs.getString("city");
                String password = rs.getString("password");
                String gender = rs.getString("gender");
                String dob = rs.getString("dob");
                String balance = rs.getString("balance");
                user = new Farmer(id, uname, name, email, phone, city, password, gender, dob,balance);

                //return person;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    public boolean updateProfile(Farmer user)  {
        //boolean rowUpdated = false;
        try (Connection connection = dbc.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_FARMER_SQL)) {
            //statement.setInt(1, person.getId());

            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPhone());
            statement.setString(4, user.getCity());
            statement.setString(5, user.getPassword());
            statement.setString(6, user.getGender());
            statement.setString(7, user.getDob());
            statement.setString(8, user.getUname());

            int count = statement.executeUpdate();

            if (count > 0) {
                return true;
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updatePasswordFarmer(Farmer user)  {

        try (Connection connection = dbc.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PASSWORD_SQL)) {

            statement.setString(1, user.getPassword());
            statement.setString(2, user.getUname());


            int count = statement.executeUpdate();

            if (count > 0) {
                return true;
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deletemyaccount(String uname)  {

        try (Connection connection = dbc.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_MY_ACCOUNT)) {

            statement.setString(1, uname);


            int count = statement.executeUpdate();

            if (count > 0) {
                return true;
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Farmer> alluser() {

        List<Farmer> user = new ArrayList<>();
        //Student student = null;

        try (Connection connection = dbc.getConnection();


             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER)) {

            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String uname = rs.getString("uname");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String phone = rs.getString("phone");
                    String city = rs.getString("city");
                    String password = rs.getString("password");
                    String gender = rs.getString("gender");
                    String dob = rs.getString("dob");
                    String balance = rs.getString("balance");

                    user.add(new Farmer(id,uname,name,email,phone,city,password,gender,dob,balance)) ;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return user;
    }

    public List<Farmer> searchuser(String search) {
//    public List<Farmer> searchuser(String search, String username) {

        List<Farmer> user = new ArrayList<>();

        try (Connection connection = dbc.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_USER)) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1, "%" + search + "%");
            preparedStatement.setString(2, "%" + search + "%");
            preparedStatement.setString(3, "%" + search + "%");
            preparedStatement.setString(4, "%" + search + "%");
            preparedStatement.setString(5, "%" + search + "%");
            preparedStatement.setString(6, "%" + search + "%");
            preparedStatement.setString(7, "%" + search + "%");
//            preparedStatement.setString(7, "%" + search + "%");
//            preparedStatement.setString(8, username);
            //preparedStatement.setString(2, todaydate);
            //System.out.println(preparedStatement);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String uname = rs.getString("uname");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String phone = rs.getString("phone");
                    String city = rs.getString("city");
                    String password = rs.getString("password");
                    String gender = rs.getString("gender");
                    String dob = rs.getString("dob");
                    String balance = rs.getString("balance");

                    user.add(new Farmer(id,uname,name,email,phone,city,password,gender,dob,balance)) ;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return user;
    }

    public Farmer check(String unames, String dobs) {
        Farmer users = null;

        try (Connection connection = dbc.getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(CHECK)) {
            preparedStatement.setString(1, unames);
            preparedStatement.setString(2, dobs);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();


            if (rs.next()) {
                int id = rs.getInt("id");
                String uname = rs.getString("uname");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String city = rs.getString("city");
                String password = rs.getString("password");
                String gender = rs.getString("gender");
                String dob = rs.getString("dob");
                String balance = rs.getString("balance");
                users = new Farmer(id, uname, name, email, phone, city, password, gender, dob,balance);

                //return person;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
