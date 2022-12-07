package src.main;

public class Controller {
    Dhoani dhoani;
    IslandLinkedList islands;

    public Controller() {
        this.dhoani = new Dhoani();
        this.islands = new IslandLinkedList();
    }

    // CONSUME ITEMS FROM ISLAND
    public void consumeDieselFromIsland(double input) {
        if (isDayTime()) {
            System.out.println("Currently day time. Can only be load/unloaded at night");
        } else if (!islands.currentIsland.isDieselRemainingInTank(input)) {
            System.out.println("space for requested amount not available");
        } else {
            islands.currentIsland.removeDiesel(input);
            System.out.println("Successfully Consumed");
        }

    }

    public void consumeFrozenFromIsland(double input) {
        if (isDayTime()) {
            System.out.println("Currently day time. Can only be load/unloaded at night");
        } else if (!islands.currentIsland.isFrozenRemainingInTank(input)) {
            System.out.println("space for requested amount not available");
        } else {
            islands.currentIsland.removeFrozen(input);
            System.out.println("Successfully Consumed");
        }

    }

    public void consumeFridgeFromIsland(double input) {
        if (isDayTime()) {
            System.out.println("Currently day time. Can only be load/unloaded at night");
        } else if (!islands.currentIsland.isFridgeRemainingInTank(input)) {
            System.out.println("space for requested amount not available");
        } else {
            islands.currentIsland.removeFridge(input);
            System.out.println("Successfully Consumed");
        }

    }

    public void consumeFoodFromIsland(double input) {
        if (isDayTime()) {
            System.out.println("Currently day time. Can only be load/unloaded at night");
        } else if (!islands.currentIsland.isFoodRemainingInTank(input)) {
            System.out.println("space for requested amount not available");
        } else {
            islands.currentIsland.removeFood(input);
            System.out.println("Successfully Consumed");
        }

    }

    public void consumeProtectedMaterialsFromIsland(double input) {
        if (isDayTime()) {
            System.out.println("Currently day time. Can only be load/unloaded at night");
        } else if (!islands.currentIsland.isProtectedMaterialsRemainingInTank(input)) {
            System.out.println("space for requested amount not available");
        } else {
            islands.currentIsland.removeProtectedMaterials(input);
            System.out.println("Successfully Consumed");
        }

    }

    public void consumeUnprotectedMaterialsFromIsland(double input) {
        if (isDayTime()) {
            System.out.println("Currently day time. Can only be load/unloaded at night");
        } else if (!islands.currentIsland.isUnprotectedMaterialsRemainingInTank(input)) {
            System.out.println("space for requested amount not available");
        } else {
            islands.currentIsland.removeUnprotectedMaterials(input);
            System.out.println("Successfully Consumed");
        }

    }

    // // ADD DIESEL TO DHOANI
    // public void addDieselToDhoani(double input) {
    // if (isDayTime()) {
    // System.out.println("Currently day time. Can only be load/unloaded at night");
    // } else if (!dhoani.isDieselSpaceAvailable(input)) {
    // System.out.println("space for requested amount not available");
    // } else {
    // dhoani.addDiesel(input);
    // System.out.println("Successfully Added");
    // }
    // }

    // // ADD DIESEL TO ISLAND
    // public void addDieselToIsland(double input) {
    // if (isDayTime()) {
    // System.out.println("Currently day time. Can only be load/unloaded at night");
    // } else {
    // dhoani.addDiesel(input);
    // System.out.println("Successfully Added");
    // }
    // }

    // ISLAND --> DHOANI
    public void addDieselToDhoaniFromIsland(double input) {
        if (isDayTime()) {
            System.out.println("Currently day time. Can only be load/unloaded at night");
        } else if (!dhoani.isDieselSpaceAvailable(input)) {
            System.out.println("Space not available for the requested amount");
        } else if (!islands.currentIsland.isDieselRemainingInTank(input)) {
            System.out.println("Requested amount not available in tank");
        } else {
            islands.currentIsland.removeDiesel(input);
            dhoani.addDiesel(input);
        }
    }

    public void addFrozenToDhoaniFromIsland(double input) {
        if (isDayTime()) {
            System.out.println("Currently day time. Can only be load/unloaded at night");
        } else if (!dhoani.isFrozenSpaceAvailable(input)) {
            System.out.println("Space not available for the requested amount");
        } else if (!islands.currentIsland.isFrozenRemainingInTank(input)) {
            System.out.println("Requested amount not available in tank");
        } else {
            islands.currentIsland.removeFrozen(input);
            dhoani.addFrozen(input);
        }
    }

