package in.nitj.tpo.service;

import static in.nitj.tpo.Utils.Transformers.toJobDocumentEntity;
import static in.nitj.tpo.Utils.Transformers.toJobOpeningEntity;

import in.nitj.tpo.dto.JobOpeningDto;
import in.nitj.tpo.entity.JobDocument;
import in.nitj.tpo.entity.JobOpening;
import in.nitj.tpo.repository.JobDocsRepository;
import in.nitj.tpo.repository.JobRepository;
import java.time.Instant;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobService {
  private final JobRepository jobRepository;
  private final JobDocsRepository jobDocsRepository;
  public JobOpening save(JobOpeningDto jobOpeningDto){
    JobOpening jobOpening = toJobOpeningEntity(jobOpeningDto);
    JobOpening savedOpening =  jobRepository.save(jobOpening);
    //first save referenced entity, to take a reference :)

    List<JobDocument> jobDocumentList = toJobDocumentEntity(jobOpeningDto.getJobDocumentDtoList(), savedOpening);
    jobDocumentList
        .forEach(jobDocsRepository::save);
    
    return savedOpening;
  }
  public List<JobOpening> getValidJobs(){
    return jobRepository.findByClosingTimeGreaterThanEqual(Instant.now());
  }
}
