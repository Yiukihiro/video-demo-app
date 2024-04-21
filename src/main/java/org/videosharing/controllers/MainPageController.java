package org.videosharing.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.videosharing.services.VideoService;

import java.util.HashMap;

@RestController
@AllArgsConstructor
public class MainPageController {

    @GetMapping(value = "/")
    public ModelAndView index() {
        //todo move upload to admin panel, video view to another page
        return new ModelAndView("index");
    }
}
