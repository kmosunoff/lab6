import java.math.BigDecimal;

public class CurrentAccount extends BankAccount {
    private BigDecimal percent;

    public CurrentAccount(BankClient bankClient, BigDecimal percent) {
        super(bankClient);
        this.percent = percent;
        this.bankAccountType = BankAccountType.CURRENT;
    }

    public BigDecimal getPercent() {
        return percent;
    }

    @Override
    public boolean canWithdraw(BigDecimal value) {
        return balance.compareTo(value) >= 0;
    }
}
