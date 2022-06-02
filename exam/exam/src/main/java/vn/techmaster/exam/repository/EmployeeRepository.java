package vn.techmaster.exam.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vn.techmaster.exam.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    // o Tìm tất cả các Employee theo emailAddress và lastName
    @Query("select e from Employee e where e.email = ?2 and e.lastname = ?1")    List<Employee> myCustomQuery( String name, String email);
    // public List<Employee> findByLastnameOrEmailaddress(String name, String
    // email);


    // o Tìm tất cả các Employee khác nhau theo firstName hoặc lastName
    @Query("select e from Employee e where e.fullname like '%?1%'")
    List<Employee> myCustomQuery2(String name);
    // public List<Employee> findByLastnameOrFirstname(String name);


    // o Tìm tất cả các Employee theo lastName và sắp xếp thứ tự theo firstName tăng dần
    @Query("select e from Employee e where e.lastname like '%?1%' ORDER BY firstname ASC")
    List<Employee> myCustomQuery3(String name);


    // o Tìm tất cả các Employee theo fistName không phân biệt hoa thường
    @Query("select e from Employee e where lower(e.firstname) like ?1")
    List<Employee> myCustomQuery4(String name);
   
    Pageable sortedById = PageRequest.of(0, 5, Sort.by("id").ascending());
}
