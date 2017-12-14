package pl.waw.sgh.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<Customer> customerList = new ArrayList<>();

    private List<Account> accountList = new ArrayList<>();

    private Integer lastCustomerID = 0;

    private Integer lastAccountID = 0;

    //TODO
    public void transfer(Integer fromAccID, Integer toAccID, double amount) {

    }

    public Customer createCustomer(String firstName,
                                   String lastName, String email) {
        Customer customer =
                new Customer(lastCustomerID++,firstName,lastName,email);
        customerList.add(customer);
        return customer;
    }

    private Account createAccount(Customer customer, boolean isSavings) {
        Account acc =
                (isSavings ?
                        new SavingsAccount(lastAccountID++, 0d, customer)
                        :
                        new DebitAccount(lastAccountID++,0d,customer));
        accountList.add(acc);
        return acc;
    }

    public Account createSavingsAccount(Customer customer) {
        return createAccount(customer, true);
    }

    public Account createDebitAccount(Customer customer) {
        return createAccount(customer, false);
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "custs=\n" + customerList +
                ",\n accs=\n" + accountList +
                '}';
    }
}
