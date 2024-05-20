package in.nitj.tpo.repository;

import in.nitj.tpo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Student> findByOfficialEmailId(String officialEmailId);
}
