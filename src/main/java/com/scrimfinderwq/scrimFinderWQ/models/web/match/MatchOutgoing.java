package com.scrimfinderwq.scrimFinderWQ.models.web.match;

import com.scrimfinderwq.scrimFinderWQ.models.workqueues.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/out/wq")
public class MatchOutgoing {

    @Autowired
    private Producer producer;

    @GetMapping("/hello")
    public String hello() {

        return "Hello";
    }
}
