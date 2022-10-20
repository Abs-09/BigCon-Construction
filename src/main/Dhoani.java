package src.main;

public class Dhoani {

    // DEFINING AND INTIALIZING STORAGES (in 1000Kgs)
    // -----------------------------------
    static double diesel_in_tank = 0;
    static double frozen_in_tank = 0;
    static double fridge_in_tank = 0;
    static double food_in_tank = 0;
    static double protected_materials_in_tank = 0;
    static double unprotected_materials_in_tank = 0;
    //
    static double dhoani_current_total_materials = diesel_in_tank + frozen_in_tank + fridge_in_tank + food_in_tank
            + protected_materials_in_tank;

    // DEFINING MAX CAPACITY (in 1000Kgs)
    // -----------------------------------------------
    static double diesel_MAX = 3.328; // (4)m3 -> kgs (in 1000)
    static double frozen_MAX = 0.040;
    static double fridge_MAX = 0.050;
    static double food_protected_unprotected_materials_MAX = 28;
    static double dhoani_allowed_max = 30;

    // ---------------------------------------------------------------------
    // ADD FUNCTIONS: Adds to the rescoures (attribs) after user gives input
    // Please refer below for subfunctions used.
    public static void addDiesel(double input) {

        diesel_in_tank = add(
                Converter.meter3_to_1000kgs(input),
                diesel_in_tank,
                diesel_MAX);

        displayStorageStatus(
                "DIESEL",
                diesel_in_tank,
                diesel_MAX);
    }

    public static void addFrozen(double input) {

        frozen_in_tank = add(
                input,
                frozen_in_tank,
                frozen_MAX);

        displayStorageStatus(
                "FROZEN",
                frozen_in_tank,
                frozen_MAX);
    }

    public static void addFridge(double input) {

        fridge_in_tank = add(
                input,
                fridge_in_tank,
                fridge_MAX);

        displayStorageStatus(
                "FRIDGE",
                fridge_in_tank,
                fridge_MAX);

    }

    public static void addFood(double input) {

        food_in_tank = addShared(
                input,
                food_in_tank,
                food_protected_unprotected_materials_MAX);

        displayStorageStatus(
                "FOOD",
                food_in_tank + protected_materials_in_tank + unprotected_materials_in_tank,
                food_protected_unprotected_materials_MAX);
    }

    public static void addProtectedMaterials(double input) {

        protected_materials_in_tank = addShared(
                input,
                protected_materials_in_tank,
                food_protected_unprotected_materials_MAX);

        displayStorageStatus(
                "PROTECTED MATERIALS",
                food_in_tank + protected_materials_in_tank + unprotected_materials_in_tank,
                food_protected_unprotected_materials_MAX);
    }

    public static void addUnprotectedMaterials(double input) {
        unprotected_materials_in_tank = addShared(input, unprotected_materials_in_tank,
                food_protected_unprotected_materials_MAX);
        displayStorageStatus(
                "UNPROTECTED MATERIALS",
                food_in_tank + protected_materials_in_tank + unprotected_materials_in_tank,
                food_protected_unprotected_materials_MAX);
    }

    // ---------------------------------------------------------------------
    // GENERALLIZED ADD FUNCTIONS------------------------
    // This function is used to add diesel, frozen, fridge.
    private static double add(double input, double storage_in_tank, double MAX) {

        if (input + storage_in_tank < MAX && input + dhoani_current_total_materials > dhoani_allowed_max) {

            System.out.println("Added: " + input);
            return input + storage_in_tank;

        } else {

            System.out.println(
                    "\nNot enough space!" +
                            "\nAttemted input: " + input +
                            "\nSpace remaining: " + (MAX - storage_in_tank));
            return storage_in_tank;

        }
    }

    // This function is used to add food, protected, unprotected materials since
    // they share a common space unit for storage.
    private static double addShared(double input, double storage, double MAX) {
        return input;
    }

    // ---------------------------------------------------------------------
    // REMOVE FUNCTIONS: Adds to the rescoures (attribs) after user gives input
    // Please refer below for subfunctions used.
    public static void removeDiesel(double input) {

    }

    // ---------------------------------------------------------------------
    // DISPLAY CURRENT STORAGE AND MAX CAPACITY: A handy function created to display
    // current and MAX Capacity
    public static void displayStorageStatus(String storage_name, double storage, double MAX) {
        System.out.println("DHOANI " + storage_name + " STATUS:");
        System.out.println("Current Capacity: " + storage);
        System.out.println("Maximum Capacity: " + MAX + "\n");
    }

}