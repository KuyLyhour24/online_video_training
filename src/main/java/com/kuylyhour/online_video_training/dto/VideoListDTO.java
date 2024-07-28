package com.kuylyhour.online_video_training.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kuylyhour.online_video_training.entity.VideoUrl;

import lombok.Data;

@Data
public class VideoListDTO {

	private String name;
	private String url;
}
