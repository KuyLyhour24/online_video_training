package com.kuylyhour.online_video_training.exception;

import org.springframework.http.HttpStatus;

import com.kuylyhour.online_video_training.entity.Category;

public class DuplicateValueException extends ApiException{

	public DuplicateValueException(String resourceName, String name) {
		super(HttpStatus.BAD_REQUEST, String.format("%s With Name = %s already exists",resourceName,name));
		
	}

}
