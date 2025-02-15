import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {     
        String headerSymbol = "-".repeat(10);   
        System.out.println(headerSymbol + " Bank Account " + headerSymbol);

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        
        ConsoleAccount account = new ConsoleAccount();
        System.out.print("Please inform the account number: ");
        account.setAccountNumber(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Please inform the agency code: ");
        account.setAgencyCode(scanner.nextLine());
        System.out.print("Please inform the client's name: ");
        account.setClientName(scanner.nextLine());
        System.out.print("Please inform the account balance: ");
        account.setBalance(scanner.nextDouble());

        String message = "\nHello " + account.getClientName() +
            ", thank you for creating an account in our bank. " +
            "Your agency is "+ account.getAgencyCode() +
            ", account "+ account.getAccountNumber() + 
            " and your balance "+ account.getBalance() +
            " is already available for withdrawal.";
        System.out.println(message);
        scanner.close();
    }
}
