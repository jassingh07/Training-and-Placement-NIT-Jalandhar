package in.nitj.tpo.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class AnnoucementAttachments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer announcementId;

    @ManyToOne
    @JoinColumn(name = "announcement_id", nullable = false)
    private Announcement announcement;
    private String link;
    private String fileName;
}
