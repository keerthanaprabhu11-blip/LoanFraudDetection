import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== Loan Application System =====");

        System.out.print("Applicant Name: ");
        String name = sc.nextLine();

        System.out.print("PAN Number: ");
        String pan = sc.nextLine();

        System.out.print("IP Address: ");
        String ip = sc.nextLine();

        System.out.print("Monthly Income: ");
        double monthlyIncome = sc.nextDouble();

        System.out.print("Yearly Income: ");
        double yearlyIncome = sc.nextDouble();

        System.out.print("Loan Amount: ");
        double loanAmount = sc.nextDouble();
        System.out.print("Employment Duration (years): ");
        int employmentYears = sc.nextInt();

        // Internal fraud detection (hidden from user)
        boolean duplicatePAN = IdentityIPChecker.detectDuplicatePAN(pan);
        boolean ipAbuse = IdentityIPChecker.detectIPAbuse(ip);

        List<String> violations = BusinessRuleEvaluator.evaluate(
                monthlyIncome, yearlyIncome, loanAmount, employmentYears
        );

        int riskScore = FraudProbabilityCalculator.calculateRiskScore(
                duplicatePAN, ipAbuse, violations
        );

        double probability = FraudProbabilityCalculator.fraudProbability(riskScore);
        String level = FraudProbabilityCalculator.riskLevel(riskScore);
        double impact = FraudProbabilityCalculator.financialImpact(loanAmount, riskScore);

        System.out.println("\n====== FRAUD ANALYSIS REPORT ======");
        System.out.println("Applicant: " + name);
        System.out.println("Risk Score: " + riskScore + "/100");
        System.out.println("Fraud Probability: " + probability + "%");
        System.out.println("Risk Level: " + level);
        System.out.println("Estimated Financial Impact: ₹" + impact);

        if (!violations.isEmpty()) {
            System.out.println("\nTriggered Risk Indicators:");
             for (String v : violations) {
                System.out.println("- " + v);
            }
        } else {
            System.out.println("\nNo risk indicators detected.");
        }

        System.out.println("=================================");
        sc.close();
    }
}

