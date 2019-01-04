import java.beans.beancontext.BeanContext;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws BankClientBuildException, BankAccountTypeException, RequestException, WithdrawException, TransactionException, ReplenishException {
        Address address = Address.builder()
                .withStreet("Street")
                .withHouseNumber(42)
                .withFlat(12)
                .build();
        System.out.println(address);
        BankClient bankClient0 = BankClient.builder()
                .withAddress(address)
                .withFirstName("firstName")
                .withLastName("lastName")
                .withPassport(12345678)
                .build();
        BankClient bankClient1 = BankClient.builder()
                .withFirstName("Имя")
                .withLastName("Фамилия")
                .withPassport(12345678)
                .build();
        AccountsFactory accountsFactory = AccountsFactory.getInstance(BigDecimal.valueOf(10),
                BigDecimal.valueOf(5),
                BigDecimal.valueOf(100),
                BigDecimal.valueOf(10));
        accountsFactory.setCreditLimit(BigDecimal.valueOf(100));
        accountsFactory.setFee(BigDecimal.valueOf(10));
        BankAccountInterface bankAccount00 = accountsFactory.getNewBankAccount(bankClient0, BankAccountType.CREDIT);
        BankAccountInterface bankAccount01 = accountsFactory.getNewBankAccount(bankClient0, BankAccountType.CURRENT);
        BankAccountInterface bankAccount10 = accountsFactory.getNewBankAccount(bankClient1, BankAccountType.CURRENT);
        bankAccount00.replenish(BigDecimal.valueOf(100));
        bankAccount01.replenish(BigDecimal.valueOf(100));
        bankAccount10.replenish(BigDecimal.valueOf(10));
        bankAccount00.withdraw(BigDecimal.valueOf(120));
        bankAccount01.withdraw(BigDecimal.valueOf(100));
        bankAccount10.withdraw(BigDecimal.valueOf(10));
        System.out.println(bankAccount00);
        System.out.println(bankAccount01);
        System.out.println(bankAccount10);
//        bankAccount00.withdraw(BigDecimal.valueOf(10));
//        Request request = new DeductFeeRequest(bankAccount00);
//        request.run();
//        System.out.println(bankAccount00.getBalance());
//        bankAccount01.replenish(BigDecimal.valueOf(10));
//        bankAccount01.transact(bankAccount00, BigDecimal.valueOf(5));
//        System.out.println(bankAccount00.getBalance());
//        System.out.println(bankAccount00.getOwner());
    }
}
