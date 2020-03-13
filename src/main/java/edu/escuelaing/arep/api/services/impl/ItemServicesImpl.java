package edu.escuelaing.arep.api.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.escuelaing.arep.api.model.Item;
import edu.escuelaing.arep.api.persistence.database.ItemPersistence;
import edu.escuelaing.arep.api.persistence.exception.ItemException;
import edu.escuelaing.arep.api.services.ItemServices;

@Service
public class ItemServicesImpl implements ItemServices {

    // @Autowired
    // private ItemPersistence itemPersistence;

    @Override
    public void addItem(Item item) throws ItemException {
        // itemPersistence.addItem(item);
    }

    @Override
    public ArrayList<Item> getItems() throws ItemException {
        // return itemPersistence.getItems();
        return null;
    }

    @Override
    public Item getItem(int id) throws ItemException {
        // return itemPersistence.getItem(id);
        return null;
    }

}