package in.nitj.tpo.Utils;
import in.nitj.tpo.dto.AnnouncementDto;
import in.nitj.tpo.dto.DocumentDto;
import in.nitj.tpo.dto.JobOpeningDto;
import in.nitj.tpo.dto.StudentDto;
import in.nitj.tpo.entity.*;

import java.util.List;
import java.util.stream.Collectors;

public class Transformers {
  public static JobOpening toJobOpeningEntity(JobOpeningDto jobOpeningDto){
    return JobOpening.builder()
    .jobId(jobOpeningDto.getJobId())
        .companyName(jobOpeningDto.getCompanyName())
        .position(jobOpeningDto.getPosition())
        .closingTime(jobOpeningDto.getClosingTime())
        .build();
  }
  public static Student toStudentEntity(StudentDto studentDto){
    return Student.builder()
        .activeBacklogs(studentDto.isActiveBacklogs())
        .branch(studentDto.getBranch())
        .cgpa(studentDto.getCgpa())
        .firstName(studentDto.getFirstName())
        .lastName(studentDto.getLastName())
        .officialEmailId(studentDto.getOfficialEmailId())
        .personalEmailId(studentDto.getPersonalEmailId())
        .rollNumber(studentDto.getRollNumber())
        .tenthPercentage(studentDto.getTenthPercentage())
        .twelvePercentage(studentDto.getTwelvePercentage())
        .phoneNumberWithoutCountryCode(studentDto.getPhoneNumberWithoutCountryCode())
        .build();
  }
  public static List<Resume> toResumeEntity(List<DocumentDto> resumeDtoList, Student student){
    return resumeDtoList.stream()
        .map(resume -> Resume.builder()
            .rollNumber(student.getRollNumber())
            .file_name(resume.getFileName())
            .link(resume.getLink())
            .student(student)
            .build())
        .collect(Collectors.toList());
  }
  public static List<JobDocument> toJobDocumentEntity(List<DocumentDto> jobDocumentDtoList, JobOpening savedOpening){
    return jobDocumentDtoList.stream()
        .map(jdl -> JobDocument.builder()
            .jobId(savedOpening.getJobId())
            .fileName(jdl.getFileName())
            .link(jdl.getLink())
            .jobOpening(savedOpening)
            .build())
        .collect(Collectors.toList());
  }
  public static Announcement toAnnoucementEntity(AnnouncementDto announcementDto){
    return Announcement.builder()
            .content(announcementDto.getContent())
            .creationTime(announcementDto.getCreationTime())
            .build();
  }
  public static List<AnnoucementAttachments> toAnnoucementAttachments(List<DocumentDto> annoucementAttachedFilesList, Announcement announcement){
    return annoucementAttachedFilesList.stream()
            .map(aafl -> AnnoucementAttachments.builder()
                    .announcement(announcement)
                    .fileName(aafl.getFileName())
                    .link(aafl.getLink())
                    .build()
            )
            .collect(Collectors.toList());
  }
}
