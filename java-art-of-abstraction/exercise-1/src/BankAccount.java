public class BankAccount {
    
    private double balance;
    private double overdraftProtection;

    public BankAccount(double balance) {
        this.balance = balance;
        this.overdraftProtection = (balance <= 500) ? 50.0 : balance * 0.5;
    }

    public double getBalance() {
        return balance;
    }

    public double getOverdraftProtection() {
        return overdraftProtection;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println(String.format("Valor deve ser positivo: %.2f", amount));
            return;
        }
        double overdraftTariff = balance >= 0.0 ? 0.0 : (0.2 * -balance);
        this.balance += amount - overdraftTariff;

        String message = String.format(
            "Depósito de %.2f feito. Saldo: %.2f. Taxa do cheque especial: %.2f",
            amount,
            balance,
            overdraftTariff
        );
        System.out.println(message);
    }

    public void withdraw(double amount) {
        boolean success = debt(amount);
        if (!success) {
            return;
        }
        System.out.println(String.format("Saque de %.2f feito. Saldo: %.2f", amount, balance));
    }

    public void payBankSlip(String code, double amount) {
        boolean success = debt(amount);
        if (!success) {
            return;
        }
        String message = String.format(
            "Pagamento de boleto feito. Código: %s. Valor: %.2f. Saldo: %.2f",
            code,
            amount,
            balance
        );
        System.out.println(message);
    }

    public boolean isOverdrawn() {
        return balance < 0;
    }

    private boolean debt(double amount) {
        if (amount <= 0) {
            System.out.println(String.format("Valor deve ser positivo: %.2f", amount));
            return false;
        }

        boolean isAmountOffLimit = amount > balance + overdraftProtection;
        if (isAmountOffLimit) {
            String message = String.format(
                "Transação negada. Valor: %.2f. Saldo: %.2f. Cheque especial: %.2f.",
                amount,
                balance,
                overdraftProtection
            );
            System.out.println(message);
            return false;
        }

        balance -= amount;
        return true;
    }
}
