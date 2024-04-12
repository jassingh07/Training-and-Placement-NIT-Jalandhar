package in.nitj.tpo.service;

import static in.nitj.tpo.Utils.Transformers.toResumeEntity;
import static in.nitj.tpo.Utils.Transformers.toStudentEntity;

import in.nitj.tpo.dto.StudentDto;
import in.nitj.tpo.entity.Resume;
import in.nitj.tpo.entity.Student;
import in.nitj.tpo.repository.ResumeRepository;
import in.nitj.tpo.repository.StudentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
  private final StudentRepository studentRepository;
  private final ResumeRepository resumeRepository;
  public Student save(StudentDto request){
    Student student = toStudentEntity(request);
    Student savedStudent = studentRepository.save(student);

    List<Resume>  resumeList = toResumeEntity(request.getResumeDtoList(), savedStudent);
    resumeList.stream()
        .forEach(document -> resumeRepository.save(document));

    return savedStudent;
  }
  public List<Student> findAll(){
    return studentRepository.findAll();
  }

}