    public void addFridgeToDhoaniFromIsland(double input) {
        if (isDayTime()) {
            System.out.println("Currently day time. Can only be load/unloaded at night");
        } else if (!dhoani.isFridgeSpaceAvailable(input)) {
            System.out.println("Space not available for the requested amount");
        } else if (!islands.currentIsland.isFridgeRemainingInTank(input)) {
            System.out.println("Requested amount not available in tank");
        } else {
            islands.currentIsland.removeFridge(input);
            dhoani.addFridge(input);
        }
    }

    public void addFoodToDhoaniFromIsland(double input) {
        if (isDayTime()) {
            System.out.println("Currently day time. Can only be load/unloaded at night");
        } else if (!dhoani.isSharedSpaceAvailable(input)) {
            System.out.println("Space not available for the requested amount");
        } else if (!islands.currentIsland.isFoodRemainingInTank(input)) {
            System.out.println("Requested amount not available in tank");
        } else {
            islands.currentIsland.removeFood(input);
            dhoani.addFood(input);
        }
    }

    public void addProtectedMaterialsToDhoaniFromIsland(double input) {
        if (isDayTime()) {
            System.out.println("Currently day time. Can only be load/unloaded at night");
        } else if (!dhoani.isSharedSpaceAvailable(input)) {
            System.out.println("Space not available for the requested amount");
        } else if (!islands.currentIsland.isProtectedMaterialsRemainingInTank(input)) {
            System.out.println("Requested amount not available in tank");
        } else {
            islands.currentIsland.removeProtectedMaterials(input);
            dhoani.addProtectedMaterials(input);
        }
    }

    public void addUnprotectedMaterialsToDhoaniFromIsland(double input) {
        if (isDayTime()) {
            System.out.println("Currently day time. Can only be load/unloaded at night");
        } else if (!dhoani.isSharedSpaceAvailable(input)) {
            System.out.println("Space not available for the requested amount");
        } else if (!islands.currentIsland.isUnprotectedMaterialsRemainingInTank(input)) {
            System.out.println("Requested amount not available in tank");
        } else {
            islands.currentIsland.removeUnprotectedMaterials(input);
            dhoani.addUnprotectedMaterials(input);
        }
    }

    // DHOANI --> ISLAND
    public void addDieselToIslandFromDhoani(double input) {
        if (isDayTime()) {
            System.out.println("Currently day time. Can only be load/unloaded at night");
        } else if (!islands.currentIsland.isDieselSpaceAvailable(input)) {
            System.out.println("Space not available for the requested amount");
        } else if (!dhoani.isDieselRemainingInTank(input)) {
            System.out.println("Requested amount not available in tank");
        } else {
            islands.currentIsland.addDiesel(input);
            dhoani.removeDiesel(input);
        }
    }

    public void addFrozenToIslandFromDhoani(double input) {
        if (isDayTime()) {
            System.out.println("Currently day time. Can only be load/unloaded at night");
        } else if (!islands.currentIsland.isFrozenSpaceAvailable(input)) {
            System.out.println("Space not available for the requested amount");
        } else if (!dhoani.isFrozenRemainingInTank(input)) {
            System.out.println("Requested amount not available in tank");
        } else {
            islands.currentIsland.addFrozen(input);
            dhoani.removeFrozen(input);
        }
    }

    public void addFridgeToIslandFromDhoani(double input) {
        if (isDayTime()) {
            System.out.println("Currently day time. Can only be load/unloaded at night");
        } else if (!islands.currentIsland.isFridgeSpaceAvailable(input)) {
            System.out.println("Space not available for the requested amount");
        } else if (!dhoani.isFridgeRemainingInTank(input)) {
            System.out.println("Requested amount not available in tank");
        } else {
            islands.currentIsland.addFridge(input);
            dhoani.removeFridge(input);
        }
    }

    public void addFoodToIslandFromDhoani(double input) {
        if (isDayTime()) {
            System.out.println("Currently day time. Can only be load/unloaded at night");
        } else if (!islands.currentIsland.isFoodSpaceAvailable(input)) {
            System.out.println("Space not available for the requested amount");
        } else if (!dhoani.isFoodRemainingInTank(input)) {
            System.out.println("Requested amount not available in tank");
        } else {
            islands.currentIsland.addFood(input);
            dhoani.removeFood(input);
        }
    }

    public void addProtectedMaterialsToIslandFromDhoani(double input) {
        if (isDayTime()) {
            System.out.println("Currently day time. Can only be load/unloaded at night");
        } else if (!islands.currentIsland.isProtectedMaterialsSpaceAvailable(input)) {
            System.out.println("Space not available for the requested amount");
        } else if (!dhoani.isProtectedMaterialsRemainingInTank(input)) {
            System.out.println("Requested amount not available in tank");
        } else {
            islands.currentIsland.addProtectedMaterials(input);
            dhoani.removeProtectedMaterials(input);
        }
    }

