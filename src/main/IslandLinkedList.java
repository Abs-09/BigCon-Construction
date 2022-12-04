package src.main;

public class IslandLinkedList {

        Island islandSupply1;
        Island islandA;
        Island islandB;
        Island islandC;
        Island islandD;
        Island islandSupply2;
        Island currentIsland; // pointer
        Island testIsland;

        // Constructor
        public IslandLinkedList() {

                // CREATING NEW ISLAND
                this.islandSupply1 = new Island("Island Supplier 1", 0, 50, 50, 1000, 1000, 1000,
                                1000, 1000, 100, 1000, 1000, 1000, 1000);
                this.islandA = new Island("Island A", 50, 80, 0, 0, 0, 0, 0, 0, 4, 0.04, 0.05, 0.1, 10);
                this.islandB = new Island("Island B", 80, 60, 4, 0.04, 0.05, 0.09, 11, 1000,
                                4, 0.04, 0.05, 0.09, 11);
                this.islandC = new Island("Island C", 60, 40, 0, 0, 0, 0, 0, 0, 4, 0.04, 0.05, 0.11, 9);
                this.islandD = new Island("Island D", 40, 70, 0, 0, 0, 0, 0, 0, 4, 0.04, 0.05, 0.08, 9);
                this.islandSupply2 = new Island("Island Supplier 2", 70, 0, 50, 1000, 1000, 1000, 1000, 1000, 100, 1000,
                                1000, 1000, 1000);

                // ASSIGNING ISLAND PATHS (ie: linkin the next and prev nodes)
                // islandSupply1
                this.islandSupply1.prev = null;
                this.islandSupply1.next = this.islandA;
                // islandA
                this.islandA.prev = this.islandSupply1;
                this.islandA.next = this.islandB;
                // islandB
                this.islandB.prev = this.islandA;
                this.islandB.next = this.islandC;
                // islandC
                this.islandC.prev = this.islandB;
                this.islandC.next = this.islandD;
                // islandD
                this.islandD.prev = this.islandC;
                this.islandD.next = this.islandSupply2;
                // islandSupply2
                this.islandSupply2.prev = this.islandD;
                this.islandSupply2.next = null;

                // intializing pointer
                this.currentIsland = this.islandSupply1;
        }

        public double moveEast() {
                System.out.println("Moving East");
                double hoursTaken = currentIsland.distanceToNext / 25;
                currentIsland = currentIsland.next;
                return hoursTaken;
        }

        public double moveWest() {
                System.out.println("Moving West");
                double hoursTaken = currentIsland.distanceToPrev / 25;
                currentIsland = currentIsland.prev;
                return hoursTaken;
        }

        public void test() {

                int counter = 0;
                int hours = 0;
                int totalTime = 0;
                testIsland = currentIsland;

                while (testIsland.next != null) {

                        if (Main.current_time >= 6 && Main.current_time <= 18) {
                                counter++;
                                hours = testIsland.distanceToNext / 25;
                                totalTime = totalTime + hours;
                                testIsland = testIsland.next;
                        } else {
                                System.out.println("Currently night time");
                                break;
                        }
                }

                System.out.println("Number of islands ahead: " + counter);
                System.out.println("Furthest Island that can be traveled during day time: " + testIsland.name);
                System.out.println("Total time that will take to reach the furthest island" + totalTime);

        }
}