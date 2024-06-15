package com.kuylyhour.online_video_training.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="_users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone_number")
	private Integer phoneNumber;
	
	@Column(name="gender")
	private GenderEnum gender;
	
	@Column(name="role")
	private RoleEnum role;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="join_date")
	private LocalDateTime joinDate;
	

}
