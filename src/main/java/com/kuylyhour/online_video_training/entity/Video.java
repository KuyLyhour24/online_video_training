package com.kuylyhour.online_video_training.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="videos")
@Data
public class Video {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="title")
	private String title;
	
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course couresId;
	
	@Column(name="description")
	private String description;
	
	@Column(name="video_link")
	private String videoUrl;
	
	@Column(name="image_link")
	private String imageUrl;
	
	@Column(name="create_date")
	private LocalDateTime createDate;
	
	@Column(name="modified_date")
	private LocalDateTime modifiedDate;
	
	@Column(name="create_by")
	private String createBy;
	
	@Column(name="modified_by")
	private String modifiedBy;

}
