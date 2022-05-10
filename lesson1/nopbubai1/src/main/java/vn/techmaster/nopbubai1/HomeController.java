package vn.techmaster.nopbubai1;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.techmaster.nopbubai1.dto.AddStudent;
import vn.techmaster.nopbubai1.model.Student;


@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping("/random")
    @ResponseBody
    public String random() {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        String result = "";
        for (int i = 0; i < 8; i++) {
            int random = (int) (Math.random() * 61 + 1);
            result = result + alphabet[random];
        }
        return result;
    }

    @GetMapping("/quote")
    @ResponseBody
    public String quote() {
        int random = (int) (Math.random() * 4 + 1);
        String[] quoteList = { "Kiến tha lâu đầy tổ", " Có công mài sắt , có ngày nên kim", "Không thầy đố mày làm nên",
                "Học thầy không tày học bạn" };
        return quoteList[random];
    }

    @GetMapping("/bmi/{h}/{w}")
    @ResponseBody
    public float bmi(@PathVariable("h") float h, @PathVariable("w") float w) {
        return w / (h * h);
    }
    
    private ConcurrentHashMap<String, Student> students;

    @GetMapping("/student")
    @ResponseBody
    public List<Student> showStudent() {
        return students.values().stream().toList();
    }

    @PostMapping
    public ResponseEntity<Student> addNewStudent(@RequestBody AddStudent addStudent) {
        String uuid = UUID.randomUUID().toString();
        Student newStudent = new Student(uuid, addStudent.name());
        students.put(uuid, newStudent);
        return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
    }
}
