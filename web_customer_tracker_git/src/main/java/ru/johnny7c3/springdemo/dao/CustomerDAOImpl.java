package ru.johnny7c3.springdemo.dao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.johnny7c3.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory factory;
	
	public List<Customer> getCustomers() {
		Session session = factory.getCurrentSession();
		Query<Customer> theQuery = session.createQuery("from Customer order by lastName", Customer.class);
		List<Customer> customers = theQuery.getResultList();
		return customers;
	}

	public void saveCustomer(Customer theCustomer) {
		Session session = factory.getCurrentSession();
	//	session.save(theCustomer);
		session.saveOrUpdate(theCustomer);
	}

	public Customer getCustomer(int theId) {
		Session session = factory.getCurrentSession();
		Customer theCustomer = session.get(Customer.class, theId);
		return theCustomer;
	}

	public void deleteCustomer(int theId) {
		Session session = factory.getCurrentSession();
		Query<?> theQuery = session.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		theQuery.executeUpdate();
	}
}























