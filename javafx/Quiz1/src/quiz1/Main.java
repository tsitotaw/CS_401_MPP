package quiz1;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Peter");

        customer.addOrder(LocalDate.of(2010,10,10));
        customer.addOrder(LocalDate.of(2011,10, 10));
        customer.addOrder(LocalDate.of(2012,10, 10));

        System.out.println(customer);
    }
}
