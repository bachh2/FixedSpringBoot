package vn.techmaster.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.techmaster.exam.model.Question9;

@Repository
public interface question9 extends JpaRepository<Question9, Long> {
    
}
