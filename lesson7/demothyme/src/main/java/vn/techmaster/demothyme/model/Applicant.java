package vn.techmaster.demothyme.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Applicant {
    private String name;
    private String address;
    private int phone;

}
