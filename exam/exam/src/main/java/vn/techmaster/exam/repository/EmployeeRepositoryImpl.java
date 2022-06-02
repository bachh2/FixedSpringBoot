package vn.techmaster.exam.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {
    @Autowired
    @Lazy
    EmployeeRepository employeeRepository;

    @Override
    public void customMethod() {
        
    }    
    
    
}
