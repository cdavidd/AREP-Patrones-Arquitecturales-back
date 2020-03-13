package edu.escuelaing.arep.api.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.escuelaing.arep.api.model.Item;
import edu.escuelaing.arep.api.persistence.exception.ItemException;
import edu.escuelaing.arep.api.services.ItemServices;

@RestController
@RequestMapping("/items")
public class ItemApiController {

    @Autowired
    private ItemServices itemServices;

    @PostMapping
    public ResponseEntity<?> createItem(@RequestBody Item item) {
        try {
            itemServices.addItem(item);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (ItemException e) {
            // e.printStackTrace();
            return new ResponseEntity<>("ERROR 403", HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping
    public ResponseEntity<?> getItems() {
        try {
            ArrayList<Item> items = new ArrayList<>();
            items = itemServices.getItems();
            return new ResponseEntity<>(items, HttpStatus.CREATED);
        } catch (ItemException e) {
            // e.printStackTrace();
            return new ResponseEntity<>("ERROR 403", HttpStatus.FORBIDDEN);

        }
    }

}