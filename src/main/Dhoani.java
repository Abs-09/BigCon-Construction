package src.main;

public class Dhoani {

    // DEFINING AND INTIALIZING STORAGES in Kgs
    // -----------------------------------
    double diesel_in_tank = 3328;
    double frozen_in_tank = 0;
    double fridge_in_tank = 0;
    // shared storage
    double food_in_tank = 0;
    double protected_materials_in_tank = 0;
    double unprotected_materials_in_tank = 0;

    // DEFINING MAX CAPACITY in Kgs
    // -----------------------------------------------
    double diesel_MAX = 3328; // (4)m3 -> kgs
    double frozen_MAX = 40;
    double fridge_MAX = 50;
    double food_protected_unprotected_materials_MAX = 28000;
    double dhoani_allowed_max = 30000;

    // For Space Check Functions
    boolean hasSpace;
    boolean hasRemaining;
    // For time check
    boolean isDay;// 06:00 to 18:00 is considered day time

    // ---------------------------------------------------------------------
    // ADD FUNCTIONS: Adds to the rescoures (attribs) after user gives input
    // Please refer below for subfunctions used.

    public void addDiesel(double input) {
        diesel_in_tank += meter3_to_kgs(input);
    }

    public void addFrozen(double input) {
        frozen_in_tank += input;
    }

    public void addFridge(double input) {
        fridge_in_tank += input;
    }

    public void addFood(double input) {
        food_in_tank += input;
    }

    public void addProtectedMaterials(double input) {
        protected_materials_in_tank += input;
    }

    public void addUnprotectedMaterials(double input) {
        unprotected_materials_in_tank += input;
    }

    // ---------------------------------------------------------------------
    // REMOVE FUNCTIONS: Adds to the rescoures (attribs) after user gives input
    // Please refer below for subfunctions used.

    public void removeDiesel(double input) {
        diesel_in_tank -= meter3_to_kgs(input);
    }

    public void removeFrozen(double input) {
        frozen_in_tank -= input;
    }

    public void removeFridge(double input) {
        fridge_in_tank -= input;
    }

    public void removeFood(double input) {
        food_in_tank -= input;
    }

    public void removeProtectedMaterials(double input) {
        protected_materials_in_tank -= input;
    }

    public void removeUnprotectedMaterials(double input) {
        unprotected_materials_in_tank -= input;
    }

    // ---------------------------------------------------------------------
    // CHECK SPACE FUNCTIONS: checks whethe space is available
    // Please refer below for subfunctions used.
    public boolean isDieselSpaceAvailable(double input) {

        return hasSpace = checkSpace(
                meter3_to_kgs(input),
                diesel_in_tank,
                diesel_MAX);

    }

    public boolean isFrozenSpaceAvailable(double input) {

        return hasSpace = checkSpace(
                input,
                frozen_in_tank,
                frozen_MAX);
    }

    public boolean isFridgeSpaceAvailable(double input) {

        return hasSpace = checkSpace(
                input,
                fridge_in_tank,
                fridge_MAX);

    }

    //THIS is to check if food, protected materials, and food in take is available since they share once space
    public boolean isSharedSpaceAvailable(double input) {

        // defining current materials in tank
        double shared_materials_in_tank = food_in_tank +
                protected_materials_in_tank +
                unprotected_materials_in_tank;

        if (input + shared_materials_in_tank <= food_protected_unprotected_materials_MAX
                && input + dhoaniCurrentTotalMaterials() <= dhoani_allowed_max) {
            hasSpace = true;
        } else {
            hasSpace = false;
        }

        return hasSpace;

    }

    // Generelaized Space Checker------------------------
    // This function is used to check for diesel, frozen, fridge space.
    private boolean checkSpace(double input, double storage_in_tank, double MAX) {

        if (input + storage_in_tank <= MAX && input + dhoaniCurrentTotalMaterials() <= dhoani_allowed_max) {
            return true;
        } else {
            return false;

        }

    }

    // ---------------------------------------------------------------------
    // CHECK REMAINING FUNCTION: checks whether there is storage in tank available
    // as the user demands
    // Please refer below for subfunctions used.
    public boolean isDieselRemainingInTank(double input) {
        return hasRemaining = checkRemaining(meter3_to_kgs(input), diesel_in_tank);
    }

    public boolean isFrozenRemainingInTank(double input) {
        return hasRemaining = checkRemaining(input, frozen_in_tank);
    }

