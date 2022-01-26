package com.example.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.*;

public class LoginDb {

    ResultSet rs;
    Db dbc = new Db();
    Login loginUser = new Login();

    private static final String VALID_LOGIN_SQL = "select * from farmtech.login where uname = ? and password = ?;";
    private static final String INSERT = "INSERT INTO farmtech.login (uname, password, type) VALUES (?, ?, ?);";

    private static final String SELECT_PERSON_BY_ID = "select id,name,gender, dob, email from farmtech.person where id =?";
    private static final String SELECT_ALL_USER = "select * from person.login";
    private static final String DELETE_PERSON_SQL = "delete from person.person where id = ?;";
    private static final String DELETE_MY_ACCOUNT = "delete from farmtech.login where uname = ?;";
    private static final String UPDATE_PERSON_SQL = "update person.person set name = ?, gender =?, dob =?, email=? where id = ?;";
    private static final String UPDATE_PASSWORD_SQL = "update farmtech.login set password = ? where uname = ?;";

    public LoginDb() {
    }
    public Login login(Login user) {
//        System.out.println(VALID_LOGIN_SQL);

        try (Connection connection = dbc.getConnection();
             PreparedStatement ps = connection.prepareStatement(VALID_LOGIN_SQL)) {
            ps.setString(1, user.getUname());
            ps.setString(2, user.getPassword());

            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String uname = rs.getString("uname");
                String password = rs.getString("password");
                String type = rs.getString("type");
                loginUser = new Login(id, uname, password, type);

                //return person;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return loginUser;
        }
        return loginUser;
    }

    public boolean updatePasswordLogin(Login user)  {

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

    public boolean insert(Login login) {

        try (Connection connection = dbc.getConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT)) {
            ps.setString(1, login.getUname());
            ps.setString(2, login.getPassword());
            ps.setString(3, login.getType());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Login> alluser() {

        List<Login> user = new ArrayList<>();
        //Student student = null;

        try (Connection connection = dbc.getConnection();


             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER)) {

            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String uname = rs.getString("uname");
                    String password = rs.getString("password");
                    String type = rs.getString("type");


                    user.add(new Login(id,uname,password,type)) ;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return user;
    }

}
