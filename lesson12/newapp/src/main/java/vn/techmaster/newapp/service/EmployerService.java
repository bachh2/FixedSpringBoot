package vn.techmaster.newapp.service;

import java.util.List;

import vn.techmaster.newapp.dto.EmployerRequest;
import vn.techmaster.newapp.model.Employer;

public interface EmployerService {
    List<Employer> getAllEmployers();

    Employer getEmployerById(String employerId);

    List<Employer> getEmployersByName(String employerName);

    Employer addEmployer(EmployerRequest employerRequest);

    Employer updateEmployer(Employer employer);

    void delete(String employerId);

}