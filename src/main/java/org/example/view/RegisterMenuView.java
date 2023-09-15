package org.example.view;
import org.example.controller.ClientController;
import org.example.controller.ProductController;
import org.example.controller.SaleController;
import org.example.service.ValidationService;
import java.util.Scanner;
public class RegisterMenuView {
    static Scanner scanner = new Scanner(System.in);
    static ValidationService validationService = new ValidationService();
    static ClientController clientController = new ClientController();
    static ProductController productController = new ProductController();
    static SellerMenuView sellerMenuView = new SellerMenuView();
    static SaleController saleController = new SaleController();
    static MainMenuView mainMenuView = new MainMenuView();
    private String name;
    private String email;
    private String cpf;
    private String address;
    private double price;
    private int amount;
    private double total;
    private int id_seller;
    private int id_client;
    private int id_product;
    public void registerClient(){
        System.out.println("== Registrar ==");
        if (registerName() && registerEmail() && registerCpf() && registerAddress()){
            clientController.registerClient(name,email,cpf,address);
        }
        System.out.println("Você foi cadastrado como cliente com sucesso!");
        mainMenuView.mainMenu();
    }
    public void registerProduct(){
        System.out.println("== Registrar produto ==");
        if (registerName() && registerPrice()){
            productController.registerProduct(name,price);
        }
        System.out.println("Produto cadastrado com sucesso!");
        sellerMenuView.menuSeller();
    }
    public void registerSale(){
        System.out.println("== Registrar venda ==");
        if (registerAmount() && registerTotal() && registerId()){
            saleController.registerSale(amount,total,id_seller,id_client,id_product);
        }
        System.out.println("Venda registrada com sucesso!");
        sellerMenuView.menuSeller();
    }
    private boolean registerName(){
        boolean loop=false;
        System.out.println("Digite o nome:");
        name = scanner.nextLine();
        do {
            if (validationService.validateName(name)){
                loop=true;
            }
            else {
                System.out.println("Nome inválido,digite novamente");
                name = scanner.nextLine();
            }
        }while (!loop);
        return true;
    }
    private boolean registerEmail(){
        boolean loop=false;
        System.out.println("Digite seu email:");
        email = scanner.nextLine();
        do {
            if (validationService.validateEmail(email)){
                loop=true;
            }
            else {
                System.out.println("Email inválido,digite novamente");
                email = scanner.nextLine();
            }
        }while (!loop);
        return true;
    }
    private boolean registerCpf(){
        boolean loop=false;
        System.out.println("Digite seu cpf:");
        cpf = scanner.nextLine();
        do {
            if (validationService.validateCpf(cpf)){
                loop=true;
            }
            else {
                System.out.println("Cpf inválido,digite novamente");
                cpf = scanner.nextLine();
            }
        }while (!loop);
        return true;
    }
    private boolean registerAddress(){
        boolean loop=false;
        System.out.println("Digite seu endereço:");
        address = scanner.nextLine();
        do {
            if (validationService.validateAddress(address)){
                loop=true;
            }
            else {
                System.out.println("Email inválido,digite novamente");
                address = scanner.nextLine();
            }
        }while (!loop);
        return true;
    }
    private boolean registerPrice(){
        boolean loop=false;
        System.out.println("Digite o preço:");
        price = scanner.nextDouble();
        do {
            if (validationService.validatePrice(price)){
                loop=true;
            }
            else {
                System.out.println("Preço inválido,digite novamente");
                price = scanner.nextDouble();
            }
        }while (!loop);
        return true;
    }
    private boolean registerAmount(){
        boolean loop=false;
        System.out.println("Digite a quantidade:");
        amount = scanner.nextInt();
        do {
            if (validationService.validateAmount(amount)){
                loop=true;
            }
            else {
                System.out.println("Quantidade inválida,digite novamente");
                amount = scanner.nextInt();
            }
        }while (!loop);
        return true;
    }
    private boolean registerTotal(){
        boolean loop=false;
        System.out.println("Digite o total:");
        total = scanner.nextDouble();
        do {
            if (validationService.validateTotal(total)){
                loop=true;
            }
            else {
                System.out.println("Total inválido,digite novamente");
                total = scanner.nextDouble();
            }
        }while (!loop);
        return true;
    }
    private boolean registerId(){
        boolean loop=false;
        do {
            System.out.println("Digite o id do vendedor:");
            id_seller = scanner.nextInt();
            if (validationService.validateId(id_seller)){
                loop=true;
            }
            else {
                System.out.println("Id do vendedor inválido,digite novamente");
                id_seller = scanner.nextInt();
            }
        }while (!loop);

        do {
            System.out.println("Digite o id do cliente:");
            id_client = scanner.nextInt();
            if (validationService.validateId(id_client)){
                loop=true;
            }
            else {
                System.out.println("Id do cliente inválido,digite novamente");
                id_client = scanner.nextInt();
            }
        }while (!loop);

        do {
            System.out.println("Digite o id do produto:");
            id_product = scanner.nextInt();
            if (validationService.validateId(id_product)){
                loop=true;
            }
            else {
                System.out.println("Id do produto inválido,digite novamente");
                id_product = scanner.nextInt();
            }
        }while (!loop);

        return true;
    }
}