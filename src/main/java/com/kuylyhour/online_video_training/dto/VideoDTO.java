package com.kuylyhour.online_video_training.dto;

import com.kuylyhour.online_video_training.entity.Course;

import lombok.Data;

@Data
public class VideoDTO {
	private  Long courseId;
	private  Long levelId;
	private String description;
	private String imageUrl;

}
