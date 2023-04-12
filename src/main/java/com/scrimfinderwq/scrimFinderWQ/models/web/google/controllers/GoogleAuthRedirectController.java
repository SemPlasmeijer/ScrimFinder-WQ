package com.scrimfinderwq.scrimFinderWQ.models.web.google.controllers;

import com.scrimfinderwq.scrimFinderWQ.models.web.google.enums.SessionKey;
import com.scrimfinderwq.scrimFinderWQ.models.web.google.service.OauthTokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Stream;


@Controller
public class GoogleAuthRedirectController {

    private final OauthTokenService oauthTokenService;

    public GoogleAuthRedirectController(OauthTokenService oauthTokenService) {
        this.oauthTokenService = oauthTokenService;
    }
    @RequestMapping("/oauth2/callback/google")
    public String callbackUrl(HttpServletRequest request, HttpSession httpSession) throws Exception {
        try {
            if(request.getParameter("access_denied") != null || request.getParameter("Error") != null) {
                throw new Exception();
            }

            String code = request.getParameter("code");

            String[] scopes = request.getParameter("scope").split(" ");
            String scopeWithPermission = Stream.of(scopes).filter(s -> s.contains("drive")).findFirst().orElseThrow();
            httpSession.setAttribute(String.valueOf(SessionKey.GOOGLE_OAUTH_TOKEN),
                    oauthTokenService.fetchToken(code, scopeWithPermission)
            );

            return "redirect:/files";
        }
        catch (Exception e) {
           throw e;
        }
    }
}
