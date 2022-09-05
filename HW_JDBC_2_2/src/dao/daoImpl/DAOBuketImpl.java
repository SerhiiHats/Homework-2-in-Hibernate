package dao.daoImpl;

import dao.DAOBuket;
import db.DBConnect;
import models.Buket;
import models.Flower;
import models.Tovar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOBuketImpl implements DAOBuket {
    @Override
    public boolean add(Tovar tovar) {
        Connection connection = DBConnect.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO buket_deteils (id_buk, tovor_group, id)" +
                "VALUES (1, ?, ?)")) {
            ps.setString(1, tovar.getClass().getSimpleName());
            ps.setLong(2, tovar.getId());
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
    public List<Tovar> getAll() {
        List<Tovar> tovarList = new ArrayList<>();
        Connection connection = DBConnect.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("SELECT id_bd, id_buk, tovor_group, id FROM buket_deteils WHERE id_buk = ?")) {

            ps.setLong(1, 1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nameTable = rs.getString(3);
                try (PreparedStatement psinner = connection.prepareStatement("SELECT * FROM " + nameTable + " WHERE id = ?")) {
                    psinner.setInt(1, rs.getInt(4));
                    ResultSet rsinner = psinner.executeQuery();
                    if (rsinner.next()) {
                        Buket buket = new Buket();
                        buket.setId(rs.getLong(1));
                        buket.setIdBuk(rs.getLong(2));
                        buket.setGroupTovar(rs.getString(3));
                        buket.setIdTovar(rs.getInt(4));
                        buket.setName(rsinner.getString(2));
                        buket.setDescription(rsinner.getString(3));
                        buket.setDateOfAdd(rsinner.getDate(4));
                        buket.setTimeStorageHour(rsinner.getInt(5));
                        buket.setPrice(rsinner.getDouble("price"));
                        tovarList.add(buket);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            return tovarList;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return tovarList;
    }

    @Override
    public Tovar get(int idTovar) {
        Buket buket = new Buket();
        Connection connection = DBConnect.getConnection();
        try(PreparedStatement ps = connection.prepareStatement("SELECT id_bd, id_buk, tovor_group, id FROM buket_deteils WHERE id_bd = ?")) {
            ps.setInt(1, idTovar);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                String nameTable = rs.getString(3);
                try (PreparedStatement psinner = connection.prepareStatement("SELECT * FROM " + nameTable + " WHERE id = ?")) {
                    psinner.setInt(1, rs.getInt(4));
                    ResultSet rsinner = psinner.executeQuery();
                    if (rsinner.next()) {
                        buket.setId(rs.getLong(1));
                        buket.setIdBuk(rs.getLong(2));
                        buket.setGroupTovar(rs.getString(3));
                        buket.setIdTovar(rs.getInt(4));
                        buket.setName(rsinner.getString(2));
                        buket.setDescription(rsinner.getString(3));
                        buket.setDateOfAdd(rsinner.getDate(4));
                        buket.setTimeStorageHour(rsinner.getInt(5));
                        buket.setPrice(rsinner.getDouble("price"));
                        return buket;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buket;
    }

    @Override
    public boolean updatePriceById(double newPrice, int idTovar) {
        Connection connection = DBConnect.getConnection();
        try(PreparedStatement ps = connection.prepareStatement("SELECT id_bd, id_buk, tovor_group, id FROM buket_deteils WHERE id_bd = ?")) {
            ps.setInt(1, idTovar);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                String nameTable = rs.getString(3);
                try (PreparedStatement psinner = connection.prepareStatement("UPDATE " + nameTable + " SET price = ? WHERE id = ?")) {
                    psinner.setDouble(1, newPrice);
                    psinner.setInt(2, rs.getInt(4));
                    int result = psinner.executeUpdate();
                    if (result == 1) {
                        return true;
                    } else {
                        return false;
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeById(int idTovar) {
        Connection connection = DBConnect.getConnection();
        if (idTovar < getAll().size() && idTovar >= 0) {
            try (PreparedStatement ps = connection.prepareStatement("DELETE FROM buket_deteils WHERE id_bd = ?")) {
                ps.setInt(1, idTovar);
                int result = ps.executeUpdate();
                if (result == 1) {
                    return true;
                } else {
                    return false;
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } else {
            return false;
        }
    }
}
