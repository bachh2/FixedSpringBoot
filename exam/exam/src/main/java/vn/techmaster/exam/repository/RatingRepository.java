package vn.techmaster.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import vn.techmaster.exam.model.Student;

public interface RatingRepository extends JpaRepository {
      

    // • Viết Native Query để tính điểm trung bình một môn bất kỳ
    @Query(value = "select AVG from ratings r where r.courseId = ?1", nativeQuery = true)
    Student myCustomQuery2(long courseId);

    // • Liệt kê danh sách sinh viên học math nhưng không học music
    @Query(value = "select * from student s where s.id in(select * from ratings r where r.course", nativeQuery = true)
    List<Student> myCustomQuery3();

    // Trả về liệt kê sinh viên tham gia từng môn học Map<String, List<Student>>:key
    // là tên môn học, value là danh sách sinh viên đăng ký

    
}
