public abstract class Request {
    private Request nextRequest;
    protected BankAccountInterface bankAccount;

    public Request(BankAccountInterface bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void run() {
        if (nextRequest != null) {
            nextRequest.run();
        }
    }

    public void setNextRequest(Request nextRequest) {
        this.nextRequest = nextRequest;
    }
}
