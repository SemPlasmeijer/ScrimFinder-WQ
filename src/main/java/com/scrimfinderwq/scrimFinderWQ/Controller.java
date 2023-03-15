package com.scrimfinderwq.scrimFinderWQ;

import com.scrimfinderwq.scrimFinderWQ.models.workqueues.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private Producer producer;

    @GetMapping("/hello")
    public String hello(){

        return "Hello";
    }

    @GetMapping("/docker")
    public String docker(){return "Hello from Docker container again! sem";}

    @GetMapping("/docker1")
    public String docker1(){return "It has better work this time !!! And ti worked :)";}

    @GetMapping("/fun")
    public String fun(){return "Remote reloading is fun! This should reload too";}

    @GetMapping("/fun1")
    public String fun1(){return "Lets see if this reloads. And reload again! And again!";}

}