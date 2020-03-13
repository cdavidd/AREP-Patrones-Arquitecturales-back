package edu.escuelaing.arep.api.persistence.database.impl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import edu.escuelaing.arep.api.model.Item;
import edu.escuelaing.arep.api.persistence.database.ItemPersistence;
import edu.escuelaing.arep.api.persistence.exception.ItemException;

@Repository
public class ItemPersistenceImpl implements ItemPersistence {

    private static String urlDB = "jdbc:postgresql://database-2.c5szfzxzsbcy.us-east-1.rds.amazonaws.com:5432/arepDataBase";
    private static String usuarioDB = "david";
    private static String passwordDB = "123456789c";
    private static Connection connection = null;

    public ItemPersistenceImpl() {
        coneccion();
        createTableItem();
    }

    public void coneccion() {
        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(urlDB, usuarioDB, passwordDB);
            System.out.println("La conexion se realizo sin problemas!");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al registrar el driver de PostgreSQL: " + e);
        } catch (SQLException e) {
            System.out.println("Error al conectar a PostgreSQL: " + e);
            // e.printStackTrace();
        }
    }

    public void createTableItem() {
        Statement stmt = null;
        DatabaseMetaData dbm = null;
        try {
            dbm = connection.getMetaData();
            ResultSet tables = dbm.getTables(null, null, "item", null);
            boolean existe = tables.next();
            if (!existe) {
                stmt = connection.createStatement();
                String sql = "CREATE TABLE ITEM " + "(id INTEGER not NULL, " + " name VARCHAR(40), "
                        + " cantidad INTEGER, " + " PRIMARY KEY ( id ))";

                stmt.executeUpdate(sql);
                stmt.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla en PostgreSQL: " + e);
            // e.printStackTrace();
        }
    }

    @Override
    public void addItem(Item item) throws ItemException {
        try {
            Statement stmt = connection.createStatement();
            String insertItem = "INSERT INTO ITEM (id,name,cantidad) VALUES (" + item.getId() + "," + item.getName()
                    + "," + item.getCantidad() + ")";
            stmt.executeUpdate(insertItem);
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public ArrayList<Item> getItems() throws ItemException {
        Statement stmt = null;
        ArrayList<Item> items = new ArrayList<>();
        try {
            stmt = connection.createStatement();
            String sqlSelect = "SELECT * FROM ITEM";
            ResultSet rs = stmt.executeQuery(sqlSelect);
            Item temp;
            while (rs.next()) {
                temp = new Item(rs.getInt("id"), rs.getString("name"), rs.getInt("cantidad"));
                items.add(temp);
            }
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return items;
    }

    @Override
    public Item getItem(int id) throws ItemException {
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sqlSelect = "SELECT * FROM ITEM WHERE id=" + id;
            ResultSet rs = stmt.executeQuery(sqlSelect);
            Item temp;
            while (rs.next()) {
                temp = new Item(rs.getInt("id"), rs.getString("name"), rs.getInt("cantidad"));
                return temp;
            }
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}