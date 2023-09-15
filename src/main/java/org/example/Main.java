package org.example;
import org.example.controller.SaleController;
import org.example.view.MainMenuView;
public class Main {
    public static void main(String[] args) {
        MainMenuView mainMenuView = new MainMenuView();
        SaleController saleController = new SaleController();

        saleController.changeTheTotalValueOfSalesThatAreNullToZero();
        mainMenuView.mainMenu();
    }
}