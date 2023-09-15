package org.example.view;
import java.util.Scanner;
public class MainMenuView {
    static Scanner scanner = new Scanner(System.in);
    static ClientMenuView clientMenuView = new ClientMenuView();
    static SellerMenuView sellerMenuView = new SellerMenuView();
    static RegisterMenuView registerMenuView = new RegisterMenuView();
    public void mainMenu(){
        mainMenuOptions();
        int choice;
        do {
            System.out.print("Digite sua escolha: ");
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    clientMenuView.loginClient();
                    break;

                case 2:
                    sellerMenuView.loginSeller();
                    break;

                case 3:
                    warningMenu();
                    registerMenuView.registerClient();
                    break;

                case 4:
                    System.out.println("Obrigado(a) por utilizar nosso sistema!");
                    System.exit(0);

                default:
                    System.out.println("Opção inválida, digite novamente");
            }
        }while (choice!=4);
    }
    private void mainMenuOptions(){
        System.out.println("==== BEM-VINDO ====");
        System.out.println("1-Cliente | 2-Funcionário | 3-Se registrar como cliente | 4-Sair\n");
    }
    private void warningMenu(){
        System.out.println("== AVISO ==");
        System.out.println("Para registro válido:");
        System.out.println("Nome: deve conter mais que três caracteres e apenas letras");
        System.out.println("Email: deve conter mais que três caracteres, ter o '@' e '.com'");
        System.out.println("CPF: deve conter apenas números e 11 dígitos");
        System.out.println("Endereço: não pode conter pontuação\n");
    }
}