import java.math.BigDecimal;

public abstract class BankAccount implements BankAccountInterface {
    protected BankClient bankClient;
    protected BankAccountType bankAccountType;
    protected BigDecimal balance = BigDecimal.valueOf(0);;
    protected  boolean isSuspicious = false;

    public BankAccount() { }

    public BankAccount(BankClient bankClient) {
        this.bankClient = bankClient;
    }

    @Override
    public BankClient getOwner() {
        return bankClient;
    }

    public BankAccountType getBankAccountType() {
        return bankAccountType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    abstract boolean canWithdraw(BigDecimal value);

    @Override
    public void withdraw(BigDecimal value) throws WithdrawException {
        if (canWithdraw(value)) {
            balance = balance.subtract(value);
        }
        else {
            throw new WithdrawException("Could not withdraw " + this + " with " + value);
        }
    }

    @Override
    public void replenish(BigDecimal value) {
        balance = balance.add(value);
    }

    @Override
    public void transact(BankAccountInterface bankAccount, BigDecimal value) throws WithdrawException, TransactionException, ReplenishException {
        if (bankClient.equals(bankAccount.getOwner())) {
            this.withdraw(value);
            bankAccount.replenish(value);
        }
        else {
            throw new TransactionException();
        }
    }

    protected void setSuspicious(boolean b) {
        isSuspicious = b;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "bankAccountType=" + bankAccountType +
                ", balance=" + balance +
                ", isSuspicious=" + isSuspicious +
                '}';
    }
}
