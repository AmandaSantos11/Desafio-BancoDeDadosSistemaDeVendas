package org.example.service;
public class ValidationService {
    public boolean validateCpf(String cpf){
        if(cpf.isBlank() || !(cpf.matches("\\d+")) || cpf.length() != 11){
            return false;
        }
        return true;
    }
    public boolean validateEmail(String email){
        if(email.isBlank() || !(email.indexOf("@") > 0) || email.length() <= 3 || !(email.indexOf(".com") > 0)){
            return false;
        }
        return true;
    }
    public boolean validateName(String name){
        if(name.isBlank() || name.matches(".*\\d.*") || name.length() <= 3 ){
            return false;
        }
        return true;
    }
    public boolean validateAddress(String address){
        return address.matches("^[0-9a-zA-Z\\s,^~´]*$");
    }
    public boolean validatePrice(double price){
        return price>0;
    }
    public boolean validateAmount(int amount){
        return amount>0;
    }
    public boolean validateTotal(double total){
        return total>0;
    }
    public boolean validateId(int id){
        return id>0;
    }
}