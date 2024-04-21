package org.videosharing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.videosharing.domain.VideoModel;

import java.util.List;

@Repository
public interface VideoRepo extends JpaRepository<VideoModel, Long> {
    VideoModel findByName(String name);

    boolean existsByName(String name);

    @Query(nativeQuery = true, value="SELECT * FROM videos")
    List<VideoModel> getAllEntryNames();
}
