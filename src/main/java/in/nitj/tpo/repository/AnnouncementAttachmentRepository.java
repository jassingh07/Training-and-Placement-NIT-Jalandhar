package in.nitj.tpo.repository;

import in.nitj.tpo.entity.AnnoucementAttachments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementAttachmentRepository extends JpaRepository<AnnoucementAttachments, Integer> {
}
