package src.main;

import java.util.Scanner;

public class Main {

    static double current_time_in_minutes = 1140;

    // PRINT MENU OPTIONS a custom function done to print array menu
    public static void printMenu(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }

    // MAIN MENU---------------------------
    public static void mainMenu(Controller controller) {

        // FRONT END
        String[] options = {
                "\nMAIN MENU",
                "1-Consume Items from Island Warehouse",
                "2-Add Items to Dhoani from Island warehouse",
                "3-Add Items to Island Warehouse from Dhoani",
                "4-View Storage",
                "5-Travel",
                "6-Check Current Island",
                "7-Check Current Time",
                "8-Skip Time",
                "0-Exit System",
        };

        // BACKEND
        Scanner scan = new Scanner(System.in);
        int selection;
        double input;
        do {
            printMenu(options);
            selection = scan.nextInt();
            switch (selection) {
                case 1:
                    consumeFromIslandMenu(controller);
                    break;
                case 2:
                    addToDhoaniFromIslandMenu(controller);
                    break;
                case 3:
                    addToIslandFromDhoaniMenu(controller);
                    break;
                case 4:
                    // display menu
                    break;
                case 5:
                    travelMenu(controller);
                    break;
                case 6:
                    controller.checkCurrentIsland();
                    break;
                case 7:
                    controller.checkCurrentTime();
                    break;
                case 8:
                    System.out.print("How many hours would you like to skip?");
                    input = scan.nextInt();
                    controller.SkipHours(input);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid Option");
            }
        } while (selection != 0);
        scan.nextLine();
        scan.close();
        System.out.println("System Exited");
    }

    // MENU: COMSUME FROM ISLAND
    public static void consumeFromIslandMenu(Controller controller) {
        // FRONT END
        String[] options = {
                "\nCONSUME FROM ISLAND",
                "1-Consume Diesel from Island",
                "2-Consume Frozen from Island",
                "3-Consume Fridge from Island",
                "4-Consume Food from Island",
                "5-Consume Protected Materials from Island",
                "6-Consume Unprotected Materials from Island",
                "7-Check Island Status",
                "0-BACK",
        };

        // BACKEND
        Scanner scan = new Scanner(System.in);
        int selection;
        do {
            printMenu(options);
            selection = scan.nextInt();
            double input;
            switch (selection) {
                case 1:
                    System.out.println("Please enter the amount of diesel to be Consumed (m3): ");
                    input = scan.nextDouble();
                    controller.consumeDieselFromIsland(input);
                    break;
                case 2:
                    System.out.println("Please enter the amount of frozen to be Consumed (kgs): ");
                    input = scan.nextDouble();
                    controller.consumeFrozenFromIsland(input);
                    break;
                case 3:
                    System.out.println("Please enter the amount of Fridge to be Consumed (kgs): ");
                    input = scan.nextDouble();
                    controller.consumeFridgeFromIsland(input);
                    break;
                case 4:
                    System.out.println("Please enter the amount of Food to be Consumed (kgs): ");
                    input = scan.nextDouble();
                    controller.consumeFoodFromIsland(input);
                    break;
                case 5:
                    System.out.println("Please enter the amount of Protected Materials to be Consumed (kgs): ");
                    input = scan.nextDouble();
                    controller.consumeProtectedMaterialsFromIsland(input);
                    break;
                case 6:
                    System.out.println("Please enter the amount of Unprotected Materials to be Consumed (kgs): ");
                    input = scan.nextDouble();
                    controller.consumeUnprotectedMaterialsFromIsland(input);
                    break;
                case 7:
                    controller.displayIslandStatus();
                    break;
                case 0:
                    break;

            }
        } while (selection != 0);
        scan.nextLine();

    }

    // //ADD TO DHOANI MENU
    // public static void addToDhoaniMenu(Controller controller) {
    // // FRONT END
    // String[] options = {
    // "\nADD TO DHOANI",
    // "0-Add Diesel to Dhoani",
    // "1-Add Frozen to Dhoani",
    // "2-Add Fridge to Dhoani",
    // "3-Add Food to Dhoani",
    // "4-Add Protected Materials to Dhoani",
    // "5-Add Unprotected Materials to Dhoani",
    // "6-Check Dhoani Status",
    // "7-BACK",
    // };

