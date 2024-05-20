package in.nitj.tpo.service;

import static in.nitj.tpo.Utils.Transformers.toJobDocumentEntity;
import static in.nitj.tpo.Utils.Transformers.toJobOpeningEntity;

import in.nitj.tpo.dto.DocumentDto;
import in.nitj.tpo.dto.JobOpeningDto;
import in.nitj.tpo.entity.JobDocument;
import in.nitj.tpo.entity.JobOpening;
import in.nitj.tpo.entity.Student;
import in.nitj.tpo.repository.JobDocsRepository;
import in.nitj.tpo.repository.JobRepository;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobService {
  private final JobRepository jobRepository;
  private final JobDocsRepository jobDocsRepository;
  public JobOpening save(JobOpeningDto jobOpeningDto){
    JobOpening jobOpening = toJobOpeningEntity(jobOpeningDto);
    List<JobDocument> jobDocumentList = toJobDocumentEntity(jobOpeningDto.getJobDocumentDtoList(), jobOpening);

    jobOpening.setJobDocuments(jobDocumentList);
    return jobRepository.save(jobOpening);
  }

    @Transactional
    public List<Student> getApplicants(Integer jobId) {
        JobOpening jobOpening = jobRepository.findById(jobId)
                .orElseThrow(() -> new EntityNotFoundException("Job opening not found"));

        return jobOpening.getApplicants();
    }

  public List<JobOpening> getValidJobs(){
    return jobRepository.findByClosingTimeGreaterThanEqual(Instant.now());
  }
}
