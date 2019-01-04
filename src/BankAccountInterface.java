import java.math.BigDecimal;

public interface BankAccountInterface {
    BigDecimal getBalance();
    BankAccountType getBankAccountType();
    void withdraw(BigDecimal value) throws WithdrawException;
    void replenish(BigDecimal value) throws ReplenishException;
    void transact(BankAccountInterface bankAccount, BigDecimal value) throws WithdrawException, TransactionException, ReplenishException;

    BankClient getOwner();
}
