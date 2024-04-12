package in.nitj.tpo.repository;

import in.nitj.tpo.entity.JobDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobDocsRepository extends JpaRepository<JobDocument, Integer> {

}
