package edu.escuelaing.arep.api.persistence.database;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import edu.escuelaing.arep.api.model.Item;
import edu.escuelaing.arep.api.persistence.exception.ItemException;

@Repository
public interface ItemPersistence {

    void addItem(Item item) throws ItemException, SQLException;

    ArrayList<Item> getItems() throws ItemException;

    Item getItem(int id) throws ItemException;

}