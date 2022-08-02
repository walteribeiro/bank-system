package banking;

/**
 * A bank transaction implementation.
 */
public class Transaction implements TransactionInterface {
    private final Long accountNumber;
    private final BankInterface bank;

    /**
     * @param bank          The bank where the account is housed.
     * @param accountNumber The customer's account number.
     * @param attemptedPin  The PIN entered by the customer.
     * @throws Exception Account validation failed.
     */
    public Transaction(final BankInterface bank, final Long accountNumber, final int attemptedPin) throws Exception {
        this.accountNumber = accountNumber;
        this.bank = bank;

        if (!bank.authenticateUser(accountNumber, attemptedPin)) {
            throw new Exception("Attempt to access an account with an invalid PIN");
        }
    }

    @Override
    public double getBalance() {
        return bank.getBalance(accountNumber);
    }

    @Override
    public void credit(final double amount) {
        bank.credit(accountNumber, amount);
    }

    @Override
    public boolean debit(final double amount) {
        return bank.debit(accountNumber, amount);
    }
}
