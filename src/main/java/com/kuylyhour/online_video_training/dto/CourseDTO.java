package com.kuylyhour.online_video_training.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
	@NonNull
	private Long categoryId;
	@NonNull
	private String name;
	
}
