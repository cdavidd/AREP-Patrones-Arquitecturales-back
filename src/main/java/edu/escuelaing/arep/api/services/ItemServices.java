package edu.escuelaing.arep.api.services;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import edu.escuelaing.arep.api.model.Item;
import edu.escuelaing.arep.api.persistence.exception.ItemException;

@Service
public interface ItemServices {

    void addItem(Item item) throws ItemException, SQLException;

    ArrayList<Item> getItems() throws ItemException;

    Item getItem(int id) throws ItemException;

}