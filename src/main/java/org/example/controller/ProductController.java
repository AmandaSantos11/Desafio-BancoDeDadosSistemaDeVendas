package org.example.controller;
import org.example.model.ProductModel;
import org.example.repository.ProductRepository;
public class ProductController {
    static ProductRepository productRepository = new ProductRepository();
    static ProductModel productModel = new ProductModel();
    public boolean registerProduct(String name,double price){
        productModel.setName(name);
        productModel.setPrice(price);

        return productRepository.registerProduct(
                productModel.getName(),
                productModel.getPrice());
    }
}