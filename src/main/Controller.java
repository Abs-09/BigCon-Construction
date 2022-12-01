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
        } else if (!islands.currentIsland.isDieselAmountRemainingInTank(input)) {
            System.out.println("space for requested amount not available");
        } else {
            islands.currentIsland.removeDiesel(input);
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
        } else if (!islands.currentIsland.isDieselAmountRemainingInTank(input)) {
            System.out.println("Requested amount not available in tank");
        } else {
            islands.currentIsland.removeDiesel(input);
            dhoani.addDiesel(input);
        }
    }

    // DHOANI --> ISLAND
    public void addDieselToIslandFromDhoani(double input) {
        if (isDayTime()) {
            System.out.println("Currently day time. Can only be load/unloaded at night");
        } else if (!islands.currentIsland.isDieselSpaceAvailable(input)) {
            System.out.println("Space not available for the requested amount");
        } else if (!dhoani.isDieselAmountRemainingInTank(input)) {
            System.out.println("Requested amount not available in tank");
        } else {
            islands.currentIsland.addDiesel(input);
            dhoani.removeDiesel(input);
        }
    }

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
        } else if (dhoani.isDieselAmountRemainingInTank(input)) {
            System.out.println("Currently day time. Can only be load/unloaded at night");
        } else {
            dhoani.removeDiesel(input);
        }
    }

    // TRAVEL FUNCTIONS
    public void travelToEastIsland() {
        
        if (!isDayTime()) {
            System.out.println("Currently " + Main.current_time + ", Dhoani can travel between 6am to 6pm");
        } else if(islands.currentIsland.next == null){
            System.out.println("Cannnot travel further east");
        } else if(islands.currentIsland.next.isAnySpaceAvailable()) {
            System.out.println("No Space available at next island");
        } else {
            SkipHours(islands.moveEast());
        }

    }

    public void travelToWestIsland() {

        if (!isDayTime()) {
            System.out.println("Currently " + Main.current_time + ", Dhoani can travel between 6am to 6pm");
        } else if(islands.currentIsland.prev == null){
            System.out.println("No");
        } else if(islands.currentIsland.prev.isAnySpaceAvailable()) {
            System.out.println("No Space available at next island");
        } else {
            SkipHours(islands.moveWest());
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
        System.out.println("Current Time: " + Main.current_time);
    }

    public boolean isDayTime() {
        if (Main.current_time >= 6 && Main.current_time <= 18) {
            return true;
        } else {
            return false;
        }
    }

    public void SkipHours(int hours) {
        Main.current_time = (Main.current_time + hours) % 24;
    }

}