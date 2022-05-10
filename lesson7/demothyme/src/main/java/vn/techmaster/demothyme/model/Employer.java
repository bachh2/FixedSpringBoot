package vn.techmaster.demothyme.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employer {
    
    private String name;
    private String address;
    private String contact;

    public Employer() {
    }
}
