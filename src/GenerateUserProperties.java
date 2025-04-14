package src;

import java.util.Random;

public class GenerateUserProperties {
    public static int generateID() {
        Random random = new Random();
        return random.nextInt(1000, 10000);
    }

    public static String generateWorkerType(UserAccount userAccount) {
        if (userAccount.getWorkerHours() > 40) {
            return "Full-Time";
        }

        else {
            return "Part-Time";
        }
    }

    public static int generateSalary(UserAccount userAccount) {
        return userAccount.getWorkerHours() * 15;
    }
}
