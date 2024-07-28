package com.kuylyhour.online_video_training.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Table(name="videos", uniqueConstraints = {@UniqueConstraint(columnNames= {"course_id", "level_id"})})
@Data
public class Video {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="title")
	private String title;
	
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;
	@ManyToOne
	@JoinColumn(name="level_id")
	private Level level;
	
	private BigDecimal price;
	
	@Column(name="description")
	private String description;
	
	@Column(name="image_link")
	private String imageUrl;
	
	private String createBy;
	private String updateBy;
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime updateDate = LocalDateTime.now();
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime createDate = LocalDateTime.now();

}
