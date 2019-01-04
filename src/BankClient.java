import javax.swing.plaf.BorderUIResource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BankClient {
    private Address address;
    private String firstName;
    private String middleName;
    private String lastName;
    private Integer passportNumber;
    private List<BankAccountInterface> bankAccounts = new ArrayList<>();

    public BankClient(Address address, String firstName, String middleName, String lastName) {
        this.address = address;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getPassportNumber() {
        return passportNumber;
    }

    public void addBankAccount(BankAccountInterface bankAccount) {
        bankAccounts.add(bankAccount);
    }

    public BankAccountInterface getBankAccount(Integer i) {
        return bankAccounts.get(i);
    }

    @Override
    public String toString() {
        return "BankClient{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        BankClient that = (BankClient) object;
        return Objects.equals(address, that.address) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(middleName, that.middleName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(passportNumber, that.passportNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, firstName, middleName, lastName, passportNumber);
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean isReliable() {
        return address != null || passportNumber != null;
    }

    public static class Builder {
        private Address address;
        private String firstName;
        private String middleName;
        private String lastName;
        private Integer passport;

        public Builder() {
        }

        public Builder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withPassport(Integer passport) {
            this.passport = passport;
            return this;
        }

        public BankClient build() throws BankClientBuildException {
            if (firstName != null && lastName != null) {
                return new BankClient(address, firstName, middleName, lastName);
            }
            else {
                throw new BankClientBuildException();
            }
        }
    }

}
