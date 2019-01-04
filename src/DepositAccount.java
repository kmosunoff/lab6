import java.math.BigDecimal;
import java.util.Date;

public class DepositAccount extends BankAccount {
    private Date startDate;
    private Date endDate;
    private BigDecimal percent;

    public DepositAccount(BankClient bankClient, BigDecimal startBalance, Date startDate, Date endDate, BigDecimal percent) {
        super(bankClient);
        this.balance = startBalance;
        this.bankAccountType = BankAccountType.DEPOSIT;
        this.startDate = startDate;
        this.endDate = endDate;
        this.percent = percent;
    }

    @Override
    public boolean canWithdraw(BigDecimal value) {
        return endDate.before(new Date());
    }

    public void accrue() {
        if (endDate.equals(new Date())) {
            this.replenish(balance.multiply(percent.divide(BigDecimal.valueOf(100))));
        }
    }
}
