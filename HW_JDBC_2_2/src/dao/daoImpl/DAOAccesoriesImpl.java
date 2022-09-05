package dao.daoImpl;

import dao.DAOAccesories;
import db.DBConnect;
import models.Accessories;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOAccesoriesImpl implements DAOAccesories {

    public DAOAccesoriesImpl() {
    }

    public boolean add(Accessories accessories) {
        Connection connection = DBConnect.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO accessories (name_ac, description_ac, date_add_ac, time_storage_ac, price) " +
                "VALUES (?, ?, NOW(), ?, ?)")) {
            ps.setString(1, accessories.getName());
            ps.setString(2, accessories.getDiscription());
            ps.setInt(3, accessories.getTimeStorageHour());
            ps.setDouble(4, accessories.getPrice());
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

    public List<Accessories> getAll() {
        Connection connection = DBConnect.getConnection();
        List<Accessories> accessoriesList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM accessories")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Accessories accessories = new Accessories();
                accessories.setId(rs.getInt(1));
                accessories.setName(rs.getString(2));
                accessories.setDiscription(rs.getString(3));
                accessories.setDateOfAdd(rs.getDate(4));
                accessories.setTimeStorageHour(rs.getInt(5));
                accessories.setPrice(rs.getDouble(6));
                accessoriesList.add(accessories);
            }
            return accessoriesList;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return accessoriesList;
    }

    public Accessories get(int idAcces) {
        Connection connection = DBConnect.getConnection();
        Accessories accessories = new Accessories();
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM accessories WHERE id = ?")) {
            ps.setInt(1, idAcces);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                accessories.setId(rs.getLong(1));
                accessories.setName(rs.getString(2));
                accessories.setDiscription(rs.getString(3));
                accessories.setDateOfAdd(rs.getDate(4));
                accessories.setTimeStorageHour(rs.getInt(5));
                accessories.setPrice(rs.getDouble(6));
            }
            return accessories;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return accessories;
    }

    public boolean updatePriceById(double newPrice, int idAcces) {
        Connection connection = DBConnect.getConnection();

        try (PreparedStatement ps = connection.prepareStatement("UPDATE accessories SET price = ? WHERE id = ?")) {
            ps.setDouble(1, newPrice);
            ps.setInt(2, idAcces);
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

    public boolean removeById(int idAcces) {
        Connection connection = DBConnect.getConnection();

        try (PreparedStatement ps = connection.prepareStatement("DELETE FROM accessories WHERE id = ?")) {
            ps.setInt(1, idAcces);
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

