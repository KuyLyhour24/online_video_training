package com.kuylyhour.online_video_training.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kuylyhour.online_video_training.dto.VideoUrlDTO;
import com.kuylyhour.online_video_training.entity.VideoUrl;
import com.kuylyhour.online_video_training.mapper.VideoUrlMapper;
import com.kuylyhour.online_video_training.service.VideoUrlService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("urls")
public class VideoUrlController {

	private final VideoUrlService videoUrlService;
	private final VideoUrlMapper urlMapper;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody VideoUrlDTO videoUrlDTO){
		VideoUrl save = videoUrlService.save(urlMapper.toVideoUrl(videoUrlDTO));
		return ResponseEntity.ok(urlMapper.toVideoUrlDTO(save));
	}
	@GetMapping("{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		VideoUrl videoUrl = videoUrlService.getById(id);
		return ResponseEntity.ok(videoUrl);
	}
	@PutMapping("update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id,@RequestBody VideoUrlDTO videoUrlDTO){
		VideoUrl videoUrl = urlMapper.toVideoUrl(videoUrlDTO);
		VideoUrl update = videoUrlService.update(id, videoUrl);
		return ResponseEntity.ok(update);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		videoUrlService.delete(id);
		return ResponseEntity.ok().build();
	}

}
