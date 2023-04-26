// TODO: Low Medium High Critical
//  Medium: Exceptions for non-integers/characters for int inputs
//  Medium: Exceptions for non-integer/charcter/0 for Waypoints inputs
//  Medium: Exceptions for spaces after final inout for Waypoints inputs
//  Medium: Exceptions for characters in double inputs

import java.util.Scanner;
public class SalesRoutePlanner {
    public static void main(String[] args) {
        int [] [] distanceArray = {
                {0,  0,   0,   0,   0,   0,   0,   0,   0,   0,   0}, // Null
                {0,  0,  90,  76, 171, 136, 132,  89,  99, 172, 158}, // 1 Allendale
                {0, 90,   0, 112,  97, 110, 162,  77, 174, 234, 201}, // 2 Charleston
                {0, 76, 112,   0, 130,  80,  61,  63,  76, 121,  93}, // 3 Columbia
                {0,171,  97, 130,   0,  56, 132,  82, 203, 248, 209}, // 4 Conway
                {0,136, 110,  80,  56,   0,  76,  44, 157, 202, 153}, // 5 Florence
                {0,132, 162,  61, 132,  76,   0,  87, 125, 128,  77}, // 6 Lancaster
                {0, 89,  77,  63,  82,  44,  87,   0, 139, 184, 152}, // 7 Manning
                {0, 99, 174,  76, 203, 157, 125, 139,   0,  83,  87}, // 8 McCormick
                {0,172, 234, 121, 248, 202, 128, 184,  83,   0,  51}, // 9 Pickens
                {0,158, 201,  93, 209, 153,  77, 152,  87,  51,   0} // 10 Spartanburg
        };
        Scanner input = new Scanner(System.in);
        System.out.println("Sales Route Planner\n" +
                "\n" +
                "1 Allendale        6 Lancaster\n" +
                "2 Charleston       7 Manning\n" +
                "3 Columbia         8 McCormick\n" +
                "4 Conway           9 Pickens\n" +
                "5 Florence         10 Spartanburg\n");
        System.out.println("Enter route waypoints by number, separated by a space: ");
        String stringWaypoints = input.nextLine();
        // Converts string line w/ spaces to string array
        String[] stringArrayWaypoints = stringWaypoints.split(" ");
        // Converts String array to Int array
        int[] Waypoints = new int[stringArrayWaypoints.length];
        for(int i = 0; i < stringArrayWaypoints.length; i++) {
            Waypoints[i] = Integer.parseInt(stringArrayWaypoints[i]);
        }

        System.out.println("Enter vehicle MPG: ");
        double MPG = input.nextDouble();

        System.out.println("Enter average fuel cost/gal: ");
        double avgFuelCostPerGal = input.nextDouble();

        System.out.println("Enter average highway speed: ");
        double avgHighwaySpeed = input.nextDouble();

        int distFinal = 0;
        // dist(ance)Final acts as running counts as well as final distance total to be used in later calculations
        for(int i = 1; i < Waypoints.length; i++ ) {
            int distRow = (Waypoints[i -1]);
            int distCol = (Waypoints[i]);
            int distSum = distanceArray[distRow][distCol];
            distFinal += distSum;
        }
        // Above function takes coordinates from Waypoints[] and matches them with distanceArray[][] coordinates

        double fuelNeeded = distFinal / MPG;

        double fuelCost = fuelNeeded * avgFuelCostPerGal;

        double drivingTimeRaw = distFinal / avgHighwaySpeed;

        int drivingTimeMinutes = (int) (drivingTimeRaw * 60) % 60;
        int drivingTimeHours = (int) drivingTimeRaw;

        System.out.println("Total route distance: " + distFinal + " miles");
        System.out.println("Anticipated gallons of fuel needed: " + String.format("%.2f", fuelNeeded)  + " gallons");
        System.out.println("Anticipated cost of fuel: " + "$" + String.format("%.2f", fuelCost));
        System.out.println("Estimated driving time at " + String.format("%.0f",avgHighwaySpeed) + " MPH: " + drivingTimeHours + " Hours " + drivingTimeMinutes + " Minutes");
    }
}
