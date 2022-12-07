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
        final static double DHOANI_SPEED = 25;

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

        public double moveEast(double n) {

                double hoursTaken;
                double totalHoursTaken = 0;

                System.out.println("Moving East");

                for (int i = 0; i < n; i++ ){
                        hoursTaken = currentIsland.distanceToNext / DHOANI_SPEED;
                        currentIsland = currentIsland.next;
                        totalHoursTaken += hoursTaken;
                }
                
                return totalHoursTaken;
        }

        public double moveWest() {
                System.out.println("Moving West");
                double hoursTaken = currentIsland.distanceToPrev / DHOANI_SPEED;
                currentIsland = currentIsland.prev;
                return hoursTaken;
        }

        public double[] validateNextIslandThatCanBeTraveledEast() {
                double counter = 0;
                double hours = 0;
                double minutes = 0;
                double totalTimeInHours = 0;
                double totalTimeInMinutes = 0;

                double[] array = new double[2];

                testIsland = currentIsland;
                // System.out.println(testIsland.next.isAnySpaceAvailable());
                while (testIsland.next != null) {

                        counter++;
                        hours = testIsland.distanceToNext / DHOANI_SPEED; // getting hours by dividing it with dhoani speed
                        minutes = hours * 60;
                        testIsland = testIsland.next;
                        totalTimeInHours = totalTimeInHours + hours;
                        totalTimeInMinutes = totalTimeInMinutes + minutes;
                        if(testIsland.isAnySpaceAvailable()){   
                                break;
                        }
                        
                }

                System.out.println("counter: " + counter);
                System.out.println("Next East Island that can be reached: " + testIsland.name);
                System.out.println("Total time taken to reach Next East Island: " + totalTimeInHours);
                System.out.println("Total time in Minutes to reach Next East Island: " + totalTimeInMinutes);

                array[0] = counter;
                array[1] = totalTimeInMinutes;

                return array;
        }

        // Function to check remaining islands that can be reached during day time and
        // the time taken
        public void checkRemainingIslandsToEastThatCanBeReachedDuringDayTime() {

                double current_time = Main.current_time_in_minutes;
                int counter = 0;
                double hours = 0;
                double minutes = 0;
                double totalTimeInHours = 0;
                double totalTimeInMinutes = 0;

                // The current island object will be put to the test island since no actual
                // value of currentisland should change
                testIsland = currentIsland;

                // The loop is to check if an end island (suppliers island) is reached
                while (testIsland.next != null) {

                        // The if condition checks for day time - when dhoani is allowed to travel
                        if (current_time >= 360 && current_time <= 1080) {

                                counter++; // islland counter
                                hours = testIsland.distanceToNext / DHOANI_SPEED; // getting hours by dividing it with
                                                                                  // dhoani speed
                                minutes = hours * 60;

                                totalTimeInHours = totalTimeInHours + hours;
                                totalTimeInMinutes = totalTimeInMinutes + minutes;

                                testIsland = testIsland.next;
                                current_time += minutes;

                        } else {

                                break;
                        }

                }

                System.out.println("Number of east islands that can be reached during day time: " + counter);
                System.out.println("Furthest East Island that can be traveled during day time: " + testIsland.name);
                System.out.println(
                                "Total time in hours that will take to reach the furthest island: " + totalTimeInHours);
                System.out.println("Total time in Minutes that will take to reach the furthest island: "
                                + totalTimeInMinutes);

        }

        // Function to check remaining islands that can be reached during day time and
        // the time taken
        public void checkRemainingIslandsToWestThatCanBeReachedDuringDayTime() {

                double current_time = Main.current_time_in_minutes;
                int counter = 0;
                double hours = 0;
                double minutes = 0;
                double totalTimeInHours = 0;
                double totalTimeInMinutes = 0;

                // The current island object will be put to the test island since no actual
                // value of currentisland should change
                testIsland = currentIsland;

                // The loop is to check if an end island (suppliers island) is reached
                while (testIsland.prev != null) {

                        // The if condition checks for day time - when dhoani is allowed to travel
                        if (current_time >= 360 && current_time <= 1080) {

                                counter++; // islland counter
                                hours = testIsland.distanceToNext / DHOANI_SPEED; // getting hours by dividing it with
                                                                                  // dhoani speed
                                minutes = hours * 60;

                                totalTimeInHours = totalTimeInHours + hours;
                                totalTimeInMinutes = totalTimeInMinutes + minutes;

                                testIsland = testIsland.prev;
                                current_time += minutes;

                        } else {

                                break;
                        }

                }

                System.out.println("Number of west islands that can be reached during day time: " + counter);
                System.out.println("Furthest West Island that can be traveled during day time: " + testIsland.name);
                System.out.println(
                                "Total time in hours that will take to reach the furthest island: " + totalTimeInHours);
                System.out.println("Total time in Minutes that will take to reach the furthest island: "
                                + totalTimeInMinutes);

        }
}