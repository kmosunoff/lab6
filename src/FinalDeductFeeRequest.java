public class FinalDeductFeeRequest extends Request {

    public FinalDeductFeeRequest(CreditAccount bankAccount) {
        super(bankAccount);
    }

    @Override
    public void run() {
        ((CreditAccount) this.bankAccount).deductFee();
    }
}
