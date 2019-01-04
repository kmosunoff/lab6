import java.math.BigDecimal;

public class CreditAccount extends BankAccount {
    private BigDecimal creditLimit;
    private BigDecimal fee;

    public CreditAccount(BankClient bankClient, BigDecimal creditLimit, BigDecimal fee) {
        super(bankClient);
        this.bankAccountType = BankAccountType.CREDIT;
        this.creditLimit = creditLimit;
        this.fee = fee;
    }

    @Override
    public boolean canWithdraw(BigDecimal value) {
        return balance.subtract(value).compareTo(creditLimit.negate()) >= 0;
    }

    public void deductFee() {
        balance = balance.subtract(fee);
    }

}
