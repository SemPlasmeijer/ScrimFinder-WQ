package com.scrimfinderwq.scrimFinderWQ.models.web.google;

import com.scrimfinderwq.scrimFinderWQ.models.google.DriveFiles;
import com.scrimfinderwq.scrimFinderWQ.models.web.google.enums.SessionKey;
import com.scrimfinderwq.scrimFinderWQ.models.web.google.service.GoogleDriveService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class EventsController {

    private final GoogleDriveService googleDriveService;

    @RequestMapping("/files")
    public DriveFiles getDriveEvents(HttpSession session, Model model) throws Exception {
        String accessToken = session.getAttribute(SessionKey.GOOGLE_OAUTH_TOKEN.toString()) == null
                ? "" : session.getAttribute(SessionKey.GOOGLE_OAUTH_TOKEN.toString()).toString();

        if (accessToken == null || accessToken.isBlank()) {
            throw new Exception();
        }
        DriveFiles driveFiles = googleDriveService.getDriveFiles(accessToken);
        return driveFiles;
    }
}
