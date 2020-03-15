package edu.escuelaing.arep.api.model;

public class Item {

    private int id;
    private String name;
    private int cantidad;

    public Item() {
    }

    public Item(String name, int cantidad) {
        this.name = name;
        this.cantidad = cantidad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item(int id, String name, int cantidad) {
        this.id = id;
        this.name = name;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Item{cantidad=" + cantidad + ", id=" + id + ", name=" + name + "}";
    }

}