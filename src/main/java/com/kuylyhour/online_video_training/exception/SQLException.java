package com.kuylyhour.online_video_training.exception;

import org.springframework.http.HttpStatus;

public class SQLException extends ApiException {

	public SQLException(String resourceName, Long id) {
		super(HttpStatus.BAD_REQUEST, String.format("%s With id = %d is still referenced from other table",resourceName,id));
	}

}
