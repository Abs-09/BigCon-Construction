package src.main;

public class Island {
    String name;
    int distanceToPrev;
    int distanceToNext;
    Island next;
    Island prev;
    // DEFINING AND INTIALIZING STORAGES in Kgs
    // -----------------------------------
    double diesel_in_tank = 0;
    double frozen_in_tank = 0;
    double fridge_in_tank = 0;
    double food_in_tank = 0;
    double protected_materials_in_tank = 0;
    double unprotected_materials_in_tank = 0;

    // DEFINING MAX CAPACITY in Kgs
    // -----------------------------------------------
    double diesel_MAX; // (4)m3 -> kgs
    double frozen_MAX;
    double fridge_MAX;
    double food_MAX;
    double protected_materials_MAX;

    // For Space Check Functions
    boolean hasSpace;
    boolean hasRemaining;
    // For time check

    // constructor
    public Island(
            String name,
            int distanceToPrev,
            int distanceToNext,
            double diesel_in_tank,
            double frozen_in_tank,
            double fridge_in_tank,
            double food_in_tank,
            double protected_materials_in_tank,
            double unprotected_materials_in_tank,
            double diesel_MAX, // (4)m3 -> kgs
            double frozen_MAX,
            double fridge_MAX,
            double food_MAX,
            double protected_materials_MAX) {
        this.name = name;
        this.distanceToPrev = distanceToPrev;
        this.distanceToNext = distanceToNext;
        this.diesel_in_tank = meter3_to_kgs(diesel_in_tank);
        this.frozen_in_tank = frozen_in_tank;
        this.fridge_in_tank = fridge_in_tank;
        this.food_in_tank = food_in_tank;
        this.protected_materials_in_tank = protected_materials_in_tank;
        this.unprotected_materials_in_tank = unprotected_materials_in_tank;
        this.diesel_MAX = meter3_to_kgs(diesel_MAX);
        this.frozen_MAX = frozen_MAX;
        this.fridge_MAX = fridge_MAX;
        this.food_MAX = food_MAX;
        this.protected_materials_MAX = protected_materials_MAX;
    }

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

    public boolean isAnySpaceAvailable() {
        if (diesel_in_tank == diesel_MAX &&
                frozen_in_tank == frozen_MAX &&
                fridge_in_tank == fridge_MAX &&
                food_in_tank == food_MAX &&
                protected_materials_in_tank == protected_materials_MAX) {
            return false;
        } else {
            return true;
        }
    }

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

    // Generelaized Space Checker------------------------
    // This function is used to check for diesel, frozen, fridge space.
    private boolean checkSpace(double input, double storage_in_tank, double MAX) {

        if (input + storage_in_tank <= MAX) {
            return true;
        } else {
            return false;

        }

    }

    // ---------------------------------------------------------------------
    // CHECK REMAINING FUNCTION: checks whether there is storage in tank available
    // as the user demands
    // Please refer below for subfunctions used.
    public boolean isDieselAmountRemainingInTank(double input) {
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

    // Generalized remaining function------------------------
    public boolean checkRemaining(double input, double storage_in_tank) {
        if (input < storage_in_tank) {
            return true;
        } else {
            return false;
        }
    }

    // ---------------------------------------------------------------------
    // DISPLAY CURRENT STORAGE AND MAX CAPACITY: A handy function created to display
    // current and MAX Capacity

    // for all storages except for diesel
    public void displayStorageStatus(String storage_name, double storage_in_tank, double MAX) {
        System.out.println("--------------------");
        System.out.println("ISLAND " + storage_name + " STATUS:");
        System.out.println("Current In Tank: " + storage_in_tank);
        System.out.println("Maximum Capacity: " + MAX);

    }

    // for diesel (seperate function since kgs_to_meter3 conversion has to be made)
    public void displayDieselStatus() {
        System.out.println("--------------------");
        System.out.println("ISLAND DIESEL STATUS:");
        System.out.println("Current In Tank: " + kgs_to_meter3(diesel_in_tank));
        System.out.println("Maximum Capacity: " + kgs_to_meter3(diesel_MAX));
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