package org.example.service;
import org.example.model.SellerModel;
import org.example.repository.ValidateLoginRepository;
public class SellerService {
    static ValidateLoginRepository validateLoginRepository = new ValidateLoginRepository();
    static SellerModel sellerModel = new SellerModel();
    public boolean validateLogin(String email,String cpf){
        sellerModel.setEmail(email);
        sellerModel.setCpf(cpf);

        return validateLoginRepository.validateLogin(
                sellerModel.getEmail(),
                sellerModel.getCpf());
    }
}