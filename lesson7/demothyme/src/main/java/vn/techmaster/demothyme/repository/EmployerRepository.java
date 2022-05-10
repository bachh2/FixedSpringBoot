package vn.techmaster.demothyme.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import vn.techmaster.demothyme.model.Employer;

@Getter
@Repository
public class EmployerRepository {
    private ArrayList<Employer> employers;

    public EmployerRepository(){
        employers = new ArrayList<>(List.of(new Employer("Company A", "Address A", "Contact A"), new Employer("Company B", "Address B", "Contact B"), new Employer("Company C", "Address C", "Contact C")));
    }
}
