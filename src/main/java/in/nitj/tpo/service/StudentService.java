package in.nitj.tpo.service;

import static in.nitj.tpo.Utils.Transformers.toResumeEntity;
import static in.nitj.tpo.Utils.Transformers.toStudentEntity;

import in.nitj.tpo.dto.StudentDto;
import in.nitj.tpo.entity.JobOpening;
import in.nitj.tpo.entity.Resume;
import in.nitj.tpo.entity.Student;
import in.nitj.tpo.repository.JobRepository;
import in.nitj.tpo.repository.ResumeRepository;
import in.nitj.tpo.repository.StudentRepository;
import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
  private final StudentRepository studentRepository;
  private final JobRepository jobRepository;
  public Student save(StudentDto request){
    Student student = toStudentEntity(request);
    List<Resume>  resumeList = toResumeEntity(request.getResumeDtoList(), student);
    student.setResumes(resumeList);
    return studentRepository.save(student);
  }
  public List<Student> findAll(){
    return studentRepository.findAll();
  }

  @Transactional
  public void applyForJob(Integer jobId, Integer rollNumber) {
    Student student = studentRepository.findById(rollNumber)
            .orElseThrow(() -> new EntityNotFoundException("Student not found"));

    JobOpening jobOpening = jobRepository.findById(jobId)
            .orElseThrow(() -> new EntityNotFoundException("Job opening not found"));
    student.getAppliedJobs().add(jobOpening);
    jobOpening.getApplicants().add(student);

    // Save both entities to update the join table
    studentRepository.save(student);
    jobRepository.save(jobOpening);
  }
}
