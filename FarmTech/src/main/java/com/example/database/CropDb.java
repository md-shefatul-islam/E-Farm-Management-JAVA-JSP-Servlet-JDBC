package com.example.database;

import com.example.model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CropDb {
    Db dbc = new Db();
    Crop user = new Crop();

    private static final String CREATE_CROP_SQL = "INSERT INTO farmtech.crop (name, description, quantity, price, date, funame) VALUES (?, ?, ?, ?, ?, ?);";

    private static final String SELECT_CROP_BY_ID = "select * from farmtech.crop where id = ?;";
    private static final String SELECT_CROP_BY_NAME = "select * from farmtech.crop where funame = ?;";
    private static final String SELECT_ALL_CROP = "select * from farmtech.crop;";
    private static final String DELETE_CROP_SQL = "delete from farmtech.crop where id = ?;";
    private static final String UPDATE_CROP_SQL = "update farmtech.crop set name = ?, description = ?, quantity = ?, price= ?, date = ? where id = ?;";
    private static final String UPDATE_CROP_QUANTITY = "update farmtech.crop set quantity = ? where id = ?;";
    private static final String UPDATE_PASSWORD_SQL = "update farmtech.farmer set password = ? where uname = ?;";
    private static final String SEARCH_USER = "select * from farmtech.farmer where name LIKE ? ESCAPE '!' or email LIKE ? ESCAPE '!' or phone LIKE ? ESCAPE '!' or city LIKE ? ESCAPE '!' or gender LIKE ? ESCAPE '!' or dob LIKE ? ESCAPE '!'";

    public boolean insert(Crop crop) {

        try (Connection connection = dbc.getConnection();
             PreparedStatement ps = connection.prepareStatement(CREATE_CROP_SQL)) {
            ps.setString(1, crop.getName());
            ps.setString(2, crop.getDescription());
            ps.setString(3, crop.getQuantity());
            ps.setString(4, crop.getPrice());
            ps.setString(5, crop.getDate());
            ps.setString(6, crop.getFuname());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Crop> allcrop() {

        List<Crop> crop = new ArrayList<>();
        //Student student = null;

        try (Connection connection = dbc.getConnection();

             PreparedStatement ps = connection.prepareStatement(SELECT_ALL_CROP)) {
//            ps.setString(1, uname);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    String quantity = rs.getString("quantity");
                    String price = rs.getString("price");
                    String date = rs.getString("date");
                    String funame = rs.getString("funame");

                    crop.add(new Crop(id,name,description,quantity,price,date,funame)) ;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return crop;
    }

    public Crop selectCrop(int cid) {
        Crop crop = null;

        try (Connection connection = dbc.getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CROP_BY_ID)) {
            preparedStatement.setInt(1, cid);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String quantity = rs.getString("quantity");
                String price = rs.getString("price");
                String date = rs.getString("date");
                String funame = rs.getString("funame");

                crop = new Crop(id,name,description,quantity,price,date,funame) ;

                //return person;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return crop;
    }

    public Crop selectcrop(String names) {
        Crop crop = null;

        try (Connection connection = dbc.getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CROP_BY_NAME)) {
            preparedStatement.setString(1, names);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String quantity = rs.getString("quantity");
                String price = rs.getString("price");
                String date = rs.getString("date");
                String funame = rs.getString("funame");

                crop = new Crop(id,name,description,quantity,price,date,funame) ;

                //return person;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return crop;
    }

    public boolean updatecrop( Crop crop, int id) {
        //boolean rowUpdated = false;
        try (Connection connection = dbc.getConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE_CROP_SQL)) {

            ps.setString(1, crop.getName());
            ps.setString(2, crop.getDescription());
            ps.setString(3, crop.getQuantity());
            ps.setString(4, crop.getPrice());
            ps.setString(5, crop.getDate());
            ps.setInt(6, id);

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

    public boolean updatequantity( Crop crop) {
        //boolean rowUpdated = false;
        try (Connection connection = dbc.getConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE_CROP_QUANTITY)) {


            ps.setString(1, crop.getQuantity());
            ps.setInt(2, crop.getId());

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



    public boolean deleteCrop(int id)  {
        //boolean rowDeleted;
        try (Connection connection = dbc.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CROP_SQL)) {
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
}
