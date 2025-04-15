package src;

import java.util.Random;

public class GenerateUserProperties {
    public static int generateID() {
        Random random = new Random();
        return random.nextInt(1000, 10000);
    }

    public static char generateWorkerType(int workerHours) {
        if (workerHours > 40) {
            return 'F';
        }

        else {
            return 'P';
        }
    }

    public static int generateSalary(int workerHours) {
        return workerHours * 15;
    }
}
