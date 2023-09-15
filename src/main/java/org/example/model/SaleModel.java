package org.example.model;
public class SaleModel {
    private int amount;
    private double total;
    private int id_seller;
    private int id_client;
    private int id_product;
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public int getId_seller() {
        return id_seller;
    }
    public void setId_seller(int id_seller) {
        this.id_seller = id_seller;
    }
    public int getId_client() {
        return id_client;
    }
    public void setId_client(int id_client) {
        this.id_client = id_client;
    }
    public int getId_product() {
        return id_product;
    }
    public void setId_product(int id_product) {
        this.id_product = id_product;
    }
}