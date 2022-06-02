package vn.techmaster.exam.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "course")
@Table(name = "course")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    private long id;
    private String name;

    @OneToMany(mappedBy = "course")
    List<CourseRating> ratings;
}