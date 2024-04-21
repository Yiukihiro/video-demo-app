package org.videosharing.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;
import org.videosharing.services.VideoService;

import static org.mockito.Mockito.mock;

@SpringBootTest
class VideoControllerIT {

    @Autowired
    VideoController controller;
    @Autowired
    VideoService service;
    MultipartFile file = mock(MultipartFile.class);

    @Test
    void saveVideo(){

        

    }

}