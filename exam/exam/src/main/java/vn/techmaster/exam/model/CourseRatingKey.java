package vn.techmaster.exam.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CourseRatingKey implements Serializable {

    @Column(name="student_id")
    Long studentId;
    @Column(name = "course_id")
    Long courseId;

}
