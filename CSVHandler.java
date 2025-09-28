import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CSVHandler {
    private static final String FILE_NAME = "expenses.csv";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    // Clear CSV at start
    public static void startNewCSV() {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            writer.write("Date & Time,Category,Amount\n"); // header
        } catch (IOException e) {
            System.out.println("Error initializing CSV: " + e.getMessage());
        }
    }

    public static void saveExpense(String category, double amount) {
        LocalDateTime now = LocalDateTime.now();
        String timestamp = now.format(formatter);

        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.append(timestamp)
                  .append(",")
                  .append(category)
                  .append(",\u20B9")
                  .append(String.valueOf(amount))
                  .append("\n");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
