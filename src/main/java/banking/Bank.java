package banking;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The Bank implementation.
 */
public class Bank implements BankInterface {
    private final LinkedHashMap<Long, Account> accounts;

    public Bank() {
        accounts = new LinkedHashMap<>();
    }

    private Account getAccount(final Long accountNumber) {
        return accounts.get(accountNumber);
    }

    @Override
    public Long openCommercialAccount(final Company company, final int pin, final double startingDeposit) {
        final long accountNumber = (long) accounts.size() + 1;
        accounts.put(accountNumber, new CommercialAccount(company, accountNumber, pin, startingDeposit));
        return accountNumber;
    }

    @Override
    public Long openConsumerAccount(final Person person, final int pin, final double startingDeposit) {
        final long accountNumber = (long) accounts.size() + 1;
        accounts.put(accountNumber, new ConsumerAccount(person, accountNumber, pin, startingDeposit));
        return accountNumber;
    }

    @Override
    public double getBalance(final Long accountNumber) {
        final Account account = getAccount(accountNumber);
        if (Objects.nonNull(account)) {
            return account.getBalance();
        }
        return -1;
    }

    @Override
    public void credit(final Long accountNumber, final double amount) {
        getAccount(accountNumber).creditAccount(amount);
    }

    @Override
    public boolean debit(final Long accountNumber, final double amount) {
        return getAccount(accountNumber).debitAccount(amount);
    }

    @Override
    public boolean authenticateUser(final Long accountNumber, final int pin) {
        return getAccount(accountNumber).validatePin(pin);
    }
    
    @Override
    public void addAuthorizedUser(final Long accountNumber, final Person authorizedPerson) {
        ((CommercialAccount) getAccount(accountNumber)).addAuthorizedUser(authorizedPerson);
    }

    @Override
    public boolean checkAuthorizedUser(final Long accountNumber, final Person authorizedPerson) {
        final Account account = getAccount(accountNumber);
        if (account instanceof CommercialAccount) {
            return ((CommercialAccount) account).isAuthorizedUser(authorizedPerson);
        }
        return false;
    }

    @Override
    public Map<String, Double> getAverageBalanceReport() {
        return accounts.values()
                .stream()
                .collect(Collectors.groupingBy(it -> it.getClass().getSimpleName(), Collectors.averagingDouble(Account::getBalance)));
    }
}
