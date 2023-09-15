package org.example.view;
import org.example.controller.SaleController;
import org.example.controller.SellerController;
import org.example.service.SellerService;
import java.util.Scanner;
public class SellerMenuView {
    static Scanner scanner = new Scanner(System.in);
    static SellerController sellerController = new SellerController();
    static SellerService sellerService = new SellerService();
    static SaleController saleController = new SaleController();
    static RegisterMenuView registerMenuView = new RegisterMenuView();
    static MainMenuView mainMenuView = new MainMenuView();
    public void loginSeller(){
        boolean loop=false;
        System.out.println("== Login funcionário ==");
        do {
            System.out.println("Digite seu email:");
            String email = scanner.nextLine();
            System.out.println("Digite seu cpf:");
            String cpf = scanner.nextLine();
            if (sellerService.validateLogin(email,cpf)){
                menuSeller();
                loop=true;
            }else{
                System.out.println("Email ou CPF inválido, digite novamente:");
            }
        }while (!loop);
    }
    public void menuSeller(){
        int choice;
        do {
            optionsMenu();
            System.out.print("\nDigite sua escolha: ");
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    warningMenu();
                    registerMenuView.registerProduct();
                    break;

                case 2:
                    System.out.println("== Vendedores ==");
                    sellerController.showSellerInformation();
                    break;

                case 3:
                    System.out.println("== Usuários com email ZUP ==");
                    sellerController.showEmailsThatContainZup();
                    break;

                case 4:
                    System.out.println("== Produtos ==");
                    saleController.displayAllSalesOverTenReais();
                    break;

                case 5:
                    registerMenuView.registerSale();
                    break;

                case 6:
                    mainMenuView.mainMenu();
                    break;

                case 7:
                    System.out.println("Obrigado(a) por utilizar nosso sistema!");
                    System.exit(0);

                default:
                    System.out.println("Opção inválida, digite novamente");
            }
        }while (choice!=6);
    }
    private void optionsMenu(){
        System.out.println("\nVocê deseja:");
        System.out.println("1-Cadastrar um produto | 2-Ver o salário dos vendedores | 3-Ver usuários com email zup");
        System.out.println("4-Ver produtos que foram vendidos acima de R$10,00");
        System.out.println("5-Registrar uma venda | 6-Voltar ao menu principal | 7-Sair");
    }
    private void warningMenu(){
        System.out.println("== AVISO ==");
        System.out.println("Para registro válido:");
        System.out.println("Nome: deve conter mais que três caracteres e apenas letras");
        System.out.println("Preço: deve ser maior que zero, conter apenas números e ','");
        System.out.println("Para id's: deve ser maior que zero e conter apenas números\n");
    }
}