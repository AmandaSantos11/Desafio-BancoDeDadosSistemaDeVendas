package org.example.controller;
import org.example.model.ClientModel;
import org.example.repository.ClientRepository;
public class ClientController {
    static ClientRepository clientRepository = new ClientRepository();
    static ClientModel clientModel = new ClientModel();
    public boolean deleteClient(String cpf) {
        clientModel.setCpf(cpf);
        return clientRepository.deleteClient(clientModel.getCpf());
    }
    public boolean registerClient(String name, String email, String cpf, String address) {
        clientModel.setName(name);
        clientModel.setEmail(email);
        clientModel.setCpf(cpf);
        clientModel.setAddress(address);

        return clientRepository.registerClient(
                clientModel.getName(),
                clientModel.getEmail(),
                clientModel.getCpf(),
                clientModel.getAddress());
    }
    public boolean clientShopping(String cpf) {
        clientModel.setCpf(cpf);
        return clientRepository.clientShopping(clientModel.getCpf());
    }
}