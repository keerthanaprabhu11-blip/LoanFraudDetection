import java.util.HashMap;

public class BusinessRuleEvaluator {

    public static int evaluateRules(HashMap<String, Object> applicant) {

        int riskScore = 0;

        double income = (double) applicant.get("income");
        double loanAmount = (double) applicant.get("loanAmount");
        String employment = (String) applicant.get("employmentStatus");
        int creditScore = (int) applicant.get("creditScore");
        boolean salaryVerified = (boolean) applicant.get("salaryVerified");
        int activeLoans = (int) applicant.get("activeLoans");

        // Income vs Loan Ratio
        if (loanAmount > income * 0.8) {
            System.out.println("⚠ High loan-to-income ratio");
            riskScore += 30;
        }

        // Employment Consistency
        if (employment.equalsIgnoreCase("Unemployed")) {
            System.out.println("⚠ Unemployed applicant");
            riskScore += 25;
        }

        // Suspicious Income Pattern
        if (income < 100000 || income > 5000000) {
            System.out.println("⚠ Suspicious income pattern");
            riskScore += 15;
        }

        // Salary Document Verification
        if (!salaryVerified) {
            System.out.println("⚠ Salary document not verified");
            riskScore += 20;
        }

        // High-risk Financial Behaviour
        if (creditScore < 600 || activeLoans > 3) {
            System.out.println("⚠ High financial risk behavior");
            riskScore += 25;
        }

        return riskScore;
    }
}