    public boolean isFridgeRemainingInTank(double input) {
        return hasRemaining = checkRemaining(input, fridge_in_tank);
    }

    public boolean isFoodRemainingInTank(double input) {
        return hasRemaining = checkRemaining(input, food_in_tank);
    }

    public boolean isProtectedMaterialsRemainingInTank(double input) {
        return hasRemaining = checkRemaining(input, protected_materials_in_tank);
    }

    public boolean isUnprotectedMaterialsRemainingInTank(double input) {
        return hasRemaining = checkRemaining(input, unprotected_materials_in_tank);
    }

    // Generalized remaining function------------------------
    public boolean checkRemaining(double input, double storage_in_tank) {
        if (input <= storage_in_tank) {
            return true;
        } else {
            return false;
        }
    }

    // ---------------------------------------------------------------------
    // DISPLAY CURRENT STORAGE AND MAX CAPACITY: A handy function created to display
    // current and MAX Capacity

    // To keep track of total weight of dhoani
    public double dhoaniCurrentTotalMaterials() {
        return diesel_in_tank + frozen_in_tank + fridge_in_tank + food_in_tank + protected_materials_in_tank
                + unprotected_materials_in_tank;
    }

    // displays total dhoani status
    public void dhoaniTotalWeightStatus() {
        System.out.println("--------------------");
        System.out.println("DHOANI STATUS:");
        System.out.println("Current Total storage in Dhoani: " + dhoaniCurrentTotalMaterials());
        System.out.println("Dhonai Total Maximum Capacity: " + dhoani_allowed_max + "\n");
    }

    // for diesel (seperate function since kgs_to_meter3 conversion has to be made)
    public void displayDieselStatus() {
        System.out.println("--------------------");
        System.out.println("DHOANI DIESEL STATUS:");
        System.out.println("Current In Tank: " + kgs_to_meter3(diesel_in_tank));
        System.out.println("Maximum Capacity: " + kgs_to_meter3(diesel_MAX));
        dhoaniTotalWeightStatus();
    }

    public void displayFrozenStatus() {
        System.out.println("--------------------");
        System.out.println("DHOANI FROZEN STATUS:");
        System.out.println("Current In Tank: " + frozen_in_tank);
        System.out.println("Maximum Capacity: " + frozen_MAX);
        dhoaniTotalWeightStatus();
    }

    public void displayFridgeStatus() {
        System.out.println("--------------------");
        System.out.println("DHOANI FRIDGE STATUS:");
        System.out.println("Current In Tank: " + fridge_in_tank);
        System.out.println("Maximum Capacity: " + fridge_MAX);
        dhoaniTotalWeightStatus();
    }

    public void displayFoodStatus() {
        System.out.println("--------------------");
        System.out.println("DHOANI FOOD STATUS:");
        System.out.println("Current In Tank: " + food_in_tank);
        System.out.println("Current In Shared Tank: " + food_in_tank + protected_materials_in_tank + unprotected_materials_in_tank);
        System.out.println("Maximum Capacity: " + food_protected_unprotected_materials_MAX);
        dhoaniTotalWeightStatus();
    }

    public void displayProtectedMaterialsStatus() {
        System.out.println("--------------------");
        System.out.println("DHOANI PROTECTED MATERIALS STATUS:");
        System.out.println("Current In Tank: " + protected_materials_in_tank);
        System.out.println("Current In Shared Tank: " + food_in_tank + protected_materials_in_tank + unprotected_materials_in_tank);
        System.out.println("Maximum Capacity: " + food_protected_unprotected_materials_MAX);
        dhoaniTotalWeightStatus();
    }

    public void displayUnprotectedMaterialsStatus() {
        System.out.println("--------------------");
        System.out.println("DHOANI UNPROTECTED MATERIALS STATUS:");
        System.out.println("Current In Tank: " + unprotected_materials_in_tank);
        System.out.println("Current In Shared Tank: " + food_in_tank + protected_materials_in_tank + unprotected_materials_in_tank);
        System.out.println("Maximum Capacity: " + food_protected_unprotected_materials_MAX);
        dhoaniTotalWeightStatus();
    }

    // ---------------------------------------------------------------------
    // CONVERTER FUNCTIONS:
    // m3 -> Kgs (in 1000)
    public double meter3_to_kgs(double input) {
        return input * 832;
    }

    // Kgs (in 1000) -> m3
    public double kgs_to_meter3(double input) {
        return input / 832;
    }

}