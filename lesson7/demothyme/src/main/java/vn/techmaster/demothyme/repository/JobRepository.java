package vn.techmaster.demothyme.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import vn.techmaster.demothyme.model.Job;

@Getter
@Repository
public class JobRepository {
    private ArrayList<Job> jobs;

    public JobRepository() {
        jobs = new ArrayList<>(List.of(new Job("description A", "detail A", "requirement A"),
                new Job("description B", "detail B", "requirement B"),
                new Job("description C", "detail C", "requirement C")));
    }

}
