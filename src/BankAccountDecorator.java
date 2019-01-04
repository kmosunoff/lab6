import java.math.BigDecimal;

public class BankAccountDecorator implements BankAccountInterface {
    private BankAccount wrappee;
    private BigDecimal limit;

    public BankAccountDecorator(BankAccount wrappee, BigDecimal limit) {
        this.wrappee = wrappee;
        wrappee.setSuspicious(true);
        this.limit = limit;
    }

    @Override
    public BankClient getOwner() {
        return wrappee.getOwner();
    }

    @Override
    public BigDecimal getBalance() {
        return wrappee.getBalance();
    }

    @Override
    public BankAccountType getBankAccountType() {
        return wrappee.getBankAccountType();
    }

    @Override
    public boolean canWithdraw(BigDecimal value) {
        return value.compareTo(limit) <= 0;
    }

    @Override
    public void withdraw(BigDecimal value) throws WithdrawException {
        if (canWithdraw(value)) {
            wrappee.withdraw(value);
        }
        else {
            throw new WithdrawException("Could not withdraw " + wrappee + " with " + value);
        }
    }

    @Override
    public String toString() {
        return wrappee.toString();
    }

    @Override
    public void replenish(BigDecimal value) throws ReplenishException {
        if (value.compareTo(limit) <= 0) {
            wrappee.replenish(value);
        }
        else {
            throw new ReplenishException("Could not replenish " + wrappee + " with " + value);
        }
    }

    @Override
    public void transact(BankAccountInterface bankAccount, BigDecimal value) throws WithdrawException, TransactionException, ReplenishException {
        wrappee.transact(bankAccount, value);
    }
}
