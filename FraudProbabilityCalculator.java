public class FraudProbabilityCalculator {

    public static int calculateProbability(int riskScore) {

        if (riskScore > 100) {
            return 100;
        }
        return riskScore;
    }

    public static String getRiskLevel(int probability) {

        if (probability >= 71) {
            return "HIGH";
        } else if (probability >= 31) {
            return "MEDIUM";
        } else {
            return "LOW";
        }
    }
}
