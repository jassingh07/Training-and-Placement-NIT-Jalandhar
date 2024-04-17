package in.nitj.tpo.controller;

import in.nitj.tpo.dto.AnnouncementDto;
import in.nitj.tpo.entity.Announcement;
import in.nitj.tpo.service.AnnouncementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static in.nitj.tpo.Utils.ControllerConstants.*;

@RestController
@RequestMapping(TPO)
@RequiredArgsConstructor
public class TpoController {
    private final AnnouncementService announcementService;
    @PostMapping(ANNOUNCEMENT)
    public Announcement saveNewAnnoucement(@RequestBody AnnouncementDto announcementDto){
        return announcementService.save(announcementDto);
    }
    @GetMapping(ANNOUNCEMENT)
    public List<AnnouncementDto> getAllAnnoucements(){
        return announcementService.getAllAnnoucements();
    }
}
