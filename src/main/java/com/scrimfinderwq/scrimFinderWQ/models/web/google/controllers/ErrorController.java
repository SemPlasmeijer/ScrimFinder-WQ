package com.scrimfinderwq.scrimFinderWQ.models.web.google.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping("/unauthorized")
    public String unauthorized() {
        return "errors/unauthorized";
    }

    @GetMapping("/error")
    public String error() {
        return "errors/unauthorized";
    }
}