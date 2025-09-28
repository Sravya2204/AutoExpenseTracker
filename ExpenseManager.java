import java.util.ArrayList;
import java.util.List;

public class ExpenseManager {
    private List<Expense> expenses;

    public ExpenseManager() {
        expenses = new ArrayList<>();
    }

    public void addExpense(String category, double amount) {
        Expense e = new Expense(category, amount);
        expenses.add(e);
        System.out.println("Generated (" + category + "): \u20B9" + amount);
        CSVHandler.saveExpense(category, amount);
    }

    public double printSummary() {
        double travel = 0, shopping = 0, bills = 0, food = 0;
        for (Expense e : expenses) {
            String category = e.getCategory();
            if (category.equals("Travel")) travel += e.getAmount();
            else if (category.equals("Shopping")) shopping += e.getAmount();
            else if (category.equals("Bills")) bills += e.getAmount();
            else if (category.equals("Food")) food += e.getAmount();
        }

        double total = travel + shopping + bills + food;

        System.out.println("\n--- Category Summary ---");
        System.out.println("Travel   : \u20B9" + travel);
        System.out.println("Shopping : \u20B9" + shopping);
        System.out.println("Bills    : \u20B9" + bills);
        System.out.println("Food     : \u20B9" + food);
        System.out.println("Total Expenses Today: \u20B9" + total);

        return total;
    }
}
