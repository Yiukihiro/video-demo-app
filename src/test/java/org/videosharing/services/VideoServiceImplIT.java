package org.videosharing.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;
import org.videosharing.domain.VideoModel;
import org.videosharing.repo.VideoRepo;

import javax.transaction.Transactional;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

@SpringBootTest
@Transactional
public class VideoServiceImplIT {
    @Autowired
    VideoService service;

    @Autowired
    VideoRepo repo;

    String testName = "myVid";

    @Test
    void getVideo() {
        VideoModel expected = new VideoModel(testName, null);
        repo.save(expected);
        VideoModel actual = service.getVideo(testName);
        // The result from service.getVideo(testName) should be expected Video instance above
        assertEquals(expected, actual);
    }


    @Test
    void saveVideo() throws IOException {
        MultipartFile file = mock(MultipartFile.class);
        service.saveVideo(file, testName);
        // After saving the video using the service, the repository should say that the video exists
        assertTrue(repo.existsByName(testName));
    }

    @Test
    void getAllVideoNames() {
        //TODO
//        List<String> expected = List.of(testName);
//        repo.save(new Video(testName, null));
//        List<String> actual = service.getAllVideoNames();
//        // Check the service returns a list of the same contents as the expected list of videos
//        assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
    }
}
