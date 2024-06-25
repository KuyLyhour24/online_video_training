package com.kuylyhour.online_video_training.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class CourseDTO {
	@NonNull
	private Integer categoryId;
	@NonNull
	private String name;
	
}
