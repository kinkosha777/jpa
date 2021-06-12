package kg.megacom.jpa;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    List<Customer> findByLastNameAndFirstName(String lastName,String firstName);
    List<Customer> findByLastNameOrFirstName(String lastName,String firstName);
    List<Customer> findByLastNameEquals(String lastName);
    List<Customer> findBySalaryBetween(double salary,double salary1);

    List<Customer> findBySalaryGreaterThan(double salary);
    List<Customer> findBySalaryOrderByFirstNameDesc(double salary);
    List<Customer> findBySalaryGreaterThanOrAgeBefore(double salary,int age);
    List<Customer> findByLastNameEqualsOrAgeAfter(double salary,int age);
    List<Customer> findByFirstNameLikeAndFirstNameNotLike(String name,String name1);
    List<Customer> findByLastNameStartingWithOrFirstNameEndingWith(String start, String endName);
    List<Customer> findByFirstNameIgnoreCase(String firstName);






    Customer findById(long id);
}