import java.util.HashMap;

public class IdentityIPChecker {

    private static HashMap<String, Integer> panStore = new HashMap<>();
    private static HashMap<String, Integer> ipStore = new HashMap<>();

    public static boolean detectDuplicatePAN(String pan) {
        panStore.put(pan, panStore.getOrDefault(pan, 0) + 1);
        return panStore.get(pan) > 1;
    }

    public static boolean detectIPAbuse(String ip) {
        ipStore.put(ip, ipStore.getOrDefault(ip, 0) + 1);
        return ipStore.get(ip) > 3;
    }
}
