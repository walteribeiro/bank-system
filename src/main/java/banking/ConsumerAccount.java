package banking;

/**
 * Account implementation for consumer (domestic) customers.
 * The account's holder is a {@link Person}.
 */
public class ConsumerAccount extends Account {

    public ConsumerAccount(final Person person, final Long accountNumber, final int pin, final double currentBalance) {
        super(person, accountNumber, pin, currentBalance);
    }
}
