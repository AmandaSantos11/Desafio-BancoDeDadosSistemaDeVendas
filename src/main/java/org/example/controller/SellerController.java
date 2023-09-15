package org.example.controller;
import org.example.repository.SellerRepository;
public class SellerController {
    static SellerRepository sellerRepository = new SellerRepository();
    public boolean showSellerInformation(){
        return sellerRepository.showSellerInformation();
    }
    public boolean showEmailsThatContainZup(){
        return sellerRepository.showEmailsThatContainZup();
    }
}