    // // BACKEND
    // Scanner scan = new Scanner(System.in);
    // int selection;
    // do {
    // printMenu(options);
    // selection = scan.nextInt();
    // double input;
    // switch (selection) {
    // case 0:
    // System.out.print("Please select the amount: ");
    // input = scan.nextDouble();
    // controller.addDieselToDhoani(input);
    // break;

    // case 6:
    // controller.displayDhoaniStatus();
    // break;
    // case 7:
    // break;

    // }
    // } while (selection != 7);
    // scan.nextLine();

    // }

    // //ADD TO ISLAND MENU
    // public static void addToIslandMenu(Controller controller) {
    // // FRONT END
    // String[] options = {
    // "\nADD TO ISLAND",
    // "0-Add Diesel to Island Warehouse",
    // "1-Add Frozen to Island Warehouse",
    // "2-Add Fridge to Island Warehouse",
    // "3-Add Food to Island Warehouse",
    // "4-Add Protected Materials to Island Warehouse",
    // "5-Add Unprotected Materials to Island Warehouse",
    // "6-Check Island Warehouse Status",
    // "7-BACK",
    // };

    // // BACKEND
    // Scanner scan = new Scanner(System.in);
    // int selection;
    // do {
    // printMenu(options);
    // selection = scan.nextInt();
    // double input;
    // switch (selection) {
    // case 0:
    // System.out.print("Please select the amount: ");
    // input = scan.nextDouble();
    // controller.addDieselToIsland(input);
    // break;

    // case 6:
    // controller.displayIslandStatus();
    // break;
    // case 7:
    // break;

    // }
    // } while (selection != 7);
    // scan.nextLine();

    // }

    // ISLAND -> DHOANI
    public static void addToDhoaniFromIslandMenu(Controller controller) {
        // FRONT END
        String[] options = {
                "\nADD TO DHOANI FROM ISLAND MENU",
                "1-Add Diesel to dhoani from island",
                "2-Add Frozen to dhoani from island",
                "3-Add Fridge to dhoani from island",
                "4-Add Food to dhoani from island",
                "5-Add Protected Materials to dhoani from island",
                "6-Add Uprotected Materials to dhoani from island",
                "7-Check Dhoani Status",
                "8-Check Island Status",
                "0-BACK",
        };

        // BACKEND
        Scanner scan = new Scanner(System.in);
        int selection;
        do {
            printMenu(options);
            selection = scan.nextInt();
            double input;
            switch (selection) {
                case 1:
                    System.out.print("Please select the amount of diesel (m3): ");
                    input = scan.nextDouble();
                    controller.addDieselToDhoaniFromIsland(input);
                    break;
                case 2:
                    System.out.print("Please select the amount of frozen (kgs): ");
                    input = scan.nextDouble();
                    controller.addFrozenToDhoaniFromIsland(input);
                    break;
                case 3:
                    System.out.print("Please select the amount of Fridge (kgs): ");
                    input = scan.nextDouble();
                    controller.addFridgeToDhoaniFromIsland(input);
                    break;
                case 4:
                    System.out.print("Please select the amount of Food (kgs): ");
                    input = scan.nextDouble();
                    controller.addFoodToDhoaniFromIsland(input);
                    break;
                case 5:
                    System.out.print("Please select the amount of Protected Materials (kgs): ");
                    input = scan.nextDouble();
                    controller.addProtectedMaterialsToDhoaniFromIsland(input);
                    break;
                case 6:
                    System.out.print("Please select the amount of UnprotectedMaterials (kgs): ");
                    input = scan.nextDouble();
                    controller.addUnprotectedMaterialsToDhoaniFromIsland(input);
                    break;
                case 7:
                    controller.displayDhoaniStatus();
                    break;
                case 8:
                    controller.displayIslandStatus();
                    break;
                case 0:
                    break;
            }
        } while (selection != 0);
        scan.nextLine();

    }

