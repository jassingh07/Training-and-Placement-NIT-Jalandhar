package in.nitj.tpo.controller;

import static in.nitj.tpo.Utils.RouteConstants.JOB_PORTAL;

import in.nitj.tpo.dto.JobOpeningDto;
import in.nitj.tpo.entity.JobOpening;
import in.nitj.tpo.entity.Student;
import in.nitj.tpo.service.JobService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(JOB_PORTAL)
public class JobOpeningController {
  private final JobService jobService;

  @PostMapping
  public JobOpening save( @RequestBody JobOpeningDto request){
    return jobService.save(request);
  }

  @GetMapping
  public List<JobOpening> getValidJobs(){
    return jobService.getValidJobs();
  }

  @GetMapping("/applicants/{jobId}")
  public List<Student> getApplicants(@PathVariable Integer jobId) {
    return jobService.getApplicants(jobId);
  }
}
