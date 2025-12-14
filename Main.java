import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<String, Object> applicant = new HashMap<>();

        System.out.println("===== Loan Application Fraud Detection System =====");

        // ---------- Identity & Network Inputs ----------
        System.out.print("Enter PAN number: ");
        String pan = sc.next();

        System.out.print("Enter IP address: ");
        String ip = sc.next();

        // ---------- Business Inputs ----------
        System.out.print("Enter annual income: ");
        applicant.put("income", sc.nextDouble());

        System.out.print("Enter loan amount requested: ");
        applicant.put("loanAmount", sc.nextDouble());

        sc.nextLine(); // clear buffer

        System.out.print("Enter employment status (Employed/Unemployed): ");
        applicant.put("employmentStatus", sc.nextLine());

        System.out.print("Enter credit score: ");
        applicant.put("creditScore", sc.nextInt());

        System.out.print("Is salary document verified? (true/false): ");
        applicant.put("salaryVerified", sc.nextBoolean());

        System.out.print("Enter number of active loans: ");
        applicant.put("activeLoans", sc.nextInt());

        // ---------- Evaluation ----------
        System.out.println("\n--- Running Fraud Detection Checks ---");

        int businessRisk =
                BusinessRuleEvaluator.evaluateRules(applicant);

        int identityIpRisk =
                IdentityIPChecker.checkIdentityAndIP(pan, ip);

        int totalRiskScore = businessRisk + identityIpRisk;

        int fraudProbability =
                FraudProbabilityCalculator.calculateProbability(totalRiskScore);

        String riskLevel =
                FraudProbabilityCalculator.getRiskLevel(fraudProbability);

        // ---------- Final Output ----------
        System.out.println("\n--------------------------------------");
        System.out.println("Total Risk Score      : " + totalRiskScore);
        System.out.println("Fraud Probability     : " + fraudProbability + "%");
        System.out.println("Overall Risk Level    : " + riskLevel);

        if (riskLevel.equals("HIGH")) {
            System.out.println("❌ APPLICATION FLAGGED AS FRAUD");
        } else if (riskLevel.equals("MEDIUM")) {
            System.out.println("⚠ APPLICATION SENT FOR MANUAL REVIEW");
        } else {
            System.out.println("✅ APPLICATION APPROVED");
        }

        System.out.println("--------------------------------------");

        sc.close();
    }
}
