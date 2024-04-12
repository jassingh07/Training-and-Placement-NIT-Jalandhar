package in.nitj.tpo.repository;

import in.nitj.tpo.entity.JobOpening;
import java.time.Instant;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<JobOpening,Integer> {
  List<JobOpening> findByClosingTimeGreaterThanEqual(Instant currentTime);
}
