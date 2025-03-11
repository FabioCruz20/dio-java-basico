import java.util.Scanner;

public class App {

    private static final Scanner scanner = new Scanner(System.in);
    private static BankAccount account;

    public static void main(String[] args) throws Exception {
        
        do {
            System.out.println("=== Escolha uma das opções ===");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Consultar cheque especial");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Pagar boleto");
            System.out.println("6 - Verificar se está usando cheque especial");
            System.out.println("0 - Sair");

            var option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> checkBalance();
                case 2 -> checkOverdraftProtection();
                case 3 -> deposit();
                case 4 -> withdraw();
                case 5 -> payBankSlip();
                case 6 -> checkOverdrawn();
                case 0 -> System.exit(0);
            }
        }
        while (true);
    }

    public static void checkBalance() {
        if (account == null) {
            printAccountCreationMessage();
            return;
        }

        String message = String.format("Saldo: %.2f.", account.getBalance());
        System.out.println(message);
    }

    public static void checkOverdraftProtection() {
        if (account == null) {
            printAccountCreationMessage();
            return;
        }

        String message = String.format("Cheque especial: %.2f.", account.getOverdraftProtection());
        System.out.println(message);
    }

    public static void deposit() {

        System.out.print("Informe o valor do depósito: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if (account == null) {
            account = new BankAccount(amount);
            System.out.println("Conta criada.");
            return;
        }
        
        account.deposit(amount);
    }

    public static void withdraw() {

        if (account == null) {
            printAccountCreationMessage();
            return;
        }

        System.out.print("Informe o valor do saque: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        account.withdraw(amount);        
    }

    public static void payBankSlip() {

        if (account == null) {
            printAccountCreationMessage();
            return;
        }

        System.out.print("Informe o código do boleto: ");
        String code = scanner.nextLine();
        System.out.print("Informe o valor do boleto: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        account.payBankSlip(code, amount);
    }

    public static void checkOverdrawn() {

        if (account == null) {
            printAccountCreationMessage();
            return;
        }

        String message = account.getBalance() >= 0 ? 
            "Não está no cheque especial." :
            "Está no cheque especial.";

        message += String.format(
            " Saldo: %.2f. Cheque especial: %.2f.",
            account.getBalance(),
            account.getOverdraftProtection()
        );
            
        System.out.println(message);
    }

    private static void printAccountCreationMessage() {
        System.out.println("É necessário criar uma conta antes. Selecione a opção depositar para criar a conta.");
    }
}
