package org.videosharing.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
//short video dto for lazy loading of data field
public class VideoInfoDto {
    private Long id;
    private String name;
    private int likes;


}