    public void addUnprotectedMaterialsToIslandFromDhoani(double input) {
        if (isDayTime()) {
            System.out.println("Currently day time. Can only be load/unloaded at night");
        } else if (!dhoani.isUnprotectedMaterialsRemainingInTank(input)) {
            System.out.println("Requested amount not available in tank");
        } else {
            islands.currentIsland.addUnprotectedMaterials(input);
            dhoani.removeUnprotectedMaterials(input);
        } 
    }

    //DISPLAY STATUS
    public void displayIslandDieselStatus() {
        islands.currentIsland.displayDieselStatus();
    }

    public void displayDhoaniDieselStatus() {
        dhoani.displayDieselStatus();
    }

    // REMOVE ITEMS FROM DHOANI
    public void removeDieselFromDhoani(double input) {
        if (isDayTime()) {
            System.out.println("Currently day time. Can only be load/unloaded at night");
        } else if (dhoani.isDieselRemainingInTank(input)) {
            System.out.println("Currently day time. Can only be load/unloaded at night");
        } else {
            dhoani.removeDiesel(input);
        }
    }

    // TRAVEL FUNCTIONS
    public void travelToEastIsland() {

        //gets the next island closest island that can be reached.
        //the function returns a counter and time in minutes to an array
        double[] array = islands.validateNextIslandThatCanBeTraveledEast();
        System.out.println(array[0]);//count
        System.out.println(array[1]);//time in minutes

        if (!isDayTime()) { //checks if it is day time
            System.out.println("Currently " + Main.current_time_in_minutes/60 + ", Dhoani can travel between 6am to 6pm");
        } else if (islands.currentIsland.next == null) { //Checks edge case for island
            System.out.println("Cannnot travel further east");
        } else if (isPastCurfew(array[1])) { //check if the next island can be traveled within day time
            System.out.println("Cannot reach the island with in day time, please wait till next day ");
        } else {
            SkipHours(islands.moveEast(array[0]));
        }

            //counter & time
        //check if time exceeds curfew when time is added (create a seperate Can travel function)
            //return boolean?
        //Is day time function (will this be needed)
            //boolean
        //Check for island edge case (this will be needed)
            //Null check
        //Travel east
            //skip hour with

        // if (!isDayTime()) {
        //     System.out.println("Currently " + Main.current_time_in_minutes/60 + ", Dhoani can travel between 6am to 6pm");
        // } else if (islands.currentIsland.next == null) {
        //     System.out.println("Cannnot travel further east");
        // } else if (!islands.currentIsland.next.isAnySpaceAvailable()) {
        //     System.out.println("No Space available at next island");
        // } else {
        //     SkipHours(islands.moveEast());
        //     islands.checkRemainingIslandsToEastThatCanBeReachedDuringDayTime();
        // }

    }

    public void travelToWestIsland() {

        if (!isDayTime()) {
            System.out.println("Currently " + Main.current_time_in_minutes/60 + ", Dhoani can travel between 6am to 6pm");
        } else if (islands.currentIsland.prev == null) {
            System.out.println("Cannot Travel further west");
        } else if (!islands.currentIsland.prev.isAnySpaceAvailable()) {
            System.out.println("No Space available at next island");
        } else {
            SkipHours(islands.moveWest());
            islands.checkRemainingIslandsToWestThatCanBeReachedDuringDayTime();
        }

    }

    public void checkCurrentIsland() {
        System.out.println("Current Island: " + islands.currentIsland.name);
    }

    // DISPLAY SPACE
    public void displayDhoaniStatus() {
        dhoani.displayDieselStatus();
        // TODO figure out the best way to diplay the status of others
    }

    public void displayIslandStatus() {
        islands.currentIsland.displayDieselStatus();
        // TODO figure out the best way to diplay the status of others
    }

    // ---------------------------------------------------------------------
    // TIME CHECK FUNCTIONS: function to check whether its currently day or night

    public void checkCurrentTime() {
        double current_time_in_hours = Main.current_time_in_minutes /60;
        System.out.println("Current Time: " + current_time_in_hours);
    }

    public boolean isDayTime() {
        if (Main.current_time_in_minutes >= 360 && Main.current_time_in_minutes <= 1080) {
            return true;
        } else {
            return false;
        }
    }

    public void SkipHours(double hours) {
        double minutes = hours * 60;
        Main.current_time_in_minutes = (Main.current_time_in_minutes + minutes) % 1440;
    }

    public boolean isPastCurfew(double minutes){

        double current_time_in_minutes = Main.current_time_in_minutes + minutes;

        if (current_time_in_minutes >= 360 && current_time_in_minutes <= 1080) {
            return false;
        } else {
            return true;
        }
    }

}