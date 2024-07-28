package com.kuylyhour.online_video_training.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;

	private String password;

	private String email;

	private Integer phoneNumber;

	private GenderEnum gender;

	private RoleEnum userRole;

	private String photo;
	private String verifiedCode;
	private boolean enable;

	@Temporal(TemporalType.TIMESTAMP)
	private final LocalDateTime joinDate = LocalDateTime.now();

}
