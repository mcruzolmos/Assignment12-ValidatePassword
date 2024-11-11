import java.util.Scanner;

public class App {

    // Method to validate the password
    public static boolean isValidPassword(String password) {
        // Check if the password length is between 8 and 16
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }

        // Counters to track the categories
        int categoryCount = 0;

        // Check for each category
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        // Define the regular expressions for each category
        String lowerCasePattern = ".*[a-z].*";
        String upperCasePattern = ".*[A-Z].*";
        String digitPattern = ".*[0-9].*";
        String specialPattern = ".*[~!@#$%^&*()\\-=+_].*";

        // Check if the password contains characters from each category
        if (password.matches(lowerCasePattern)) hasLower = true;
        if (password.matches(upperCasePattern)) hasUpper = true;
        if (password.matches(digitPattern)) hasDigit = true;
        if (password.matches(specialPattern)) hasSpecial = true;

        // Count how many categories are satisfied
        if (hasLower) categoryCount++;
        if (hasUpper) categoryCount++;
        if (hasDigit) categoryCount++;
        if (hasSpecial) categoryCount++;

        // The password is valid if at least three categories are satisfied
        return categoryCount >= 3;
    }

    public static void main(String[] args) {
        // Create a scanner to take user input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter their password
        System.out.print("Enter your password to check if it fits the requirements: ");
        String userPassword = scanner.nextLine();
        
        // Validate the password and give feedback
        if (isValidPassword(userPassword)) {
            System.out.println("Your password is valid!");
        } else {
            System.out.println("Your password is invalid. It must meet the following criteria:");
            System.out.println("1. The length should be between 8 and 16 characters.");
            System.out.println("2. It must contain at least three of the following categories:");
            System.out.println("   - Lowercase letters (a-z)");
            System.out.println("   - Uppercase letters (A-Z)");
            System.out.println("   - Numbers (0-9)");
            System.out.println("   - Special symbols (~!@#$%^&*()-=+_)");
        }

        // Close the scanner to avoid resource leak
        scanner.close();
    }
}

