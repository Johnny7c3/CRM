package ru.johnny7c3.springdemo.dao;
import java.util.List;
import ru.johnny7c3.springdemo.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();
	public void saveCustomer(Customer theCustomer);
	public Customer getCustomer(int theId);
	public void deleteCustomer(int theId);
}

























