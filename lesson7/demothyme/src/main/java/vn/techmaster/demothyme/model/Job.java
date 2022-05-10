package vn.techmaster.demothyme.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Job {
    private String description;
    private String detail;
    private String requirement;
}
