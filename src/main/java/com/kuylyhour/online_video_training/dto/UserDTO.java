package com.kuylyhour.online_video_training.dto;

import java.time.LocalDateTime;

import com.kuylyhour.online_video_training.entity.GenderEnum;
import com.kuylyhour.online_video_training.entity.RoleEnum;

import lombok.Data;

@Data
public class UserDTO {

	private String username;

	private String password;

	private String email;

	private Integer phoneNumber;

	private GenderEnum gender;

	private RoleEnum role;

	private String photo;

	private LocalDateTime joinDate;
}
