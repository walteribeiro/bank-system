package banking;

/**
 * Abstract Account Holder.
 */
public abstract class AccountHolder {
    private int idNumber;

    protected AccountHolder(final int idNumber) {
        this.idNumber = idNumber;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(final int idNumber) {
        this.idNumber = idNumber;
    }
}
