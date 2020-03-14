package com.base.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kurtisniedling on 2020-03-11.
 */

@RestController
public class HelloController extends BaseController {
    @RequestMapping(value = "hello")
    public String hello(){
        return "Hello! This is an example for Jetty's DoS filter. \n<br/><br/>" +
                "Press refresh multiple times quickly to see your requests throttled.\n<br/>" +
                "In your console you should see something like: <br/>" +
                "DOS ALERT: Request delayed=3000ms, ip=0:0:0:0:0:0:0:1, session=null, user=null";
    }
}
