package org.videosharing.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
//todo add category, tags
@Table(name = "videos")
public class VideoModel {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "videos_generator")
    @SequenceGenerator(name = "videos_generator", sequenceName = "s_videos", allocationSize = 1)
    private Long id;
    private int likes;

    @Column(unique = true)
    private String name;

    @Column(name = "create_date")
    private Instant createDate;

    //todo probably should have been written on disk, saved link to the file here, check out postgresql docs if saving big files is alright for db
    @Lob
    private byte[] data;

    //todo replace with lombok builder
    public VideoModel(String name, byte[] data, Instant createDate, int likes) {
        this.name = name;
        this.data = data;
        this.createDate = createDate;
        this.likes = likes;
    }
}
