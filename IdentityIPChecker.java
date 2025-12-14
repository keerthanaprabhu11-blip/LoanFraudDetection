import java.util.HashMap;

public class IdentityIPChecker {

    private static HashMap<String, Integer> panUsage = new HashMap<>();
    private static HashMap<String, Integer> ipUsage = new HashMap<>();

    public static int checkIdentityAndIP(String pan, String ip) {

        int risk = 0;

        panUsage.put(pan, panUsage.getOrDefault(pan, 0) + 1);
        ipUsage.put(ip, ipUsage.getOrDefault(ip, 0) + 1);

        if (panUsage.get(pan) > 2) {
            System.out.println("⚠ Duplicate PAN usage detected");
            risk += 30;
        }

        if (ipUsage.get(ip) > 3) {
            System.out.println("⚠ Multiple applications from same IP");
            risk += 20;
        }

        return risk;
    }
}
