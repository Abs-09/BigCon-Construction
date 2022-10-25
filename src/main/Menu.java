package src.main;

import java.util.Scanner;

public class Menu {

    // MAIN MENU
    // ------------------------------------------------------------------------------
    public static void mainMenu() {
        // ----------------------------------------------
        // DISPLAY (Front End)
        System.out.println("--------------------------------");
        System.out.println("MAIN MENU");
        System.out.println("--------------------------------");
        System.out.println("0-Consume Items from Warehouse");
        System.out.println("1-Add Items to Dhoani");
        System.out.println("2-Remove Items from Dhoani");
        System.out.println("3-Swap between Dhoani and Island");

        // ----------------------------------------------
        // OPTIONS (Back end)

        // input
        int selection;
        Scanner scan = new Scanner(System.in);
        selection = scan.nextInt();

        switch (selection) {
            case 0:
                // consumtion menu
                break;
            case 1:
                addToDhoaniMenu();
                break;
            default:
                System.out.println("\nPlease select a valid option from the Menu \n");
                mainMenu();
        }
        scan.close();

    }

    // ------------------------------------------------------------------------------
    // ADD ITEMS TO DHOANI MENU
    public static void addToDhoaniMenu() {
        // ----------------------------------------------
        // DISPLAY (Front End)
        System.out.println("--------------------------------");
        System.out.println("ADD TO DHOANI");
        System.out.println("--------------------------------");
        System.out.println("0-Add Diesel");
        System.out.println("1-Add to Frozen");
        System.out.println("2-Add to Fridge");
        System.out.println("3-Add Food");
        System.out.println("4-Add to Protected Materials");
        System.out.println("5-Add to Unprotected Materials");
        System.out.println("6-go back");

        // ----------------------------------------------
        // OPTIONS (Back end)

        // input
        int selection;
        Scanner scan = new Scanner(System.in);
        selection = scan.nextInt();

        double input;
        switch (selection) {
            case 0:
                System.out.println("Please enter the amount of diesel to be added");
                input = scan.nextDouble();
                Dhoani.addDiesel(input);
                addToDhoaniMenu();
                break;
            case 1:
                System.out.println("Please enter the amount of Frozen to be added");
                input = scan.nextDouble();
                Dhoani.addFrozen(input);
                addToDhoaniMenu();
                break;
            case 2:
                System.out.println("Please enter the amount of Fridge to be added");
                input = scan.nextDouble();
                Dhoani.addFridge(input);
                addToDhoaniMenu();
                break;
            case 3:
                System.out.println("Please enter the amount of food to be added");
                input = scan.nextDouble();
                Dhoani.addFood(input);
                addToDhoaniMenu();
                break;
            case 4:
                System.out.println("Please enter the amount of Protected Materials to be added");
                input = scan.nextDouble();
                Dhoani.addProtectedMaterials(input);
                addToDhoaniMenu();
                break;
            case 5:
                System.out.println("Please enter the amount of Unprotected Materials to be added");
                input = scan.nextDouble();
                Dhoani.addUnprotectedMaterials(input);
                addToDhoaniMenu();
                break;
            case 6:
                mainMenu();
                break;
            default:
                System.out.println("Please enter a valid option");
                addToDhoaniMenu();
                break;
        }
        scan.close();
    }

}
