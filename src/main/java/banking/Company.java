package banking;

public class Company extends AccountHolder {
	private String companyName;

	public Company(final String companyName, final int taxId) {
		super(taxId);
		this.companyName = companyName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(final String companyName) {
		this.companyName = companyName;
	}
}
