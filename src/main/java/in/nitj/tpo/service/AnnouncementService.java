package in.nitj.tpo.service;

import in.nitj.tpo.dto.AnnouncementDto;
import in.nitj.tpo.dto.DocumentDto;
import in.nitj.tpo.entity.AnnoucementAttachments;
import in.nitj.tpo.entity.Announcement;
import in.nitj.tpo.repository.AnnouncementAttachmentRepository;
import in.nitj.tpo.repository.AnnouncementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static in.nitj.tpo.Utils.Transformers.toAnnoucementAttachments;
import static in.nitj.tpo.Utils.Transformers.toAnnoucementEntity;

@Service
@RequiredArgsConstructor
public class AnnouncementService {

    private final AnnouncementRepository announcementRepository;
    private final AnnouncementAttachmentRepository announcementAttachmentRepository;

    public Announcement save(AnnouncementDto announcementDto) {
        Announcement announcement = toAnnoucementEntity(announcementDto);
        Announcement savedAnnoucement = announcementRepository.save(announcement);

        List<AnnoucementAttachments> annoucementAttachmentsList = toAnnoucementAttachments(announcementDto.getRelatedFiles(), savedAnnoucement);
        annoucementAttachmentsList.forEach(announcementAttachmentRepository::save);
        return savedAnnoucement;
    }

    public List<AnnouncementDto> getAllAnnoucements() {
        return announcementRepository.findAll()
                .stream()
                .map(ar -> AnnouncementDto.builder()
                        .content(ar.getContent())
                        .creationTime(ar.getCreationTime())
                        .relatedFiles(
                                announcementAttachmentRepository.findAllById(Collections.singletonList(ar.getAnnouncementId()))
                                        .stream()
                                        .map(aa -> DocumentDto.builder()
                                                .link(aa.getLink())
                                                .fileName(aa.getFileName())
                                                .build()
                                        )
                                        .collect(Collectors.toList())
                        )
                        .build()
                )
                .collect(Collectors.toList());
    }
}

