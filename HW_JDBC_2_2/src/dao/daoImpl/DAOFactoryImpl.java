package dao.daoImpl;

import dao.DAOAccesories;
import dao.DAOFactory;
import dao.DAOFlower;
import dao.DAOBuket;

public class DAOFactoryImpl implements DAOFactory {

    private static DAOFactory factory;

    private DAOFactoryImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
           // System.out.println("Driver loading complete!");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static synchronized DAOFactory getInstace() {
        if (factory == null) {
            factory = new DAOFactoryImpl();
        }
        return factory;
    }

    public DAOBuket getDAOBuket() {
        return new DAOBuketImpl();
    }

    @Override
    public DAOAccesories getDAOAccesories() {
        return new DAOAccesoriesImpl();
    }

    @Override
    public DAOFlower getDAOFlower() {
        return new DAOFlowerImpl();
    }
}
