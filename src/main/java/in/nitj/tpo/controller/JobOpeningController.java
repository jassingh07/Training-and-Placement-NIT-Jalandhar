package in.nitj.tpo.controller;

import static in.nitj.tpo.Utils.RouteConstants.JOB_PORTAL;

import in.nitj.tpo.dto.JobOpeningDto;
import in.nitj.tpo.entity.JobOpening;
import in.nitj.tpo.service.JobService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
  public List<JobOpeningDto> getValidJobs(){
    return jobService.getValidJobs();
  }
}
