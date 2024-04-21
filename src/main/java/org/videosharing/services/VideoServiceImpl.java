package org.videosharing.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.videosharing.domain.VideoModel;
import org.videosharing.dto.VideoInfoDto;
import org.videosharing.exceptions.VideoAlreadyExistsException;
import org.videosharing.exceptions.VideoNotFoundException;
import org.videosharing.repo.VideoRepo;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class VideoServiceImpl implements VideoService {

    private VideoRepo repo;

    @Override
    @Transactional
    public VideoModel getVideo(String name) {
        if (!repo.existsByName(name)) {
            throw new VideoNotFoundException();
        }
        return repo.findByName(name);
    }

    @Override
    @Transactional
    public List<VideoInfoDto> getAllVideoNames() {
        return repo.getAllEntryNames().stream().map(v -> VideoInfoDto.builder()
                .id(v.getId())
                .name(v.getName())
                .build())
                .toList();
    }

    @Override
    @Transactional
    public void saveVideo(MultipartFile file, String name) throws IOException {
        if (repo.existsByName(name)) {
            throw new VideoAlreadyExistsException();
        }
        VideoModel newVid = new VideoModel(name, file.getBytes());
        repo.save(newVid);
    }

}
