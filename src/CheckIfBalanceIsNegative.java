import java.math.BigDecimal;

public class CheckIfBalanceIsNegative extends Request {

    public CheckIfBalanceIsNegative(CreditAccount bankAccount) throws RequestException {
        super(bankAccount);
        if (bankAccount.getBalance().compareTo(BigDecimal.valueOf(0)) < 0) {
            setNextRequest(new FinalDeductFeeRequest(bankAccount));
        }
        else {
            throw new RequestException();
        }
    }
}
