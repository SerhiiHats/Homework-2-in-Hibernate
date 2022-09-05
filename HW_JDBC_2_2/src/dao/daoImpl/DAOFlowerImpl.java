package dao.daoImpl;

import dao.DAOFlower;
import db.DBConnect;
import models.Flower;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOFlowerImpl implements DAOFlower {

    public DAOFlowerImpl() {
    }

    @Override
    public boolean add(Flower flower) {
        Connection connection = DBConnect.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO flower (name_fl, color_fl, date_add_fl, time_storage_fl, length_fl, price) " +
                "VALUES (?, ?, NOW(), ?, ?, ?)")) {
            ps.setString(1, flower.getName());
            ps.setString(2, flower.getColorFlower());
            ps.setInt(3, flower.getTimeStorageHour());
            ps.setInt(4, flower.getLengthFlower());
            ps.setDouble(5, flower.getPrice());
            int result = ps.executeUpdate();
            if (result == 1) {
                return true;
            } else {
                return false;
            }

        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Flower> getAll() {
        Connection connection = DBConnect.getConnection();
        List<Flower> flowerList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM flower")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Flower flower = new Flower();
                flower.setId(rs.getInt(1));
                flower.setName(rs.getString(2));
                flower.setColorFlower(rs.getString(3));
                flower.setDateOfAdd(rs.getDate(4));
                flower.setTimeStorageHour(rs.getInt(5));
                flower.setLengthFlower((rs.getInt(6)));
                flower.setPrice(rs.getDouble(7));
                flowerList.add(flower);
            }
            return flowerList;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flowerList;
    }

    @Override
    public Flower get(long idFlower) {
        Connection connection = DBConnect.getConnection();
        Flower flower = new Flower();
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM flower WHERE id = ?")) {
            ps.setLong(1, idFlower);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                flower.setId(rs.getInt(1));
                flower.setName(rs.getString(2));
                flower.setColorFlower(rs.getString(3));
                flower.setDateOfAdd(rs.getDate(4));
                flower.setTimeStorageHour(rs.getInt(5));
                flower.setLengthFlower((rs.getInt(6)));
                flower.setPrice(rs.getDouble(7));
            }
            return flower;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flower;
    }

    @Override
    public boolean updatePriceById(double newPrice, int idFlower) {
        Connection connection = DBConnect.getConnection();

        try (PreparedStatement ps = connection.prepareStatement("UPDATE flower SET price = ? WHERE id = ?")) {
            ps.setDouble(1, newPrice);
            ps.setInt(2, idFlower);
            int result = ps.executeUpdate();
            if (result == 1) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    @Override
    public boolean removeById(int idFlower) {
        Connection connection = DBConnect.getConnection();

        try (PreparedStatement ps = connection.prepareStatement("DELETE FROM flower WHERE id = ?")) {
            ps.setInt(1, idFlower);
            int result = ps.executeUpdate();
            if (result == 1) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
