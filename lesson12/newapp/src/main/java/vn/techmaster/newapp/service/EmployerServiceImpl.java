package vn.techmaster.newapp.service;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.newapp.dto.EmployerRequest;
import vn.techmaster.newapp.error.ResourceNotFoundException;
import vn.techmaster.newapp.model.Employer;
import vn.techmaster.newapp.repository.EmployerRepository;

@Service
public class EmployerServiceImpl implements EmployerService {
    @Autowired
    private StorageService storageService;
    @Autowired
    private EmployerRepository employerRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Employer> getAllEmployers() {
        return employerRepo.getAll();
    }

    @Override
    public Employer getEmployerById(String employerId) {
        return employerRepo.getById(employerId)
                .orElseThrow(() -> new ResourceNotFoundException("employer.id.notExisted", null));
    }

    @Override
    public List<Employer> getEmployersByName(String employerName) {
        return employerRepo.getByName(employerName);
    }

    @Override
    public Employer addEmployer(EmployerRequest employerRequest) {
        Employer employer2Add = modelMapper.map(employerRequest, Employer.class);
        employer2Add.setId(UUID.randomUUID().toString());
        String logoPath = storageService.saveFile(employerRequest.getLogo(), employer2Add.getId());
        employer2Add.setLogoPath(logoPath);
        employerRepo.save(employer2Add);
        return employer2Add;
    }

    @Override
    public Employer updateEmployer(Employer employer) {
        getEmployerById(employer.getId());
        employerRepo.save(employer);
        return employer;
    }

    @Override
    public void delete(String employerId) {
        getEmployerById(employerId);
        employerRepo.delete(employerId);
    }
}
