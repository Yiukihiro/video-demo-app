package org.videosharing.controllers;

import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.videosharing.domain.VideoModel;
import org.videosharing.dto.VideoInfoDto;
import org.videosharing.services.VideoService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("video")
@AllArgsConstructor
public class VideoController {

    private VideoService videoService;

    // Each parameter annotated with @RequestParam corresponds to a form field where the String argument is the name of the field
    @PostMapping()
    public ResponseEntity<String> saveVideo(@RequestParam("file") MultipartFile file, @RequestParam("name") String name) throws IOException {
        //todo hide upload to admin page, require authentication
        videoService.saveVideo(file, name);
        //todo check out if ok response is json
        return ResponseEntity.ok("Video saved successfully.");
    }

    // {name} is a path variable in the url. It is extracted as the String parameter annotated with @PathVariable
    @GetMapping("data/{name}")
    public ResponseEntity<Resource> getVideoByName(@PathVariable("name") String name) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new ByteArrayResource(videoService.getVideo(name).getData()));


    }


    @GetMapping()
    //todo replace response entity with dto instead of domain db object
    public ResponseEntity<List<VideoInfoDto>> getAllVideoNames() {
        //todo replace method with sorting and pagination for index page
        return ResponseEntity
                .ok(videoService.getAllVideoNames());

    }

    @PostMapping("likes/{name}")
    public ResponseEntity<Void> likes(@PathVariable("name") String name) throws IOException {
        videoService.addLikes(name);
        return ResponseEntity.ok().build();
    }

}
