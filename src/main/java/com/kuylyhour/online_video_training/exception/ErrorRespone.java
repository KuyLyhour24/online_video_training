package com.kuylyhour.online_video_training.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class ErrorRespone {
	private HttpStatus status;
	private String message;

}
