package src.main;

public class Dhoani {

    // DEFINING AND INTIALIZING STORAGES -----------------------------------
    static double diesel = 0;
    static double frozen = 0;
    static double fridge = 0;
    static double food = 0;
    static double protected_materials = 0;
    static double unprotected_materials = 0;

    // DEFINING MAX CAPACITY -----------------------------------------------
    static double diesel_MAX = 4;
    static double frozen_MAX = 0.04;
    static double fridge_MAX = 0.05;
    static double food_protected_unprotected_materials_MAX = 28;

    // ---------------------------------------------------------------------
    // ADD FUNCTIONS: Adds to the rescoures (attribs) after user gives input
    // Please refer below for subfunctions used.
    public static void addDiesel(double input) {
        diesel = add(input, diesel, diesel_MAX);
        displayStorageStatus("DIESEL", diesel, diesel_MAX);
    }

    public static void addFrozen(double input) {
        frozen = add(input, frozen, frozen_MAX);
        displayStorageStatus("FROZEN", frozen, frozen_MAX);
    }

    public static void addFridge(double input) {
        fridge = add(input, fridge, fridge_MAX);
        displayStorageStatus("FRIDGE", fridge, fridge_MAX);
    }

    public static void addFood(double input) {
        food = addShared(input, food, food_protected_unprotected_materials_MAX);
        displayStorageStatus("FOOD", food, food_protected_unprotected_materials_MAX);
    }

    public static void addProtectedMaterials(double input) {
        protected_materials = addShared(input, protected_materials, food_protected_unprotected_materials_MAX);
        displayStorageStatus("PROTECTED MATERIALS", protected_materials, food_protected_unprotected_materials_MAX);
    }

    public static void addUnprotectedMaterials(double input) {
        unprotected_materials = addShared(input, unprotected_materials, food_protected_unprotected_materials_MAX);
        displayStorageStatus("UNPROTECTED MATERIALS", unprotected_materials, food_protected_unprotected_materials_MAX);
    }

    // ---------------------------------------------------------------------
    // GENERALLIZED ADD FUNCTIONS------------------------
    // This function is used to add diesel, frozen, fridge.
    private static double add(double input, double storage, double MAX) {
        double remaining = MAX - storage;
        if (input <= remaining) {
            System.out.print("Storage added:");
            return storage + input;
        } else {
            System.out.print("Storage not available, current capacity: ");
            return storage;
        }
    }

    // This function is used to add food, protected, unprotected materials since
    // they share a common space unit for storage.
    private static double addShared(double input, double storage, double MAX) {
        double total_storage = food + protected_materials + unprotected_materials;
        double remaining = MAX - total_storage;
        if (input <= remaining) {
            return storage + input;
        } else {
            System.out.println("Storage not available, current capacity");
            return storage;
        }
    }

    // ---------------------------------------------------------------------
    // DISPLAY CURRENT STORAGE AND MAX CAPACITY: A handy function created to display
    // current and MAX Capacity
    public static void displayStorageStatus(String storage_name, double storage, double MAX) {
        System.out.println("DHOANI " + storage_name + " STATUS:");
        System.out.println("Current Capacity: " + storage);
        System.out.println("Maximum Capacity:" + MAX);
    }
}