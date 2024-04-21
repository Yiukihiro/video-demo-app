package org.videosharing.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @Column(unique = true)
    private String name;

    //todo probably should have been written on disk, saved link to the file here, check out postgresql docs if saving big files is alright for db
    @Lob
    private byte[] data;

    //todo replace with lombok builder
    public VideoModel(String name, byte[] data) {
        this.name = name;
        this.data = data;
    }
    //todo create date required for sorting
}
