package in.nitj.tpo.controller;

import static in.nitj.tpo.Utils.ControllerConstants.STUDENT_PORTAL;

import in.nitj.tpo.dto.StudentDto;
import in.nitj.tpo.entity.Student;
import in.nitj.tpo.service.StudentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(STUDENT_PORTAL)
public class StudentController {
  private final StudentService studentService;

  @PostMapping
  public Student save(@RequestBody StudentDto request){
    return studentService.save(request);
  }
  @GetMapping
  public List<Student> getAllStudents(){
    return studentService.findAll();
  }
}
