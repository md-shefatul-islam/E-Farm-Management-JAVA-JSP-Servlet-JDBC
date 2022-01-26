package com.example.database;

import com.example.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDb {

    Db dbc = new Db();
    Order crop = new Order();

    private static final String CREATE_ORDER_CROP = "INSERT INTO farmtech.order (name, quantity, price, date, suname, buname, status, type) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String SELECT_ORDER = "select * from farmtech.order where date = ?;";
    private static final String SELECT_ALL_ORDER = "select * from farmtech.order;";
    private static final String DELETE_ORDER = "delete from farmtech.order where date = ?;";
    private static final String DELETE_ORDER_SQL = "delete from farmtech.order where id = ?;";
    private static final String UPDATE_ORDER = "update farmtech.order set status = ? where id = ?;";
    private static final String UPDATE_ORDER_QUANTITY = "update farmtech.order set quantity = ? where date = ?;";
    private static final String UPDATE_PASSWORD_SQL = "update farmtech.farmer set password = ? where uname = ?;";
    private static final String SEARCH_USER = "select * from farmtech.farmer where name LIKE ? ESCAPE '!' or email LIKE ? ESCAPE '!' or phone LIKE ? ESCAPE '!' or city LIKE ? ESCAPE '!' or gender LIKE ? ESCAPE '!' or dob LIKE ? ESCAPE '!'";

    public boolean insert(Order crop) {

        try (Connection connection = dbc.getConnection();
             PreparedStatement ps = connection.prepareStatement(CREATE_ORDER_CROP)) {
            ps.setString(1, crop.getName());
            ps.setString(2, crop.getQuantity());
            ps.setString(3, crop.getPrice());
            ps.setString(4, crop.getDate());
            ps.setString(5, crop.getSuname());
            ps.setString(6, crop.getBuname());
            ps.setString(7, crop.getStatus());
            ps.setString(8, crop.getType());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteOrder(String date)  {
        //boolean rowDeleted;
        try (Connection connection = dbc.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ORDER)) {
            //statement.setInt(1, id);
            statement.setString(1, date);
            //rowDeleted = statement.executeUpdate() > 0;
            int count = statement.executeUpdate();
            if (count > 0) {
                return true;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteorder(int id)  {
        //boolean rowDeleted;
        try (Connection connection = dbc.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ORDER_SQL)) {
            //statement.setInt(1, id);
            statement.setInt(1, id);
            //rowDeleted = statement.executeUpdate() > 0;
            int count = statement.executeUpdate();
            if (count > 0) {
                return true;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public Order selectOrder(String dates) {
        Order order = null;

        try (Connection connection = dbc.getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER)) {
            preparedStatement.setString(1, dates);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");;
                String quantity = rs.getString("quantity");
                String price = rs.getString("price");
                String date = rs.getString("date");
                String suname = rs.getString("suname");
                String buname = rs.getString("buname");
                String status = rs.getString("status");
                String type = rs.getString("type");

                order = new Order(id,name,quantity,price,date,suname,buname,status,type) ;

                //return person;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    public boolean acceptorder(Order order) {
        //boolean rowUpdated = false;
        try (Connection connection = dbc.getConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE_ORDER)) {

            ps.setString(1, order.getStatus());
            ps.setInt(2, order.getId());

            int count = ps.executeUpdate();

            //rowUpdated = statement.executeUpdate(UPDATE_PERSON_SQL)>0;
            //rowUpdated = true;
            if (count > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Order> allorder() {

        List<Order> order = new ArrayList<>();
        //Student student = null;

        try (Connection connection = dbc.getConnection();

             PreparedStatement ps = connection.prepareStatement(SELECT_ALL_ORDER)) {
//            ps.setString(1, uname);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String quantity = rs.getString("quantity");
                    String price = rs.getString("price");
                    String date = rs.getString("date");
                    String suname = rs.getString("suname");
                    String buname = rs.getString("buname");
                    String status = rs.getString("status");
                    String type= rs.getString("type");

                    order.add(new Order(id,name,quantity,price,date,suname,buname,status,type));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return order;
    }

    public boolean updateorder( Order order) {
        //boolean rowUpdated = false;
        try (Connection connection = dbc.getConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE_ORDER_QUANTITY)) {


            ps.setString(1, order.getQuantity());
            ps.setString(2, order.getDate());

            int count = ps.executeUpdate();

            //rowUpdated = statement.executeUpdate(UPDATE_PERSON_SQL)>0;
            //rowUpdated = true;
            if (count > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
