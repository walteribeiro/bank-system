package banking;

/**
 * Abstract bank account.
 */
public abstract class Account implements AccountInterface {
    private final AccountHolder accountHolder;
    private final Long accountNumber;
    private final int pin;
    private double balance;

    protected Account(final AccountHolder accountHolder, final Long accountNumber, final int pin, final double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public AccountHolder getAccountHolder() {
        return accountHolder;
    }

    @Override
    public boolean validatePin(final int attemptedPin) {
        return pin == attemptedPin;
    }

    public double getBalance() {
        return balance;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    @Override
    public void creditAccount(final double amount) {
        balance += amount;
    }

    @Override
    public boolean debitAccount(final double amount) {
        boolean result = false;
        if (balance >= amount) {
            balance -= amount;
            result = true;
        }

        return result;
    }
}
