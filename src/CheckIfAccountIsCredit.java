public class CheckIfAccountIsCredit extends Request {

    public CheckIfAccountIsCredit(BankAccountInterface bankAccount) throws RequestException {
        super(bankAccount);
        if (bankAccount.getBankAccountType().equals(BankAccountType.CREDIT)) {
            setNextRequest(new CheckIfBalanceIsNegative((CreditAccount) bankAccount));
        }
        else {
            throw new RequestException();
        }
    }
}
