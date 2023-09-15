package org.example.controller;
import org.example.model.SaleModel;
import org.example.repository.SaleRepository;
public class SaleController {
    static SaleRepository saleRepository = new SaleRepository();
    static SaleModel saleModel = new SaleModel();
    public boolean displayAllSalesOverTenReais(){
        return saleRepository.displayAllSalesOverTenReais();
    }
    public boolean changeTheTotalValueOfSalesThatAreNullToZero(){
        return saleRepository.changeTheTotalValueOfSalesThatAreNullToZero();
    }
    public boolean registerSale(int amount,double total,int id_seller,int id_client,int id_product){
        saleModel.setAmount(amount);
        saleModel.setTotal(total);
        saleModel.setId_seller(id_seller);
        saleModel.setId_client(id_client);
        saleModel.setId_product(id_product);

        return saleRepository.registerSale(
                saleModel.getAmount(),
                saleModel.getTotal(),
                saleModel.getId_seller(),
                saleModel.getId_client(),
                saleModel.getId_product());
    }
}