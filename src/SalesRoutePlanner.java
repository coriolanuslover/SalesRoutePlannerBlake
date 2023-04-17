// TODO: Truncate doubles to 2 decimal places, Exceptions for non-integers/characters for int inputs, Exceptions for characters in double inputs, Finish array input problem
import java.util.Scanner;
public class SalesRoutePlanner {
    public static void main(String[] args) {
        int [] [] distanceArray = {
                {0, 90, 76, 171, 136, 132, 89, 99, 172, 158}, // 1 Allendale
                {90, 0, 112, 97, 110, 162, 77, 174, 234, 201}, // 2 Charleston
                {76, 112, 0, 130, 80, 61, 63, 76, 121, 93}, // 3 Columbia
                {171, 97, 130, 0, 56, 132, 82, 203, 248, 209}, // 4 Conway
                {136, 110, 80, 56, 0, 76, 44, 157, 202, 153}, // 5 Florence
                {132, 162, 61, 132, 76, 0, 87, 125, 128, 77}, // 6 Lancaster
                {89, 77, 63, 82, 44, 87, 0, 139, 184, 152}, // 7 Manning
                {99, 174, 76, 203, 157, 125, 139, 0, 83, 87}, // 8 McCormick
                {172, 234, 121, 248, 202, 128, 184, 83, 0, 51}, // 9 Pickens
                {158, 201, 93, 209, 153, 77, 152, 87, 51, 0} // 10 Spartanburg
        };
        Scanner input = new Scanner(System.in);
        System.out.println("Enter route waypoints by number: ");
        System.out.println("Enter vehicle MPG: ");
        System.out.println("Enter average fuel cost/gal: ");
        System.out.println("Enter average highway speed: ");
        String Waypoints = input.nextLine();
        double MPG = input.nextDouble();
        double avgFuelCostPerGal = input.nextDouble();
        double avgHighwaySpeed = input.nextDouble();
        int distFinal = 0;
        for(int i = 1; i < Waypoints.length(); i++ ) {
            int distRow = (Waypoints.charAt(i - 1) - '0');
            int distCol = (Waypoints.charAt(i) - '0');
            int distSum = distanceArray[distRow][distCol];
            distFinal += distSum;
        }
        double fuelNeeded = distFinal / MPG;
        double fuelCost = fuelNeeded * avgFuelCostPerGal;
        double drivingTimeHours = distFinal / avgHighwaySpeed;
        int drivingTimeMinutes = (int) (drivingTimeHours * 60) % 60;
        int drivingTimeHoursInt = (int) drivingTimeHours;
        System.out.println("Total route distance: " + distFinal + " miles");
        System.out.println("Anticipated gallons of fuel needed: " + fuelNeeded + " gallons");
        System.out.println("Anticipated cost of fuel: " + "$" + fuelCost);
        System.out.println("Estimated driving time at " + avgHighwaySpeed + " MPH: " + drivingTimeHoursInt + " Hours " + drivingTimeMinutes + " Minutes");
    }
}
