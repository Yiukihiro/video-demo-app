package org.videosharing.services;

import org.springframework.web.multipart.MultipartFile;
import org.videosharing.domain.VideoModel;
import org.videosharing.dto.VideoInfoDto;

import java.io.IOException;
import java.util.List;

public interface VideoService {
    VideoModel getVideo(String name);

    void saveVideo(MultipartFile file, String name) throws IOException;

    List<VideoInfoDto> getAllVideoNames();
}
