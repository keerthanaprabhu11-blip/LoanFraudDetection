import java.util.ArrayList;
import java.util.List;

public class BusinessRuleEvaluator {

    public static List<String> evaluate(
            double monthlyIncome,
            double yearlyIncome,
            double loanAmount,
            int employmentYears
    ) {
        List<String> violations = new ArrayList<>();

        if (Math.abs((monthlyIncome * 12) - yearlyIncome) > 0.2 * yearlyIncome) {
            violations.add("Income inconsistency detected");
        }

        if (loanAmount > monthlyIncome * 20) {
            violations.add("Loan amount exceeds safe income ratio");
        }

        if (employmentYears < 1) {
            violations.add("Employment stability is low");
        }

        return violations;
    }
}
