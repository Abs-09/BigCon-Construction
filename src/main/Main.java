package src.main;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static double current_time_in_minutes = 480;

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
                "0-Exit System",
        };

        // BACKEND
        Scanner scan = new Scanner(System.in);
        int selection;
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
                case 0:
                    break;
                default:
                    System.out.println("Invalid Option");
            }
        } while (selection != 0);
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
                    System.out.println("Please enter the amount of diesel to be Consumed");
                    input = scan.nextDouble();
                    controller.consumeDieselFromIsland(input);
                    break;
                case 2:
                    System.out.println("Please enter the amount of frozen to be Consumed");
                    input = scan.nextDouble();
                    controller.consumeFrozenFromIsland(input);
                    break;
                case 3:
                    System.out.println("Please enter the amount of Fridge to be Consumed");
                    input = scan.nextDouble();
                    controller.consumeDieselFromIsland(input);
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
                    System.out.print("Please select the amount: ");
                    input = scan.nextDouble();
                    controller.addDieselToDhoaniFromIsland(input);
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
                    System.out.print("Please select the amount: ");
                    input = scan.nextDouble();
                    controller.addDieselToIslandFromDhoani(input);
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
        // mainMenu(controller);

        System.out.println("Current Island: "+controller.islands.currentIsland.name);
        controller.travelToEastIsland();
        //controller.islands.validateNextIslandThatCanBeTraveledEast();

        // System.out.println(Main.current_time);
        // controller.SkipHours(3);
        // System.out.println(Main.current_time);
        // controller.SkipHours(4);
        // System.out.println(Main.current_time);

        // IslandLinkedList islands = new IslandLinkedList();
        // controller.checkCurrentIsland();
        // controller.checkCurrentTime();

        // controller.travelToEastIsland();
        // controller.checkCurrentIsland();
        // controller.checkCurrentTime();

        // controller.travelToEastIsland();
        // controller.checkCurrentIsland();
        // controller.checkCurrentTime();

        // controller.displayIslandDieselStatus();
        // controller.displayDhoaniDieselStatus();
        // controller.addDieselToIslandFromDhoani(5);
        // // controller.addDieselToIslandFromDhoani(2);
        // controller.displayIslandDieselStatus();
        // controller.displayDhoaniDieselStatus();

        // int[] arr = { 15, 10, 20, 5, 8, 21, 7, 25, 18 };

        // int i = -1;
        // int pivot = arr[8];
        // int temp;

        // for (int j = 0; j <= arr.length - 2; j++) {
        // // check with pivot
        // if (arr[j] <= pivot) {
        // // increment i
        // i++;
        // // arr[i] <=> arr [j]
        // temp = arr[i];
        // arr[i] = arr[j];
        // arr[j] = temp;
        // }
        // System.out.println("arr[i]: " + arr[i]);
        // System.out.println("arr[j]: " + arr[j]);
        // }
        // temp = arr[i + 1];
        // arr[i + 1] = arr[8];
        // arr[8] = temp;

        // for (int y = 0; y < arr.length; y++) {
        // System.out.print(arr[y] + ", ");
        // }

    }

}
