package org.example.service;
import org.example.model.ClientModel;
import org.example.repository.ValidateLoginRepository;
public class ClientService {
    static ClientModel clientModel = new ClientModel();
    static ValidateLoginRepository validateLoginRepository = new ValidateLoginRepository();
    public boolean validateLogin(String email, String cpf) {
        clientModel.setEmail(email);
        clientModel.setCpf(cpf);

        return validateLoginRepository.validateLogin(
                clientModel.getEmail(),
                clientModel.getCpf());
    }
}