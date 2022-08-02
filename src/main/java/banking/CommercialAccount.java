package banking;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Account implementation for commercial (business) customers.
 * The account's holder is a {@link Company}.
 */
public class CommercialAccount extends Account {
    private final List<Person> authorizedUsers;

    public CommercialAccount(final Company company, final Long accountNumber, final int pin, final double startingDeposit) {
        super(company, accountNumber, pin, startingDeposit);
        authorizedUsers = new LinkedList<>();
    }

    /**
     * Add person to list of authorized users.
     *
     * @param person The authorized user to be added to the account.
     */
    protected void addAuthorizedUser(final Person person) {
        authorizedUsers.add(person);
    }

    /**
     * Verify if the person is part of the list of authorized users for this account.
     *
     * @param person the person to verify
     * @return <code>true</code> if person matches an authorized user in {@link #authorizedUsers}; <code>false</code> otherwise.
     */
    public boolean isAuthorizedUser(final Person person) {
        if (Objects.nonNull(person)) {
            return authorizedUsers.stream().anyMatch(
                    it -> it.getIdNumber() == person.getIdNumber() && it.getFirstName().equals(person.getFirstName())
                          && it.getLastName().equals(person.getLastName()));
        }
        return false;
    }
}
