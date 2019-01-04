import java.math.BigDecimal;
import java.util.Date;

public class AccountsFactory {
    private BigDecimal fee;
    private BigDecimal percent;
    private BigDecimal creditLimit;
    private BigDecimal limit;
    private static AccountsFactory instance;

    public AccountsFactory(BigDecimal fee, BigDecimal percent, BigDecimal creditLimit, BigDecimal limit) {
        this.fee = fee;
        this.percent = percent;
        this.creditLimit = creditLimit;
        this.limit = limit;
    }

    public static AccountsFactory getInstance(BigDecimal fee, BigDecimal percent, BigDecimal creditLimit, BigDecimal limit) {
        if (instance == null) {
            instance = new AccountsFactory(fee, percent, creditLimit, limit);
        }
        return instance;
    }

    public BankAccountInterface getNewBankAccount(BankClient bankClient, BankAccountType bankAccountType) throws BankAccountTypeException {
        BankAccountInterface response;
        switch (bankAccountType) {
            case CURRENT: { response = new CurrentAccount(bankClient, percent); break; }
            case DEPOSIT: { response = new DepositAccount(bankClient, BigDecimal.valueOf(0), new Date(), new Date(), percent); break; }
            case CREDIT: { response = new CreditAccount(bankClient, creditLimit, fee); break; }
            default: throw new BankAccountTypeException();
        }
        if (!bankClient.isReliable()) {
            response = decorateAccount((BankAccount) response);
        }
        bankClient.addBankAccount(response);
        return response;
    }

    public BankAccountDecorator decorateAccount(BankAccount bankAccount) {
        return new BankAccountDecorator(bankAccount, limit);
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public void setPercent(BigDecimal percent) {
        this.percent = percent;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }
}
