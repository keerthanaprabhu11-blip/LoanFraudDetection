import java.util.List;

public class FraudProbabilityCalculator {

    public static int calculateRiskScore(
            boolean duplicatePAN,
            boolean ipAbuse,
            List<String> ruleViolations
    ) {
        int score = 0;

        if (duplicatePAN) score += 35;
        if (ipAbuse) score += 25;
        if (!ruleViolations.isEmpty()) score += 40;

        return Math.min(score, 100);
    }

    public static double fraudProbability(int riskScore) {
        return Math.min(riskScore * 0.9, 95);
    }

    public static String riskLevel(int score) {
        if (score >= 70) return "HIGH";
        if (score >= 40) return "MEDIUM";
        return "LOW";
    }
