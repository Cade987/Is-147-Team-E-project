/**
 * This is the Generate User Properties class
 * Generates a random id and a user's wage and worker type upon sign up
 */

package src;
import java.util.Random;

public class GenerateUserProperties {

    private static final Random RANDOM = new Random();
    private static final int MIN_ID = 100000;
    private static final int MAX_ID = 999999;
    private static final int HOURLY_WAGE = 15;

    public static int generateID() {
        return RANDOM.nextInt((MAX_ID - MIN_ID) + 1) + MIN_ID;
    }

    public static char generateWorkerType(int workerHours) {
        return workerHours >= 40 ? 'F' : 'P';
    }

    public static int generateSalary(int workerHours) {
        return workerHours * HOURLY_WAGE;
    }


    public static int generateSalary(int workerHours, int customHourlyWage) {
        return workerHours * customHourlyWage;
    }
}
