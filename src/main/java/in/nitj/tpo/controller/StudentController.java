package in.nitj.tpo.controller;

import static in.nitj.tpo.Utils.RouteConstants.STUDENT_PORTAL;

import in.nitj.tpo.dto.JobApplyDto;
import in.nitj.tpo.dto.StudentDto;
import in.nitj.tpo.entity.Student;
import in.nitj.tpo.service.StudentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
  @PostMapping("/apply")
  public ResponseEntity<String> applyForJob(@RequestBody JobApplyDto jobApplyDto) {
    studentService.applyForJob(jobApplyDto.getJobId(), jobApplyDto.getRollNumber());
    return ResponseEntity.ok("Application successful");
  }
}