    public static void addToIslandFromDhoaniMenu(Controller controller) {

        // FRONT END
        String[] options = {
                "\nADD TO ISLAND FROM DHOANI MENU",
                "1-Add Diesel to Island from Dhoani",
                "2-Add Frozen to Island from Dhoani",
                "3-Add Fridge to Island from Dhoani",
                "4-Add Food to Island from Dhoani",
                "5-Add Protected Materials to Island from Dhoani",
                "6-Add Uprotected Materials to Island from Dhoani",
                "7-Check Dhoani Status",
                "8-Check Island Status",
                "0-BACK",
        };

        // BACKEND
        Scanner scan = new Scanner(System.in);
        int selection;
        do {
            printMenu(options);
            selection = scan.nextInt();
            double input;
            switch (selection) {
                case 1:
                    System.out.print("Please select the amount (kgs): ");
                    input = scan.nextDouble();
                    controller.addDieselToIslandFromDhoani(input);
                    break;
                case 2:
                    System.out.print("Please select the amount of frozen (kgs): ");
                    input = scan.nextDouble();
                    controller.addFrozenToIslandFromDhoani(input);
                    break;
                case 3:
                    System.out.print("Please select the amount of Fridge (kgs): ");
                    input = scan.nextDouble();
                    controller.addFridgeToIslandFromDhoani(input);
                    break;
                case 4:
                    System.out.print("Please select the amount of Food (kgs): ");
                    input = scan.nextDouble();
                    controller.addFoodToIslandFromDhoani(input);
                    break;
                case 5:
                    System.out.print("Please select the amount of Protected Materials (kgs): ");
                    input = scan.nextDouble();
                    controller.addProtectedMaterialsToIslandFromDhoani(input);
                    break;
                case 6:
                    System.out.print("Please select the amount of UnprotectedMaterials (kgs): ");
                    input = scan.nextDouble();
                    controller.addUnprotectedMaterialsToIslandFromDhoani(input);
                    break;
                case 7:
                    controller.displayDhoaniStatus();
                    break;
                case 8:
                    controller.displayIslandStatus();
                    break;
                case 0:
                    break;

            }
        } while (selection != 0);
        scan.nextLine();

    }

    public static void travelMenu(Controller controller) {

        // FRONT END
        String[] options = {
                "\nTRAVEL MENU",
                "1-Check Current Island",
                "2-Travel East",
                "3-Travel West",
                "4-Check Remaining East Islands to Travel",
                "5-Check Remaining West Islands to Travel",
                "6-Check Current Time",
                "7-Skip Time",
                "0-BACK",
        };

        // BACKEND
        Scanner scan = new Scanner(System.in);
        int selection;
        do {
            printMenu(options);
            selection = scan.nextInt();
            int input;
            switch (selection) {
                case 1:
                    controller.checkCurrentIsland();
                    break;
                case 2:
                    controller.travelToEastIsland();
                    break;
                case 3:
                    controller.travelToWestIsland();
                    break;
                case 4:
                    controller.islands.checkRemainingIslandsToEastThatCanBeReachedDuringDayTime();
                    break;
                case 5:
                    controller.islands.checkRemainingIslandsToWestThatCanBeReachedDuringDayTime();
                    break;
                case 6:
                    controller.checkCurrentTime();
                    break;
                case 7:
                    System.out.print("How many hours would you like to skip?");
                    input = scan.nextInt();
                    controller.SkipHours(input);
                    break;
                case 0:
                    break;

            }
        } while (selection != 0);
        scan.nextLine();

    }

    public static void displayTime() {
        double currentTime = Main.current_time_in_minutes / 60;
        System.out.println(currentTime);
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        mainMenu(controller);

        // System.out.println();
        // controller.checkCurrentTime();
        // System.out.println("Current Island: " +
        // controller.islands.currentIsland.name);
        // controller.travelToEastIsland();

        // System.out.println();
        // controller.checkCurrentTime();
        // controller.travelToEastIsland();

        // System.out.println();
        // controller.checkCurrentTime();
        // controller.travelToEastIsland();

        // System.out.println();
        // controller.checkCurrentTime();
        // controller.travelToEastIsland();

        // System.out.println();
        // controller.checkCurrentTime();
        // controller.travelToEastIsland();

    }

}
