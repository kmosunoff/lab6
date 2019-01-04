public class DeductFeeRequest extends Request{
    public DeductFeeRequest(BankAccountInterface bankAccount) throws RequestException {
        super(bankAccount);
        setNextRequest(new CheckIfAccountIsCredit(bankAccount));
    }
}
