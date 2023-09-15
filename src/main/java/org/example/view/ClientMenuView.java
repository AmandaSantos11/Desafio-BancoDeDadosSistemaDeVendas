package org.example.view;
import org.example.controller.ClientController;
import org.example.service.ClientService;
import org.example.service.ValidationService;
import java.util.Scanner;
public class ClientMenuView {
    static Scanner scanner = new Scanner(System.in);
    static ClientController clientController = new ClientController();
    static ClientService clientService = new ClientService();
    static MainMenuView mainMenuView = new MainMenuView();
    static ValidationService validationService = new ValidationService();
    private String cpf;
    public void loginClient(){
        boolean loop=false;
        System.out.println("== Login cliente ==");
        do {
            System.out.println("Digite seu email:");
            String email = scanner.nextLine();
            System.out.println("Digite seu cpf:");
            cpf = scanner.nextLine();
            if (clientService.validateLogin(email,cpf)){
                clientMenu();
                loop=true;
            }else{
                System.out.println("Email ou CPF inválido, digite novamente:");
            }
        }while (!loop);
    }
    private void clientMenu(){
        displayClientShopping();
        int choice;
        do {
            optionsMenu();
            System.out.print("Digite sua escolha: ");
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Obrigado(a) por utilizar nosso sistema!");
                    System.exit(0);

                case 2:
                    mainMenuView.mainMenu();
                    break;

                case 3:
                    System.out.println("Digite o CPF para deletar conta:");
                    String cpf = scanner.next();
                    if (validationService.validateCpf(cpf)){
                        clientController.deleteClient(cpf);
                        System.out.println("Conta deletada!");
                        mainMenuView.mainMenu();
                    }else {
                        System.out.println("Cpf inválido");
                    }
                    break;

                default:
                    System.out.println("Opção inválida, digite novamente");
            }
        }while (choice!=1);
    }
    private void optionsMenu(){
        System.out.println("Você deseja:");
        System.out.println("1-Sair | 2-Voltar ao menu principal | 3-Deletar conta");
    }
    private void displayClientShopping(){
        System.out.println("=== Suas compras ===");
        clientController.clientShopping(cpf);
    }
}