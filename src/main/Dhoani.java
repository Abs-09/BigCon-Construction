package src.main;

public class Dhoani {

    // DEFINING AND INTIALIZING STORAGES in Kgs
    // -----------------------------------
    static double diesel_in_tank = 0;
    static double frozen_in_tank = 0;
    static double fridge_in_tank = 0;
    // shared storage
    static double food_in_tank = 0;
    static double protected_materials_in_tank = 0;
    static double unprotected_materials_in_tank = 0;

    // DEFINING MAX CAPACITY in Kgs
    // -----------------------------------------------
    static double diesel_MAX = 3328; // (4)m3 -> kgs
    static double frozen_MAX = 40;
    static double fridge_MAX = 50;
    static double food_protected_unprotected_materials_MAX = 28000;
    static double dhoani_allowed_max = 30000;

    // ---------------------------------------------------------------------
    // ADD FUNCTIONS: Adds to the rescoures (attribs) after user gives input
    // Please refer below for subfunctions used.
    public static void addDiesel(double input) {

        diesel_in_tank = add(
                meter3_to_kgs(input),
                diesel_in_tank,
                diesel_MAX);

        displayDieselStatus();
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

        // checks the current time as good can be loaded to Dhoani during day time
        if (Main.current_time > 18) {

            if (input + storage_in_tank <= MAX && input + dhoaniCurrentTotalMaterials() <= dhoani_allowed_max) {

                System.out.println("Successful!");
                return input + storage_in_tank;

            } else {

                System.out.println("\nNot enough space!");
                return storage_in_tank;

            }
        } else {
            System.out.println("Its currently night time. Goods can be loaded to the boat during day time");
            return storage_in_tank;
        }

    }

    // This function is used to add food, protected, unprotected materials since
    // they share a common space unit for storage.
    private static double addShared(double input, double storage_in_tank, double MAX) {

        // calulating total capacity in dhoani (all storages combined)
        double shared_materials_in_tank = food_in_tank +
                protected_materials_in_tank +
                unprotected_materials_in_tank;

        if (Main.current_time < 18) {

            if (input + shared_materials_in_tank <= MAX
                    && input + dhoaniCurrentTotalMaterials() <= dhoani_allowed_max) {

                System.out.println("Successful!\n");
                return input + storage_in_tank;

            } else {

                System.out.println("\nNot enough space!");
                return storage_in_tank;

            }

        } else {
            System.out.println("Its currently day time. Goods can loaded to the boat during night time");
        }
        return input;
    }

    // ---------------------------------------------------------------------
    // REMOVE FUNCTIONS: Adds to the rescoures (attribs) after user gives input
    // Please refer below for subfunctions used.
    public static void removeDiesel(double input) {
        diesel_in_tank =
    }
    // ---------------------------------------------------------------------
    // GENERALLIZED REMOVE FUNCTIONS------------------------

    public static double remove(double input, double storage_in_tank){
        if (input<storage_in_tank){
            return storage_in_tank - input;
        }else{
            System.out.println("There is not that much available in the dhoani tank");
            return storage_in_tank;
        }
    }

    // ---------------------------------------------------------------------
    // DISPLAY CURRENT STORAGE AND MAX CAPACITY: A handy function created to display
    // current and MAX Capacity

    // To keep track of total weight of dhoani
    public static double dhoaniCurrentTotalMaterials() {
        return diesel_in_tank + frozen_in_tank + fridge_in_tank + food_in_tank + protected_materials_in_tank
                + unprotected_materials_in_tank;
    }

    // displays total dhoani status
    public static void dhoaniTotalWeightStatus() {
        System.out.println("--------------------");
        System.out.println("DHOANI STATUS:");
        System.out.println("Current Total storage in Dhoani: " + dhoaniCurrentTotalMaterials());
        System.out.println("Dhonai Total Maximum Capacity: " + dhoani_allowed_max + "\n");
    }

    // for all storages except for diesel
    public static void displayStorageStatus(String storage_name, double storage_in_tank, double MAX) {
        System.out.println("--------------------");
        System.out.println("DHOANI " + storage_name + " STATUS:");
        System.out.println("Current In Tank: " + storage_in_tank);
        System.out.println("Maximum Capacity: " + MAX);
        dhoaniTotalWeightStatus();
    }

    // for diesel (seperate function since kgs_to_meter3 conversion has to be made)
    public static void displayDieselStatus() {
        System.out.println("--------------------");
        System.out.println("DHOANI DIESEL STATUS:");
        System.out.println("Current In Tank: " + kgs_to_meter3(diesel_in_tank));
        System.out.println("Maximum Capacity: " + kgs_to_meter3(diesel_MAX));
        dhoaniTotalWeightStatus();
    }

    // ---------------------------------------------------------------------
    // CONVERTER FUNCTIONS:

    // m3 -> Kgs (in 1000)
    public static double meter3_to_kgs(double input) {
        return input * 832;
    }

    // Kgs (in 1000) -> m3
    public static double kgs_to_meter3(double input) {
        return input / 832;
    }

}