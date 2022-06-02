package vn.techmaster.exam.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Product> products;
    
}
