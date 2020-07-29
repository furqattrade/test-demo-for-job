package uz.test.javatest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.test.javatest.entity.Customers;

public interface CustomerRepository extends JpaRepository<Customers, Integer> {
}
