package src;

import java.util.Random;

public class GenerateUserProperties {

    private static final Random RANDOM = new Random();
    private static final int MIN_ID = 10000;
    private static final int MAX_ID = 99999;
    private static final int HOURLY_WAGE = 15;

    public static int generateID() {
        // Inclusive MIN_ID, inclusive MAX_ID
        return RANDOM.nextInt((MAX_ID - MIN_ID) + 1) + MIN_ID;
    }

    public static char generateWorkerType(int workerHours) {
        // Full-time if hours exceed or equal 40
        return workerHours >= 40 ? 'F' : 'P';
    }

    public static int generateSalary(int workerHours) {
        return workerHours * HOURLY_WAGE;
    }
}
